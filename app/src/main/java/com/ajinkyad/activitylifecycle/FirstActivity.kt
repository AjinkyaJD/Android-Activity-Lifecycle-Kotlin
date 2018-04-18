package com.ajinkyad.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class FirstActivity : ParentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        //Handle the click for button "Open Second Activity"
        findViewById<Button>(R.id.btnSecondActivity).setOnClickListener {
            //Navigates the User to Second Activity
            startActivity(Intent(this@FirstActivity, SecondActivity::class.java))
        }
    }
}