package com.jarradl.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jarradl.swoosh.Model.Player
import com.jarradl.swoosh.R
import com.jarradl.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        if (!mensLeagueBtn.isChecked){
            player.league = ""
        }
        else {
            womensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false
            player.league = "mens"
        }
    }

    fun onWomensClicked(view: View) {
        if (!womensLeagueBtn.isChecked){
            player.league = ""
        }
        else {
            mensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false
            player.league = "womens"
        }
    }

    fun onCoedClicked(view: View) {
        if (!coedLeagueBtn.isChecked) {
            player.league = ""
        }
        else {
            mensLeagueBtn.isChecked = false
            womensLeagueBtn.isChecked = false
            player.league = "co-ed"
        }
    }

    fun leagueNextClicked(view: View) {
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        }
        else {
            Toast.makeText(this, "Please Select a League", Toast.LENGTH_SHORT).show()
        }
    }

}