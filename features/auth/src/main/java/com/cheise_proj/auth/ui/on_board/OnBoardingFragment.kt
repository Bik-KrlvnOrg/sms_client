package com.cheise_proj.auth.ui.on_board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cheise_proj.auth.R
import kotlinx.android.synthetic.main.fragment_on_boarding.*

/**
 * OnBoardingFragment subclass.
 */
class OnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_start.setOnClickListener {
            navigateToLoginPage()
        }
    }

    private fun navigateToLoginPage() {
        findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)
    }

}