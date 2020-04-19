package com.joetr.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.joetr.base.di.DaggerAware
import io.reactivex.disposables.CompositeDisposable


abstract class BaseFragment() : Fragment(), DaggerAware {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}