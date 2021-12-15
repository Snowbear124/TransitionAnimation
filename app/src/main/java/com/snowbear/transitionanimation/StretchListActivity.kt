package com.snowbear.transitionanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.view.Window

class StretchListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setupTrainsition() //requestFeature必須放在最前面
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stretch_list)
    }

    private fun setupTrainsition() {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        when (intent.getStringExtra("flag")) {
            "explode" -> {
                val explodeTrainsition = Explode()
                explodeTrainsition.duration = 800
                window.enterTransition = explodeTrainsition
                window.exitTransition = explodeTrainsition
            }

            "slide" -> {
                val sliderTrainsition = Slide()
                sliderTrainsition.duration = 200
                window.enterTransition = sliderTrainsition
                window.exitTransition = sliderTrainsition
            }

            "fade" -> {
                val fadeTrainsition = Fade()
                fadeTrainsition.duration = 1000
                window.enterTransition = fadeTrainsition
                window.exitTransition = fadeTrainsition
            }
        }
    }
}