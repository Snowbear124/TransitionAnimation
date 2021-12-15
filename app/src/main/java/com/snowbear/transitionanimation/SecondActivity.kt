package com.snowbear.transitionanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.util.Log
import android.view.KeyEvent
import android.view.Window
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        setupTrainsition() //requestFeature必須放在最前面
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if(supportActionBar != null) {
            supportActionBar!!.hide()
        }

    }

    private fun setupTrainsition() {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        when(intent.getStringExtra("flag")) {
            "explode" -> {
                val explodeTrainsition = Explode()
                explodeTrainsition.duration = 1000
                window.enterTransition = explodeTrainsition
                window.exitTransition = explodeTrainsition
            }

            "slide" -> {
                val sliderTrainsition = Slide()
                sliderTrainsition.duration = 1000
                sliderTrainsition.pathMotion
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


    override fun finish() {
        super.finish()  //放最前面才能執行動畫
        when(intent.getStringExtra("slideAnimation")) {
            "up" -> overridePendingTransition(R.anim.no_animation, R.anim.slide_down_out)
            "down" -> overridePendingTransition(R.anim.no_animation, R.anim.slide_up_out)
            "left" -> overridePendingTransition(R.anim.no_animation, R.anim.slide_right_out)
            "right" -> overridePendingTransition(R.anim.no_animation, R.anim.slide_left_out)
        }
        Log.d(TAG, "finish: run....")
    }

//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
////            overridePendingTransition(R.anim.slide_up_out, R.anim.no_animation)
//            Log.d(TAG, "back Key run....")
////            return false
//        }
//        return super.onKeyDown(keyCode, event)
//    }
}