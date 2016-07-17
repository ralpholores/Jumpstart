package com.example.rapsk.jumpstart;

/**
 * Created by RAPSK on 7/18/2016.
 */
public class Firebase extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        com.firebase.client.Firebase.setAndroidContext(this);
    }
}
