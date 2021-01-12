package com.example.androidcatchup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// 下記を簡略化
// https://developer.android.com/kotlin/flow/stateflow-and-sharedflow
class BlankViewModel : ViewModel() {

    private val _uiState = MutableStateFlow("")
    val uiState: StateFlow<String> = _uiState

}