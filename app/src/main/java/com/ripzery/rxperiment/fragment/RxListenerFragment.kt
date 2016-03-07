package com.ripzery.rxperiment.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding.view.RxView
import com.ripzery.rxperiment.R
import com.ripzery.rxperiment.model.RandomInteger
import kotlinx.android.synthetic.main.fragment_rx_listener.*
import rx.Observable
import rx.Scheduler
import rx.schedulers.Schedulers

class RxListenerFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var rootView: View? = null
    private var randomInteger: RandomInteger? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        randomInteger = RandomInteger()
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        rootView = inflater!!.inflate(R.layout.fragment_rx_listener, container, false)

        return rootView!!
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInstance()

    }

    private fun initInstance() {
        var observableBtn = RxView.clicks(btnRandomInt)

        observableBtn
                .flatMap { Observable.just((Math.random() * 100).toInt()) }
                .observeOn( Schedulers.io() )
                .subscribe {
                    randomInteger?.setRandomInteger(it) }
    }

    fun getRandomIntegerUpdateSubject() : Observable<Int>? {
        return randomInteger?.randomIntSubject
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"

        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?): RxListenerFragment {
            val fragment = RxListenerFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
