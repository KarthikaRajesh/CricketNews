package com.sportz.cricketnews.presentation.matchdetail

import android.content.Intent
import android.graphics.Color
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sportz.cricketnews.R
import com.sportz.cricketnews.data.model.Players
import com.sportz.cricketnews.data.model.Teams
import com.sportz.cricketnews.databinding.ActivityMatchDetailsBinding
import com.sportz.cricketnews.presentation.di.Injector
import com.sportz.cricketnews.presentation.teamdetail.TeamDetailsActivity
import javax.inject.Inject

/**
 * @Author: KARTHIKA RAJESH
 * @Date: 08-05-2023
 */
class
MatchDetailActivity : AppCompatActivity() {
    @Inject
    lateinit var matchDetailViewModelFactory: MatchDetailViewModelFactory
    private lateinit var matchDetailViewModel: MatchDetailViewModel
    private lateinit var  teamsData : Map<String,Teams>
    private lateinit var matchDetailsBinding: ActivityMatchDetailsBinding
    private var teamsArrayList : ArrayList<Teams> = ArrayList<Teams>()
    private val builder = java.lang.StringBuilder()
    private var teamName : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        matchDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_match_details)
        setSupportActionBar(matchDetailsBinding.toolBar)
        supportActionBar?.title = "Match Details"
        matchDetailsBinding.toolBar.setTitleTextColor(Color.WHITE)
        (application as Injector).createMatchDetailSubComponent().inject(this)

        matchDetailViewModel = ViewModelProvider(this,matchDetailViewModelFactory)
            .get(MatchDetailViewModel::class.java)

        val responseLiveData = matchDetailViewModel.getMatchDetails
        responseLiveData.observe(this, Observer {
            teamsData = it?.teams!!
            teamsArrayList.addAll(teamsData.values)
            matchDetailsBinding.tvSquads.visibility = View.VISIBLE
            matchDetailsBinding.tvTeams.text = teamsArrayList.get(0).nameFull + " Vs " + teamsArrayList.get(1).nameFull
            matchDetailsBinding.tvMatch.text = "Match : " + it.matchDetail.match.number
            matchDetailsBinding.tvSeries.text = "Series : " + it.matchDetail.series.name
            matchDetailsBinding.tvDate.text = "Date : " + it.matchDetail.match.date
            matchDetailsBinding.tvTime.text = "Series : " + it.matchDetail.match.time
            matchDetailsBinding.tvVenue.text = "Series : " + it.matchDetail.venue.name
            matchDetailsBinding.tvResult.text = "Series : " + it.matchDetail.result
            matchDetailsBinding.tvPlayerMatch.text = "Series : " + it.matchDetail.playerMatch

        })

        matchDetailsBinding.tvSquads.setOnClickListener {
            val intent = Intent(this, TeamDetailsActivity::class.java)
            intent.putExtra("team_data",teamsArrayList)
            startActivity(intent)
        }
    }
}