package com.jarradl.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jarradl.swoosh.Model.Player
import com.jarradl.swoosh.R
import com.jarradl.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBallerClick(view: View) {
        beginnerSkillBtn.isChecked = false
        player.skill = "baller"
    }

    fun onBeginnerClick(view: View) {
        ballerSkillBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onSkillFinishedClicked(view: View) {
        if (player.skill != "") {
            var finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        }
        else {
            Toast.makeText(this, "Please Select a Skill Level", Toast.LENGTH_SHORT).show()
        }
    }

}