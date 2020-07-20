package com.cheise_proj.remote_source.source

import com.cheise_proj.data.model.User
import com.cheise_proj.remote_source.model.CredentialDto
import com.cheise_proj.remote_source.service.ApiService
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import utils.FakeUser

@RunWith(JUnit4::class)
class RemoteUserImplTest {
    companion object {
        private const val USER_NAME = "any_username"
        private const val USER_PASSWORD = "any_password"
        private const val USER_TYPE = "any_type"
    }

    private lateinit var remoteUserImpl: RemoteUserImpl

    @Mock
    private lateinit var apiService: ApiService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        remoteUserImpl = RemoteUserImpl(apiService)
    }

    @Test
    fun `should fetch user tokens with credentials`() {
        val actual = FakeUser.getLoginDto()
        Mockito.`when`(
            apiService.loginUser(
                CredentialDto(
                    username = USER_NAME,
                    password = USER_PASSWORD,
                    type = USER_TYPE
                )
            )
        )
            .thenReturn(Observable.just(actual))
        remoteUserImpl.fetchUserToken(USER_NAME, USER_PASSWORD, USER_TYPE).test()
            .assertValueCount(1)
            .assertValue { t: User ->
                t.accessToken == "any_access_token" &&
                        t.refreshToken == "any_refresh_token"
            }

    }
}