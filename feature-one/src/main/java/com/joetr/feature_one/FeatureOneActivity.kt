package com.joetr.feature_one

import android.os.Bundle
import com.joetr.base.BaseActivity
import com.joetr.base.BaseApplication
import com.joetr.base.di.OverridableComponent
import com.joetr.data.SampleEntityRepository
import com.joetr.data.entities.SampleEntity
import com.joetr.feature_one.di.DaggerFeatureOneComponent
import com.joetr.feature_one.di.FeatureOneComponent
import com.joetr.networking.RedditApi
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FeatureOneActivity : BaseActivity(
    DaggerFeatureOneComponent.builder()
        .baseComponent(BaseApplication.baseComponent)
        .build()
) {

    @Inject
    lateinit var redditApi: RedditApi

    @Inject
    lateinit var repository: SampleEntityRepository

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_one)

        compositeDisposable += redditApi
            .getAndroidDev()
            .onErrorReturn {
                it
            }
            .flatMap {
                if (it is Throwable) {
                    Maybe.error(it)
                } else {
                    repository.add(SampleEntity("test"))
                }
            }
            .onErrorReturn {
                -1
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if(it == -1L) {
                    // handle error
                } else {
                    // handle success
                }
                // handle response
            }, {
                // handle error
            })
    }

    override fun injectSelf(component: OverridableComponent) {
        (component as FeatureOneComponent).inject(this)
    }
}
