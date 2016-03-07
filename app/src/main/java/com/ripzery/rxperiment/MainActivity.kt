package com.ripzery.rxperiment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding.view.RxView
import com.ripzery.rxperiment.activity.RxListenerActivity
import com.ripzery.rxperiment.fragment.RxListenerFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initInstance()
    }

    private fun initInstance() {


        RxView.clicks(btnRandomIntActivity)
        .subscribe { startActivity(Intent(this@MainActivity, RxListenerActivity::class.java)) }
    }
}