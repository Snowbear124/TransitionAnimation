package com.snowbear.transitionanimation

import android.app.Application

class GlobalVariable: Application() {
    companion object{
        val up = "up"
        val down = "down"
        val left = "left"
        val right = "right"
    }
}