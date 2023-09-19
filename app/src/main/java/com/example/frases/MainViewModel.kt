package com.example.frases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var textPerson = MutableLiveData<String>()


    init {
        textPerson.value = "Olá, "
    }

    fun person(): LiveData<String> {
        return textPerson
    }

}