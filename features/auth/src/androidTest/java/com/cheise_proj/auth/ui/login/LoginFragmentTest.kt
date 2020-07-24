package com.cheise_proj.auth.ui.login

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.cheise_proj.auth.AuthActivity
import com.cheise_proj.auth.R
import com.cheise_proj.auth.ui.on_board.OnBoardingFragment
import com.cheise_proj.presentation.factory.ViewModelFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerApplication
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Provider

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {


    @Before
    fun setUp() {

    }

    @Test
    fun loginFlowTest() {

        val scenario = launchFragmentInContainer<OnBoardingFragment>()
        onView(withId(R.id.btn_start)).perform(click())
//        onView(withId(R.id.btn_login)).perform(click())
    }
}

class TestApp:Application()

