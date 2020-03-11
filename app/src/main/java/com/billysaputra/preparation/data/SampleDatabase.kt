package com.billysaputra.preparation.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.billysaputra.preparation.data.dao.SampleDao
import com.billysaputra.preparation.data.model.SampleDataClass

@Database(entities = [SampleDataClass::class], version = 1)
abstract class SampleDatabase : RoomDatabase() {
    abstract fun sampleDao(): SampleDao

    companion object {
        @Volatile
        private var INSTANCE: SampleDatabase? = null

        fun getDatabase(context: Context): SampleDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SampleDatabase::class.java,
                    "preparation_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }

        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE home_table ADD COLUMN poster_path TEXT DEFAULT NULL")
            }
        }
    }
}