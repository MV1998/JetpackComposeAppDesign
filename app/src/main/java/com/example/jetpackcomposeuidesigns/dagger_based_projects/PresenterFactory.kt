package com.example.jetpackcomposeuidesigns.dagger_based_projects

import android.util.Log
import com.example.jetpackcomposeuidesigns.MainActivity
import dagger.Component
import javax.inject.Inject
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet


@Component
interface CarFactory {
    fun getCar() : Lazy<Car>
    fun inject(activity: MainActivity)
}


class Car @Inject constructor(val engine: Engine) {
    var speed = 12f

    fun start() {
        engine.start()
    }

    fun stop() {
        engine.stop()
    }

    fun speedUp() {
        if (engine.isEngineStarted) {
            speed *= 2
            Log.d("TAG", "speedUp: $speed accelerated.")
        } else {
            Log.d("TAG", "start the engine ")
        }
    }

    fun breakUp() {
        if (engine.isEngineStarted) {
            speed -= 2
            Log.d("TAG", "speedUp: $speed accelerated.")
        } else {
            Log.d("TAG", "engine is not started still break are being used.")
        }
    }
}



class Engine @Inject constructor() {

    private val engineName = "TESLA1232"
    var isEngineStarted = false

    fun start() {
        Log.d("TAG", "start: Engine $engineName started.")
        isEngineStarted = true
    }

    fun stop() {
        Log.d("TAG", "stop: Engine $engineName stopped.")
        isEngineStarted = false
    }
}