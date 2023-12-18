package com.oybekdev.domain.usecase.auth

import android.provider.ContactsContract.DisplayPhoto
import com.oybekdev.domain.repo.AuthRepository

class SendSmsCodeUseCase constructor(
    private val authRepository: AuthRepository
) {
    //usecase ishga tushganda bajarilishi kere bolgan bitta func bor
    //bu classni instanceni xuddi func. uxshatib foy. yordam beradi
    operator fun invoke(phone: String){
        authRepository.sendSmsCode(phone)
    }
}