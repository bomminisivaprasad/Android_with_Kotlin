package qis.cse.ong.apssdc.myteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabasetest.Databases.TeamDetails
import com.example.roomdatabasetest.MainViewModel
import com.example.roomdatabasetest.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var dataBinding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(application)
        ).get(MainViewModel::class.java)
        mainViewModel.allStudents.observe(this, Observer { list ->
            displayData(list)

        })

        dataBinding.saveButton.setOnClickListener {
            saveData()
        }
    }

    private fun displayData(list: List<TeamDetails>?) {
        if (list != null) {
            dataBinding.textView.teamIND.text=list.get(1).teamA_Score
            dataBinding.textView.teamENG.text=list.get(2).teamB_Score
        }
    }

    private fun saveData() {
        val aScore = dataBinding.editText.text.toString()
        val bScore = dataBinding.editText2.text.toString()
        val studentDetails: TeamDetails =
            TeamDetails(teamA_Score = aScore, teamB_Score = bScore)
        mainViewModel.insert(studentDetails)
        val toast: Toast = Toast.makeText(this, "Data Inserted ", Toast.LENGTH_LONG)
        toast.show()
        dataBinding.teamACore.text.clear()
        dataBinding.teamBCore.text.clear()


    }
}
