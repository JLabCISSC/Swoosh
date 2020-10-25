package com.jarradl.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jarradl.swoosh.Utilities.EXTRA_LEAGUE
import com.jarradl.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        if (!mensLeagueBtn.isChecked){
            selectedLeague = ""
        }
        else {
            womensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false
            selectedLeague = "mens"
        }
    }

    fun onWomensClicked(view: View) {
        if (!womensLeagueBtn.isChecked){
            selectedLeague = ""
        }
        else {
            mensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false
            selectedLeague = "womens"
        }
    }

    fun onCoedClicked(view: View) {
        if (!coedLeagueBtn.isChecked) {
            selectedLeague = ""
        }
        else {
            mensLeagueBtn.isChecked = false
            womensLeagueBtn.isChecked = false
            selectedLeague = "co-ed"
        }
    }

    fun leagueNextClicked(view: View) {
        if (selectedLeague != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        }
        else {
            Toast.makeText(this, "Please Select a League", Toast.LENGTH_SHORT).show()
        }
    }

}