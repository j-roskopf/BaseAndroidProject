package com.joetr.data

import com.joetr.data.dao.SampleDao
import com.joetr.data.entities.SampleEntity
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SampleEntityRepository @Inject constructor(private val sampleDao: SampleDao) {
    fun getAll(): Maybe<List<SampleEntity>> {
        return sampleDao.getAll()
            .subscribeOn(Schedulers.io())
    }

    fun add(entity: SampleEntity): Maybe<Long> {
        return sampleDao.insert(entity)
            .subscribeOn(Schedulers.io())
    }

    fun addAll(entities: List<SampleEntity>): Maybe<List<Long>> {
        return sampleDao.insertAll(entities)
            .subscribeOn(Schedulers.io())
    }

    fun delete(entity: SampleEntity): Single<Int> {
        return sampleDao.delete(entity)
            .subscribeOn(Schedulers.io())
    }
}