package com.taro.mvvmpractice.api

import com.taro.mvvmpractice.model.DataModel

class StringApi {
    fun getText(): String {
        return DataModel(textForUI = "Here's the updated text!").textForUI
    }
}