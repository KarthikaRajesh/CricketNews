package com.sportz.cricketnews.presentation.teamdetail

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sportz.cricketnews.R
import com.sportz.cricketnews.data.model.Players
import com.sportz.cricketnews.data.model.Teams
import com.sportz.cricketnews.databinding.ActivityTeamDetailsBinding

class TeamDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamDetailsBinding
    private var teamNameList : ArrayList<String> = ArrayList<String>()
    private var selectedTeamPosition = 0
    private lateinit var teamsIntent : ArrayList<Teams>
    private lateinit var playersArrayList : ArrayList<Players>
    private lateinit var playerRecyclerAdapter: PlayerRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_details)
        setSupportActionBar(binding.toolBar)
        supportActionBar?.title = "Squad Details"
        binding.toolBar.setTitleTextColor(Color.WHITE)
        teamsIntent = intent.getParcelableArrayListExtra<Teams>("team_data")!!

        setupSpinner()

    }
    private fun getTeamMemberData(){
        playersArrayList = ArrayList<Players>()
        playersArrayList.clear()
        playersArrayList.addAll(teamsIntent.get(selectedTeamPosition).players.values)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        playerRecyclerAdapter = PlayerRecyclerAdapter(playersArrayList,
            itemClickListener = object:PlayerRecyclerAdapter.onItemClickListener{
                override fun onClick(players: Players) {
                    TeamPlayerDialogFragment.newInstance(players).show(supportFragmentManager, TeamPlayerDialogFragment.TAG)
                }

             }
        )

        binding.rvTeamMembers.apply {
            adapter = playerRecyclerAdapter
            layoutManager = LinearLayoutManager(this@TeamDetailsActivity)
            setHasFixedSize(true)
        }
    }

    fun setupSpinner() {
        for(teams in teamsIntent!!){
            teamNameList.add(teams.nameFull)
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, teamNameList)
        binding.spTeamList.adapter = adapter

        binding.spTeamList.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    selectedTeamPosition = position
                    getTeamMemberData()

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
            getTeamMemberData()
        }

}