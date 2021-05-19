package com.lockscreen.test.lockscreenkotlinexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.lockscreen.test.lockscreenkotlinexample.lockscreen.LockScreenActivity
import com.lockscreen.test.lockscreenkotlinexample.lockscreen.util.LockScreen
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Main Activity
 */

class MainActivity : AppCompatActivity() {

    private val lockScreenStatusPreferences by lazy { getSharedPreferences("LockScreenStatus", Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLockScreenSwitch()
        setChangeLockScreenSwitch()
        setShowLockScreenButton()
        setYoutubebutton()
        setCalculatorbutton()

    }

    private fun setShowLockScreenButton() {
        showLockScreenViewButton.setOnClickListener {
            startActivity(LockScreenActivity.newIntent(this@MainActivity))
        }
    }

    private fun setLockScreenStatus(lockScreenStatus : Boolean) {
        lockScreenStatusPreferences.edit()?.run {
            putBoolean("LockScreenStatus", lockScreenStatus)
            apply()
        }
    }

    private fun setChangeLockScreenSwitch() {
        lockScreenSwitch.setOnCheckedChangeListener { _, isChecked ->
            setLockScreenStatus(isChecked)
            if (isChecked) {
                LockScreen.active()
                Snackbar.make(lockScreenSwitch, getString(R.string.lockscrenOn), Snackbar.LENGTH_LONG).show()
            } else {
                LockScreen.deActivate()
                Snackbar.make(lockScreenSwitch, getString(R.string.lockscrenOff), Snackbar.LENGTH_LONG).show()
            }
        }
    }


    private fun initLockScreenSwitch() {
        val hasLockScreen = LockScreen.getLockScreenStatus()
        lockScreenSwitch.isChecked = hasLockScreen
        if (hasLockScreen) {
            LockScreen.active()
        }
        else { LockScreen.deActivate() }
    }


    private fun setYoutubebutton() {
        Youtubebutton.setOnClickListener {
            Toast.makeText(applicationContext, "youtube버튼이 눌러졌습니다.", Toast.LENGTH_LONG).show()
            val intent = packageManager.getLaunchIntentForPackage("com.google.android.youtube")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
    private fun setCalculatorbutton() {
        Calculatorbutton.setOnClickListener {
            Toast.makeText(applicationContext, "Calculatorbutton이 눌러졌습니다.", Toast.LENGTH_LONG).show()
            val intent = packageManager.getLaunchIntentForPackage("com.N5_team.Calculator")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

    }

}


