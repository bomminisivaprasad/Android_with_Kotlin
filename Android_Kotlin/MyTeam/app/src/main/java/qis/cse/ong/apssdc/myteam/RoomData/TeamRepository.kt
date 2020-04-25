package com.example.roomdatabasetest.Databases

import android.app.Application
import androidx.lifecycle.LiveData

class TeamRepository(application: Application){
    private val teamDao:TeamDao
    private val studentsList:LiveData<List<TeamDetails>>
    init {
        val teamDatabase:TeamDatabase = TeamDatabase.getInstance(application)
        teamDao = teamDatabase.teamDao
        studentsList = teamDao.getAll()

    }

    fun getAll():LiveData<List<TeamDetails>>{

        return studentsList
    }

    fun insert(studentDetails: TeamDetails){
        teamDao.insert(studentDetails)
    }

}