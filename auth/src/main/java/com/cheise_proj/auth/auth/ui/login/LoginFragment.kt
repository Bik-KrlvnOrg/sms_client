package com.cheise_proj.auth.auth.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import com.cheise_proj.auth.BaseFragment
import com.cheise_proj.auth.R
import com.cheise_proj.presentation.viewmodel.auth.AuthenticationVM
import com.cheise_proj.presentation.viewmodel.auth.LoggedInUserView
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment<AuthenticationVM>() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val afterTextChangedListener = editTextListener
        et_username.addTextChangedListener(afterTextChangedListener)
        et_password.addTextChangedListener(afterTextChangedListener)
        et_password.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                viewModel.login(
                    et_username.text.toString(),
                    et_password.text.toString(),
                    "STUDENT"

                )
            }
            false
        }

        btn_login.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            viewModel.login(
                et_username.text.toString(),
                et_password.text.toString(),
                "Student"
            )
        }
        subscribeObserver()
    }

    private fun subscribeObserver() {
        viewModel.loginFormState.observe(viewLifecycleOwner,
            Observer { loginFormState ->
                if (loginFormState == null) {
                    return@Observer
                }
                btn_login.isEnabled = loginFormState.isDataValid
                loginFormState.usernameError?.let {
                    et_username.error = getString(it)
                }
                loginFormState.passwordError?.let {
                    et_password.error = getString(it)
                }
            })

        viewModel.loginResult.observe(viewLifecycleOwner,
            Observer { loginResult ->
                loginResult ?: return@Observer
                progressBar.visibility = View.GONE
                loginResult.error?.let {
                    showLoginFailed(it)
                }
                loginResult.success?.let {
                    updateUiWithUser(it)
                }
            })
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome) + model.displayName
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, welcome, Toast.LENGTH_LONG).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }

    private val editTextListener = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            // ignore
        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            // ignore
        }

        override fun afterTextChanged(s: Editable) {
            viewModel.loginDataChanged(
                et_username.text.toString(),
                et_password.text.toString(),
                "Student"
            )
        }
    }

    override fun getViewModel(): Class<AuthenticationVM> = AuthenticationVM::class.java
}