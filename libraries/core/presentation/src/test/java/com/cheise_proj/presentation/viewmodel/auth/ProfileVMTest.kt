package com.cheise_proj.presentation.viewmodel.auth

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cheise_proj.domain.repository.UserRepository
import com.cheise_proj.domain.usecases.user.GetProfileTask
import com.cheise_proj.presentation.extensions.asEntity
import com.cheise_proj.presentation.utils.FakeUser
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class ProfileVMTest {

    private lateinit var profileVM: ProfileVM
    private lateinit var getProfileTask: GetProfileTask
    @Mock lateinit var userRepository: UserRepository

    @get:Rule
    val testRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getProfileTask = GetProfileTask(userRepository,Schedulers.trampoline(),Schedulers.trampoline())
        profileVM = ProfileVM(getProfileTask)
    }


    @Test
    fun `should get user profile with user identifier`() {
        val actual = FakeUser.getProfile()
        Mockito.`when`(userRepository.getProfile(Mockito.anyInt())).thenReturn(Observable.just(actual.asEntity()))
        profileVM.getProfile(Mockito.anyInt())
        val expected = profileVM.profile
        expected.observeForever {  }
        assertTrue(expected.value == actual)
    }
}