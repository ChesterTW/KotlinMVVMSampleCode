package com.taro.mvvmpractice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.taro.mvvmpractice.R
import com.taro.mvvmpractice.databinding.ActivityMainBinding
import com.taro.mvvmpractice.model.DataModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by lazy{
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initModel()
    }

    private fun initModel() {
        /// 說明要觀察 VM 中更新的文字字串，
        /// textLiveData 是要監聽的字串對象。
        viewModel.textLiveData.observe(this){
            /// it 是 textLiveData 的最新值，
            /// 被賦予給 textView.text。
            binding.textView.text = it.toString()
        }
    }

    private fun initView() {
        with(binding){
            btnUpdate.setOnClickListener(View.OnClickListener {
                /// 呼叫 ViewModel 的 .getTextData 方法，
                /// 呼叫資料請求，然後 VM 會獲得最新的資料，但我們不會在這裡去取得，
                /// 而是去 initModel 中定義。
                viewModel.getTextData()
                /// 但還缺少觀察的方法
                /// 如要取得觀察的方法，需要先建立 ViewModel 物件，並從中取得被我們建立的觀察屬性，好更新數值。
            })
        }
    }
}