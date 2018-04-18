package com.ajinkyad.activitylifecycle

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button

class SecondActivity : ParentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Handle the click for button "Show Dialog Box"
        findViewById<Button>(R.id.btnShowDialogBox).setOnClickListener { showDialogBox() }
    }


    fun showDialogBox() {

        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Activity Lifecycle")
        alertDialogBuilder.setMessage("Do you like this app ?")
        alertDialogBuilder.setPositiveButton("Yes") { dialog, which -> dialog.dismiss() }
        alertDialogBuilder.setNegativeButton("No") { dialog, which -> dialog.dismiss() }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}