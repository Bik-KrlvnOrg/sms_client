package com.cheise_proj.auth.ui.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.cheise_proj.auth.AuthActivity
import com.cheise_proj.auth.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @get:Rule
    val rule = ActivityTestRule<AuthActivity>(AuthActivity::class.java)

    @Before
    fun setUp() {

    }

    @Test
    fun loginFlowTest() {
        onView(withId(R.id.btn_start)).perform(click())
        onView(withId(R.id.btn_login)).perform(click())
    }
}