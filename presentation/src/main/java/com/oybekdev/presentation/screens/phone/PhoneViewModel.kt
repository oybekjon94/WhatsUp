package com.oybekdev.presentation.screens.phone

import android.media.effect.Effect
import android.renderscript.ScriptGroup
import com.oybekdev.domain.model.User
import com.oybekdev.domain.usecase.auth.SendSmsCodeUseCase
import com.oybekdev.presentation.base.BaseViewModel
import com.oybekdev.presentation.screens.phone.PhoneViewModel.*

class PhoneViewModel constructor(
    //bu yerda usecase chaqiriladi
    private val sendSmsCodeUseCase: SendSmsCodeUseCase
):BaseViewModel<State,Input,Effect>() {

    data class State(
        val user: User? = null
    )

    class Input

    class Effect

    override fun getDefaultState() = State()

    override fun processInput(input:Input) {

    }

}