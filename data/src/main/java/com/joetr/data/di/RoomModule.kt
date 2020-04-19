package com.joetr.data.di

import android.app.Application
import com.joetr.data.dao.SampleDao
import dagger.Module
import dagger.Provides
import com.joetr.data.AppDatabase
import com.joetr.data.SampleEntityRepository
import javax.inject.Singleton

@Module
class RoomModule(application: Application) {

    private val appDatabase: AppDatabase by lazy {
        AppDatabase.getInstance(application)
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return appDatabase
    }

    @Singleton
    @Provides
    fun provideTeamDao(appDatabase: AppDatabase): SampleDao {
        return appDatabase.teamDao()
    }

    @Singleton
    @Provides
    fun provideTeamRepository(dao: SampleDao): SampleEntityRepository {
        return SampleEntityRepository(dao)
    }
}