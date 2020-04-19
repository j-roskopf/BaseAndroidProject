package com.joetr.feature_one.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FeatureOneModule {
    @Provides
    @Singleton
    fun provideStringFromFeatureModuleOne() =
        "Provided from feature module One"
}