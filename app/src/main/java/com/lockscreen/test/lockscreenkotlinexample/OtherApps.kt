package com.lockscreen.test.lockscreenkotlinexample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_other_apps.*

class OtherApps : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_apps)
        setYoutubebutton()
        setFacebookbutton()
        setinstagrambutton()



    }

    private fun setYoutubebutton() {
        youtubebutton.setOnClickListener {
            Toast.makeText(applicationContext, "youtube버튼이 눌러졌습니다.", Toast.LENGTH_LONG).show()
            val intent = packageManager.getLaunchIntentForPackage("com.google.android.youtube")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
    private fun setFacebookbutton() {
        Facebookbutton.setOnClickListener {
            Toast.makeText(applicationContext, "Facebook버튼이 눌러졌습니다.", Toast.LENGTH_LONG).show()
            val intent = packageManager.getLaunchIntentForPackage("com.facebook.katana")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    private fun setinstagrambutton() {
        Instagrambutton.setOnClickListener {
            Toast.makeText(applicationContext, "instagram버튼이 눌러졌습니다.", Toast.LENGTH_LONG).show()
            val intent = packageManager.getLaunchIntentForPackage("com.instagram.android")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

}