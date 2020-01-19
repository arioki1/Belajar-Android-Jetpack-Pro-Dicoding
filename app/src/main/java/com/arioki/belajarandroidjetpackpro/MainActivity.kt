package com.arioki.belajarandroidjetpackpro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]

        btn_calculate.setOnClickListener {
            when {
                edt_width.text.isEmpty() -> {
                    edt_width.error = getString(R.string.empty)
                }
                edt_height.text.isEmpty() -> {
                    edt_height.error = getString(R.string.empty)
                }
                edt_length.text.isEmpty() -> {
                    edt_length.error = getString(R.string.empty)
                }
                else -> {
                    viewModel.calculate(
                        edt_width.text.toString(),
                        edt_height.text.toString(),
                        edt_length.text.toString()
                    )
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        tv_result.text = viewModel.result.toString()
    }
}
