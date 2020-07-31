package com.cheise_proj.student_app.navigation

import android.content.Context
import android.net.Uri
import com.cheise_proj.actions.Actions
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [22],manifest = Config.NONE)
class AppNavigationImplTest {
    companion object {
        private const val LOCATION = "any_location"
        private const val ARG1 = "any_arg1"
        private const val ARG2 = "any_arg2"
    }

    private lateinit var appNavigationImpl: AppNavigationImpl

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var actions: Actions

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        appNavigationImpl = AppNavigationImpl(context, actions)
    }

    @Test
    fun `should get uri with location params`() {
        val actual = "testApp://$LOCATION"
        Mockito.`when`(actions.navigate(context, LOCATION)).thenReturn(Uri.parse(actual))
        val expected = appNavigationImpl.deepLink(LOCATION)
        println("deepLink: $expected")
        Assert.assertEquals(expected.toString(),actual)
    }

    @Test
    fun `should get uri with location and arg`() {
        val actual = "testApp://$LOCATION/$ARG1"
        Mockito.`when`(actions.navigate(context, LOCATION)).thenReturn(Uri.parse(actual))
        val expected = appNavigationImpl.deepLink(LOCATION)
        println("deepLink: $expected")
        Assert.assertEquals(expected.toString(),actual)
    }

    @Test
    fun `should get uri with location with multiple args`() {
        val actual = "testApp://$LOCATION/$ARG1/$ARG2"
        Mockito.`when`(actions.navigate(context, LOCATION)).thenReturn(Uri.parse(actual))
        val expected = appNavigationImpl.deepLink(LOCATION)
        println("deepLink: $expected")
        Assert.assertEquals(expected.toString(),actual)
    }
}