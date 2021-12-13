package com.snowbear.transitionanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityOptionsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val up = GlobalVariable.up
        val down = GlobalVariable.down
        val left = GlobalVariable.left
        val right = GlobalVariable.right

        val but_up = findViewById<Button>(R.id.but_up)
        val but_down = findViewById<Button>(R.id.but_down)
        val but_left = findViewById<Button>(R.id.but_left)
        val but_right = findViewById<Button>(R.id.but_right)

        val trainsition = listOf<String>("explode", "slide", "fade")

        but_up.setOnClickListener {
            sliedTransition(up)
        }

        but_down.setOnClickListener {
//            startTransitionWithFlag(trainsition[2])
            sliedTransition(down)
        }

        but_left.setOnClickListener {
            sliedTransition(left)
        }

        but_right.setOnClickListener {
            sliedTransition(right)
        }

    }

    private fun startTransitionWithFlag(flag: String) {
        val intent_2 = Intent(this, SecondActivity::class.java)
        intent_2.putExtra("flag", flag)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this)
        startActivity(intent_2, options.toBundle())
    }

    private fun sliedTransition(but: String) {
        val intent_2 = Intent(this, SecondActivity::class.java)
        intent_2.putExtra("slideAnimation", but)
        startActivity(intent_2)
        overridePendingTransition(R.anim.slide_up_in, R.anim.no_animation)

        when(but) {
            "up" -> overridePendingTransition(R.anim.slide_up_in, R.anim.no_animation)
            "down" -> overridePendingTransition(R.anim.slide_down_in, R.anim.no_animation)
            "left" -> overridePendingTransition(R.anim.slide_left_in, R.anim.no_animation)
            "right" -> overridePendingTransition(R.anim.slide_right_in, R.anim.no_animation)
        }
    }
}

