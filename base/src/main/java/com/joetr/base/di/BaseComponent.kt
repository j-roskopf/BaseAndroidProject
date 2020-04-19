package com.joetr.base.di

import com.joetr.data.SampleEntityRepository
import com.joetr.data.di.RoomModule
import com.joetr.networking.RedditApi
import com.joetr.networking.di.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RoomModule::class])
interface BaseComponent {
    val redditApi: RedditApi
    val sampleEntityRepository: SampleEntityRepository
}
