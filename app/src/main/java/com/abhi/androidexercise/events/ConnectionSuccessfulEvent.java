package com.abhi.androidexercise.events;

import android.util.Log;

/**
 *  Author: Abhiraj Khare
 *  Description: Event fired by event bus, when network request is successful.
 */
public class ConnectionSuccessfulEvent {
    public ConnectionSuccessfulEvent(){
        Log.i("Event", "ConnectionSuccessfulEvent");
    }
}
