package com.taro.mvvmpractice.activity

import android.util.Log
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.taro.mvvmpractice.api.StringApi

class MainActivityViewModel:ViewModel(){
    companion object{
         private val TAG = MainActivityViewModel::class.java.simpleName
    }

    /// 模擬 API 取得字串
    // private val model = DataModel(textForUI = "Here's the updated text!")

    /// 會變化的字串，是要提供給 View 觀察的對象。
    val textLiveData = MutableLiveData<String>()

    /// 讓 View 能進行資料請求，然後把新資料賦予給在此類別宣告的 textLiveData。
    fun getTextData(){
        val updatedText = StringApi().getText()
        textLiveData.postValue(updatedText)
        Log.d(TAG, "getTextData: Update Text: $updatedText.textForUI")
    }

}