package com.example.hilt

import javax.inject.Inject

// 他に何も依存がいらないシンプルなクラス
class SimpleClass @Inject constructor() {

    fun getString(): String {
        return "result"
    }
}