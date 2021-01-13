package com.example.androidcatchup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// 下記を簡略化
// https://developer.android.com/kotlin/flow/stateflow-and-sharedflow
class BlankViewModel : ViewModel() {

    private val _uiState = MutableStateFlow("")

    // StateFlowとして外部に公開
    val uiState: StateFlow<String> = _uiState

    init {
        viewModelScope.launch {
            // repositoryを用いて、suspend関数の結果を_uiStateに結果する
            _uiState.value = "new value"
        }
    }
}