package com.cheise_proj.domain.usecases.user

import com.cheise_proj.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import utils.FakeUser

@RunWith(JUnit4::class)
class GetProfileTaskTest {

    private lateinit var getProfileTask: GetProfileTask

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getProfileTask =
            GetProfileTask(userRepository, Schedulers.trampoline(), Schedulers.trampoline())
    }

    @Test
    fun `should get profile data with user id`() {
        val actual = FakeUser.getProfile()
        Mockito.`when`(userRepository.getProfile(Mockito.anyInt()))
            .thenReturn(Observable.just(actual))
        val test = getProfileTask.execute(GetProfileTask.Params(Mockito.anyInt())).test()
        test.assertValue { it == actual }.assertComplete()
    }
}