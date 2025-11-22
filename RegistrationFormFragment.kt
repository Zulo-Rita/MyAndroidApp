package com.example.lecture_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class RegistrationFormFragment : Fragment() {


    private lateinit var onClickListener: () -> Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration_form, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val registerButton = view.findViewById<Button>(R.id.registerButton)
        val goToLoginButton = view.findViewById<Button>(R.id.goToLoginButton)

        registerButton.setOnClickListener {
            // handle registration
        }

//        goToLoginButton.setOnClickListener {
//            // swap fragment to LoginFormFragment
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, LoginFormFragment())
//                .addToBackStack(null)
//                .commit()
//        }
    }

}