package com.cheise_proj.local_source.source

import com.cheise_proj.local_source.db.dao.UserDao
import com.cheise_proj.local_source.extension.asEntity
import com.cheise_proj.local_source.extension.asModel
import com.cheise_proj.local_source.utils.FakeUser
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class LocalUserImplTest {
    companion object {
        private const val USERNAME = "any_username"
        private const val USER_PASSWORD = "any_password"
        private const val USER_TYPE = "any_type"
        private const val USER_ID = 1
    }

    private lateinit var localUserImpl: LocalUserImpl

    @Mock
    lateinit var userDao: UserDao

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        localUserImpl = LocalUserImpl(userDao)
    }

    @Test
    fun `should insert new user object`() {
        val actual = FakeUser.getUser()
        localUserImpl.addUser(actual)
        Mockito.verify(userDao, times(1)).addUser(actual.asEntity())
    }

    @Test
    fun `should get user with credential`() {
        val actual = FakeUser.getUserEntity()
        Mockito.`when`(userDao.getUser(anyString(), anyString(), anyString()))
            .thenReturn(Single.just(actual))

        localUserImpl.getUser(username = USERNAME, password = USER_PASSWORD, type = USER_TYPE)
            .test()
            .assertValueCount(1)
            .assertValue { it == actual.asModel() }
            .assertComplete()
    }

    @Test
    fun `should get user with identifier`() {
        val actual = FakeUser.getUserEntity()
        Mockito.`when`(userDao.getUser(Mockito.anyInt()))
            .thenReturn(Single.just(actual))

        localUserImpl.getUser(Mockito.anyInt())
            .test()
            .assertValueCount(1)
            .assertValue { it == actual.asModel() }
            .assertComplete()
    }

    @Test
    fun `should insert new profile object`() {
        val actual = FakeUser.getProfile()
        localUserImpl.addProfile(actual.asModel())
        Mockito.verify(userDao, times(1)).addProfile(actual)
    }

    @Test
    fun `should get profile with identifier`() {
        val actual = FakeUser.getProfile()
        Mockito.`when`(userDao.getProfile(Mockito.anyInt())).thenReturn(Single.just(actual))
        val test = localUserImpl.getProfile(USER_ID).test()
        test.assertValue { it.asEntity() == actual }.assertComplete()
    }
}