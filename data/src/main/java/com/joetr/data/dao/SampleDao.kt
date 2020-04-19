package com.joetr.data.dao

import androidx.room.*
import com.joetr.data.entities.SampleEntity
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface SampleDao {
    @Query("SELECT * FROM sampleentity")
    fun getAll(): Maybe<List<SampleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: SampleEntity) : Maybe<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(data: List<SampleEntity>): Maybe<List<Long>>

    @Delete
    fun delete(data: SampleEntity) : Single<Int>
}