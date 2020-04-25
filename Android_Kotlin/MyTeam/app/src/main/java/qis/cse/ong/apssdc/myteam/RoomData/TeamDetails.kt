package com.example.roomdatabasetest.Databases

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ScoreBoard")
data class TeamDetails(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var teamA_Score:String = " ",
    var teamB_Score:String = " "
)