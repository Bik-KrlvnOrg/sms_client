package com.cheise_proj.student_app.preference

import android.content.Context
import com.cheise_proj.presentation.model.UserSession
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [22], manifest = Config.NONE)
class AppPreferenceImplTest {

    companion object {
        private val fakeSession: UserSession = UserSession(
            userId = 1,
            userType = "any_string",
            schoolId = "any_string",
            displayName = "any_string"
        )
        private const val PREF_KEY = "pref_any_string_key"
    }

    private lateinit var appPreferenceImpl: AppPreferenceImpl

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var preferenceManager: PreferenceManager

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        appPreferenceImpl = AppPreferenceImpl(context, preferenceManager)
    }

    @Test
    fun `should set and get login user status`() {
        val actual = true
        Mockito.`when`(context.getString(Mockito.anyInt())).thenReturn(PREF_KEY)
        Mockito.`when`(preferenceManager.getBoolean(PREF_KEY)).thenReturn(actual)
        appPreferenceImpl.setLoggedInStatus(actual)
        val expected = appPreferenceImpl.getLoggedInStatus()
        assertEquals(expected, actual)
    }

    @Test
    fun setLogOut() {
        Mockito.`when`(context.getString(Mockito.anyInt())).thenReturn(PREF_KEY)
        appPreferenceImpl.setLogOut()
        Mockito.verify(preferenceManager, Mockito.times(1)).clear()
    }


    @Test
    fun `should set and get on boarding status`() {
        val actual = true
        Mockito.`when`(context.getString(Mockito.anyInt())).thenReturn(PREF_KEY)
        Mockito.`when`(preferenceManager.getBoolean(PREF_KEY)).thenReturn(actual)
        appPreferenceImpl.showOnBoardingScreen(actual)
        val expected = appPreferenceImpl.getOnBoardingStatus()
        assertEquals(expected, actual)
    }

    @Test
    fun `should set and get user session`() {
        val actual = fakeSession
        Mockito.`when`(context.getString(Mockito.anyInt())).thenReturn(PREF_KEY)
        Mockito.`when`(preferenceManager.getInt(PREF_KEY)).thenReturn(1)
        Mockito.`when`(preferenceManager.getString(PREF_KEY)).thenReturn("any_string")
        appPreferenceImpl.setUserSession(actual)
        val expected = appPreferenceImpl.getUserSession()
        assertEquals(expected, actual)
    }
}