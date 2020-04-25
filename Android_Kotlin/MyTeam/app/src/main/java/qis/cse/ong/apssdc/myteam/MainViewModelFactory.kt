package com.example.roomdatabasetest

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(val application: Application):ViewModelProvider.Factory{
    override fun <Team : ViewModel?> create(modelClass: Class<Team>): Team {
        return MainViewModel(application) as Team
    }

}