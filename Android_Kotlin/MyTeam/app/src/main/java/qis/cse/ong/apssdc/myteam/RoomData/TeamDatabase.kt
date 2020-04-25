package com.example.roomdatabasetest.Databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TeamDetails::class],version = 1,exportSchema = false)
abstract class TeamDatabase : RoomDatabase(){

    abstract val teamDao :TeamDao

    companion object{

        @Volatile
        var INSTANCE: TeamDatabase?=null

        fun getInstance(context: Context):TeamDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(context,
                        TeamDatabase::class.java,
                        "CricketDb").fallbackToDestructiveMigration().allowMainThreadQueries().build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }

}