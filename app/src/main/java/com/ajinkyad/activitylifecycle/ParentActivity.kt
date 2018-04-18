package com.ajinkyad.activitylifecycle

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.NotificationCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.app.NotificationChannel


open class ParentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logEvent("onCreate")
    }

    override fun onStart() {
        super.onStart()
        logEvent("onStart")
    }

    override fun onPause() {
        super.onPause()
        logEvent("onPause")
    }

    override fun onResume() {
        super.onResume()
        logEvent("onResume")
    }

    override fun onStop() {
        super.onStop()
        logEvent("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logEvent("onDestroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        logEvent("onRestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        logEvent("onSaveInstanceState")
    }


    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        logEvent("onPostCreate")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        logEvent("onPostCreate")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        logEvent("onBackPressed")
    }

    override fun onRestart() {
        super.onRestart()
        logEvent("onRestart")
    }

    override fun onPostResume() {
        super.onPostResume()
        logEvent("onPostResume")
    }

    /**
     * This function is used to fire the local Notification
     */
    private fun logEvent(methodName: String) {

        //The Current Activity Name
        val activityName = this.javaClass.simpleName
        Log.e(activityName, methodName)

        // There are hardcoding only for show it's just strings
        val name = "package_channel"
        val id = "channel_id" // The user-visible name of the channel.
        val description = "channel_description" // The user-visible description of the channel.

        val builder: NotificationCompat.Builder

        //To Trigger the local notification to the User
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            var mChannel = notificationManager.getNotificationChannel(id)
            if (mChannel == null) {
                mChannel = NotificationChannel(id, name, importance)
                mChannel.description = description
                notificationManager.createNotificationChannel(mChannel)
            }
            builder = NotificationCompat.Builder(this, id)

            builder.setContentTitle(activityName)  // required
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle(activityName)
                    .setContentText(methodName)
                    .setDefaults(Notification.DEFAULT_ALL)
        } else {

            builder = NotificationCompat.Builder(this)

            builder.setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle(activityName)
                    .setContentText(methodName)
                    .setDefaults(Notification.DEFAULT_ALL)
        }

        val notification = builder.build()
        //Trigger the notification if the notificationManager object is created successfully
        notificationManager.notify(System.currentTimeMillis().toInt(), notification)

    }
}