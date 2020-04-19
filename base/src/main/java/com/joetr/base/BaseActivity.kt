package com.joetr.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joetr.base.di.DaggerAware
import com.joetr.base.di.OverridableComponent
import io.reactivex.disposables.CompositeDisposable


abstract class BaseActivity(private val overridableComponent: OverridableComponent) : AppCompatActivity(), DaggerAware {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectSelf(overridableComponent)
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}