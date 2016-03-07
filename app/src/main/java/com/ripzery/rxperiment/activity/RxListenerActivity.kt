package com.ripzery.rxperiment.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.ripzery.rxperiment.R
import com.ripzery.rxperiment.fragment.RxListenerFragment
import com.ripzery.rxperiment.model.RandomInteger
import kotlinx.android.synthetic.main.activity_rx_listener.*

/**
 * Created by Euro on 3/7/16 AD.
 */

class RxListenerActivity : AppCompatActivity() {

    private var rxListenerFragment: RxListenerFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_listener)
        initInstance()

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        rxListenerFragment?.getRandomIntegerUpdateSubject()?.subscribe {
            tvUpdateRandom.text = "$it"
        }
    }

    private fun initInstance() {
        rxListenerFragment = RxListenerFragment.newInstance("Hello")

        supportFragmentManager.beginTransaction()
                .replace(R.id.contentContainer, rxListenerFragment)
                .commit()
    }

}
