package com.joetr.feature_one.di

import com.joetr.base.di.BaseComponent
import com.joetr.base.di.OverridableComponent
import com.joetr.base.di.scope.ActivityScope
import com.joetr.feature_one.FeatureOneActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [BaseComponent::class], modules = [FeatureOneModule::class])
interface FeatureOneComponent : OverridableComponent {
    fun inject(featureOneActivity: FeatureOneActivity)
}