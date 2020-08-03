package com.alphabetforkids.viewmodel

import androidx.lifecycle.ViewModel
import com.alphabetforkids.model.BaseRepository

abstract class BaseTeachingModel<T> : ViewModel() {

    abstract val repo: BaseRepository

    abstract val data: Array<T>

    abstract fun speak(position: Int)
}