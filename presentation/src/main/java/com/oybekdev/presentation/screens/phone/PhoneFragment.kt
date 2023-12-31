package com.oybekdev.presentation.screens.phone

import android.os.Bundle
import android.view.View
import com.oybekdev.domain.model.User
import com.oybekdev.presentation.base.BaseFragment
import com.oybekdev.presentation.databinding.FragmentPhoneBinding

class PhoneFragment:BaseFragment<FragmentPhoneBinding>(FragmentPhoneBinding::inflate) {

    private lateinit var viewModel: PhoneViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(this::renderUser){ it.user!! }
        //shu yerda xatolik ketyabdi
        viewModel.effects.doOnNext { this.handleEffects() }
    }

    private fun renderUser(user: User?){

    }

    private fun handleEffects() {

    }
}