package com.example.roomdatabasetest.Databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TeamDao {

    @Insert
    fun insert(studentDetails: TeamDetails)

    @Query("select *from scoreboard")
    fun getAll(): LiveData<List<TeamDetails>>

}