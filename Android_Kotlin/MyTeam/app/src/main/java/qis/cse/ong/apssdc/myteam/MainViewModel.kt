package com.example.roomdatabasetest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomdatabasetest.Databases.TeamDetails
import com.example.roomdatabasetest.Databases.TeamRepository

class MainViewModel(application: Application):AndroidViewModel(application) {

    val teamRepository: TeamRepository
    val allStudents: LiveData<List<TeamDetails>>

    init {
        teamRepository = TeamRepository(application)
        allStudents = teamRepository.getAll()
    }

    fun insert(studentDetails: TeamDetails) {
        teamRepository.insert(studentDetails)
    }

}