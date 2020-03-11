package com.billysaputra.preparation.data.dao

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.billysaputra.preparation.data.model.Home
import com.billysaputra.preparation.data.model.SampleDataClass

@Dao
interface SampleDao {
    @Query("SELECT * FROM home_table")
    fun getAllHomeComponent(): LiveData<List<SampleDataClass>>

    @Query("SELECT * FROM home_table")
    fun getHomeComponentCursor(): Cursor

    @Query("SELECT * FROM home_table WHERE id = :componentId")
    fun getHomeComponentById(componentId: Int) : Cursor

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(home: SampleDataClass)

    @Query("DELETE FROM home_table WHERE id = :componentId")
    suspend fun deleteHomeComponentById(componentId: Int)

    @Query("DELETE FROM home_table")
    suspend fun deleteAllHomeComponent()
}