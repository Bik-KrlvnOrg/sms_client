package com.cheise_proj.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import com.cheise_proj.domain.entities.UserType
import com.cheise_proj.domain.repository.UserRepository
import com.cheise_proj.domain.usecases.user.AuthenticationTask
import com.cheise_proj.presentation.extensions.toEntity
import com.cheise_proj.presentation.model.Status
import com.cheise_proj.presentation.utils.FakeUser
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class AuthenticationVMTest {

    companion object {
        private const val USER_NAME = "any_username"
        private const val USER_PASSWORD = "any_username"
        private const val ERROR_MESSAGE = "invalid credentials"
    }

    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    private lateinit var authenticationVM: AuthenticationVM
    private lateinit var authenticationTask: AuthenticationTask

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        authenticationTask =
            AuthenticationTask(userRepository, Schedulers.trampoline(), Schedulers.trampoline())
        authenticationVM = AuthenticationVM(authenticationTask)
    }

    @Test
    fun `should get user data with credentials`() {
        val user = FakeUser.getUser()
        Mockito.`when`(
            userRepository.getUser(
                username = anyString(),
                password = anyString(),
                type = anyString()
            )
        )
            .thenReturn(Observable.just(user.toEntity()))

        authenticationVM.authenticateWithCredentials(
            username = USER_NAME,
            password = USER_PASSWORD,
            type = UserType.STAFF
        )
        val expected = authenticationVM.userResource
        expected.observeForever { }

        assertTrue(expected.value?.status == Status.SUCCESS && expected.value?.data == user)
    }

    @Test
    fun `should get an error message with invalid credentials`() {
        Mockito.`when`(
            userRepository.getUser(
                username = anyString(),
                password = anyString(),
                type = anyString()
            )
        )
            .thenReturn(Observable.error(Throwable(ERROR_MESSAGE)))

        authenticationVM.authenticateWithCredentials(
            username = USER_NAME,
            password = USER_PASSWORD,
            type = UserType.STAFF
        )
        val expected = authenticationVM.userResource
        expected.observeForever { }
        assertTrue(expected.value?.status == Status.ERROR && expected.value?.message == ERROR_MESSAGE)
    }
}