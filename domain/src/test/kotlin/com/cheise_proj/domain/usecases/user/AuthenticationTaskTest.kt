package com.cheise_proj.domain.usecases.user

import com.cheise_proj.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import utils.FakeUser

@RunWith(JUnit4::class)
class AuthenticationTaskTest {
    companion object {
        private const val USER_NAME = "any_username"
        private const val USER_PASSWORD = "any_username"
    }

    private lateinit var authenticationTask: AuthenticationTask

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        authenticationTask =
            AuthenticationTask(userRepository, Schedulers.trampoline(), Schedulers.trampoline())
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should throw an error if username is not provided`() {
        val username = ""
        authenticationTask.execute(AuthenticationTask.Params(username, USER_PASSWORD))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should throw an error if password is not provided`() {
        val password = ""
        authenticationTask.execute(AuthenticationTask.Params(USER_NAME, password))
    }

    @Test
    fun `should return user data if valid credentials`() {
        val user = FakeUser.getUser()

        Mockito.`when`(userRepository.getUser(anyString(), anyString()))
            .thenReturn(Observable.just(user))

        val testObserver = authenticationTask.execute(
            AuthenticationTask.Params(
                USER_NAME,
                USER_PASSWORD
            )
        ).test()

        testObserver.assertValue { it == user }

    }
}