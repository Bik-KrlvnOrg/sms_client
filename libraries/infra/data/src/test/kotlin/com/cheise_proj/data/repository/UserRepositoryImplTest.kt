package com.cheise_proj.data.repository

import com.cheise_proj.data.extension.asEntity
import com.cheise_proj.data.source.local.LocalUser
import com.cheise_proj.data.source.remote.RemoteUser
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations
import utils.FakeUser

@RunWith(JUnit4::class)
class UserRepositoryImplTest {

    companion object {
        private const val USER_NAME = "any_username"
        private const val USER_PASSWORD = "any_password"
        private const val ERROR_MESSAGE = "an error occurred"
        private const val USER_TYPE = "STAFF"
    }

    private lateinit var userRepositoryImpl: UserRepositoryImpl

    @Mock
    lateinit var localUser: LocalUser

    @Mock
    lateinit var remoteUser: RemoteUser

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        userRepositoryImpl = UserRepositoryImpl(remote = remoteUser, local = localUser)
    }

    @Test
    fun `should fetch user data from remote and save to local`() {
        val user = FakeUser.getUser()

        Mockito.`when`(remoteUser.fetchUserToken(anyString(), anyString(), anyString())).thenReturn(
            Observable.just(user)
        )
        Mockito.`when`(localUser.getUser(anyString(), anyString(), anyString()))
            .thenReturn(Single.just(user))


        userRepositoryImpl.getUser(username = USER_NAME, password = USER_PASSWORD, type = USER_TYPE)
            .test()
            .assertValueCount(2)
            .assertValues(user.asEntity(), user.asEntity())
            .assertComplete()

        Mockito.verify(localUser, times(1)).addUser(user)
    }

    @Test
    fun `should get user data from local when remote fails`() {
        val user = FakeUser.getUser()

        Mockito.`when`(remoteUser.fetchUserToken(anyString(), anyString(), anyString())).thenReturn(
            Observable.error(Throwable(ERROR_MESSAGE))
        )
        Mockito.`when`(localUser.getUser(anyString(), anyString(), anyString()))
            .thenReturn(Single.just(user))

        userRepositoryImpl.getUser(username = USER_NAME, password = USER_PASSWORD, type = USER_TYPE)
            .test()
            .assertValueCount(1)
            .assertValue(user.asEntity())
            .assertComplete()

        Mockito.verify(localUser, times(0)).addUser(user)
    }

    @Test
    fun `should get profile data with identifier`() {
        val user = FakeUser.getUser()
        val actual = FakeUser.getProfile()

        Mockito.`when`(remoteUser.fetchProfile(anyString())).thenReturn(
            Observable.just(actual)
        )
        Mockito.`when`(localUser.getUser(Mockito.anyInt()))
            .thenReturn(Single.just(user))

        Mockito.`when`(localUser.getProfile(Mockito.anyInt()))
            .thenReturn(Single.just(actual))

        userRepositoryImpl.getProfile(Mockito.anyInt())
            .test()
            .assertValueAt(0, actual.asEntity())
            .assertValueAt(1, actual.asEntity())
            .assertValueCount(2)
            .assertComplete()

        Mockito.verify(localUser, times(1)).getUser(Mockito.anyInt())
        Mockito.verify(remoteUser, times(1)).fetchProfile(anyString())
        Mockito.verify(localUser, times(1)).addProfile(actual)
    }

    @Test
    fun `should get profile data from cache on remote error with identifier`() {
        val user = FakeUser.getUser()
        val actual = FakeUser.getProfile()

        Mockito.`when`(remoteUser.fetchProfile(anyString())).thenReturn(
            Observable.error(Throwable(ERROR_MESSAGE))
        )
        Mockito.`when`(localUser.getUser(Mockito.anyInt()))
            .thenReturn(Single.just(user))

        Mockito.`when`(localUser.getProfile(Mockito.anyInt()))
            .thenReturn(Single.just(actual))

        userRepositoryImpl.getProfile(Mockito.anyInt())
            .test()
            .assertValueCount(1)
            .assertComplete()

        Mockito.verify(localUser, times(1)).getUser(Mockito.anyInt())
        Mockito.verify(remoteUser, times(1)).fetchProfile(anyString())
    }

}