package com.oybekdev.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import io.reactivex.rxjava3.core.Observable

//Generic qilinadi chunki ViewBindingni olib yurishi kerak
abstract class BaseFragment<Vb: ViewBinding>(private val inflate:(LayoutInflater,ViewGroup?,Boolean) -> Vb
):Fragment() {

    private var _binding:Vb? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater,container,false)
        return binding.root
    }

    //reference yuqotadi
    //garbage collector Vbni memmory leakdan tozalab tashaydi
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun <T : Any,R : Any> Observable<T>.observe(observer:(R) -> Unit, mapper: (T) -> R){
        map(mapper).distinctUntilChanged().doOnNext(observer)
    }
}