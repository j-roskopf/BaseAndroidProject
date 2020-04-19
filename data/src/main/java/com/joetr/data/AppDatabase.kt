package com.joetr.data

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.joetr.data.dao.SampleDao
import com.joetr.data.entities.SampleEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types.newParameterizedType
import java.lang.reflect.ParameterizedType

@Database(entities = [SampleEntity::class], version = 1)
@TypeConverters(SampleEntityArrayTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun teamDao(): SampleDao

    companion object {

        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) : AppDatabase {
            val db = Room.inMemoryDatabaseBuilder(context.applicationContext,
                AppDatabase::class.java)

            return db.addCallback(object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                }
            }).build()
        }
    }
}

class SampleEntityArrayTypeConverter {
    private val moshi: Moshi = Moshi.Builder().build()
    private val listMyData: ParameterizedType = newParameterizedType(
        MutableList::class.java,
        SampleEntity::class.java
    )
    private val adapter: JsonAdapter<List<SampleEntity>> = moshi.adapter(listMyData)


    @TypeConverter
    fun fromString(value: String): List<SampleEntity>? {
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromArrayList(list: List<SampleEntity>): String {
        return adapter.toJson(list)
    }
}
