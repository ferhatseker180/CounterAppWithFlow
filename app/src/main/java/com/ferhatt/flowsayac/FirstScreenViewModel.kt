package com.ferhatt.flowsayac

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class FirstScreenViewModel : ViewModel() {

    private var count = 0

    val counter = flow {
        while (true){
            kotlinx.coroutines.delay(1000L)
            println("Running Flow")
            emit(count++)
        }
    }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),0)
}