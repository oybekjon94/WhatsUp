package com.oybekdev.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject

abstract class BaseViewModel<State : Any,Input : Any,Effect : Any>:ViewModel() {

    //State
    //state saqlab turadi va state ozgarsa UI ga yuboradi
    private val stateSubject = BehaviorSubject.createDefault(this.getDefaultState())
    //observable = flow
    val state: Observable<State> get() = stateSubject
        .distinctUntilChanged()
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())

    private val effectsSubject = PublishSubject.create<Effect>()
    //viewdan turib eshitib turish uchun
    val effects : Observable<Effect> get() = effectsSubject

    abstract fun getDefaultState():State

    //stateni ozgartirish uchun
    fun updateState(update:(current:State) -> State){
        val state = update(stateSubject.blockingFirst())
        stateSubject.onNext(state) //update bolgan stateni beramiz
    }

    abstract fun processInput(input:Input)

    //effectni berivoradi
    fun emitEffect(effect: Effect){
        effectsSubject.onNext(effect)
    }
}