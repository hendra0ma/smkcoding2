package com.corona.savelive.firebaseNotif

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val TAG = "myFirebase"

    override fun onMessageReceived(p0: RemoteMessage) {
        Log.d(TAG,"from"+p0!!.from)
        Log.d(TAG,"notifby : "+p0!!.notification?.body!!)

    }
    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")

    }
}