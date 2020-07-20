package com.cheise_proj.local_source.source

import com.cheise_proj.local_source.db.dao.UserDao
import com.cheise_proj.local_source.extension.toModel
import com.cheise_proj.local_source.extension.toObject
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
        Mockito.verify(userDao, times(1)).addUser(actual.toObject())
    }

    @Test
    fun `should get user with credential`() {
        val actual = FakeUser.getUserEntity()
        Mockito.`when`(userDao.getUser(anyString(), anyString())).thenReturn(Single.just(actual))

        localUserImpl.getUser(username = USERNAME, password = USER_PASSWORD).test()
            .assertValueCount(1)
            .assertValue { it == actual.toModel() }
            .assertComplete()
    }
}