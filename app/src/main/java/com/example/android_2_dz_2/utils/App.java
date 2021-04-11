package com.example.android_2_dz_2.utils;

import android.app.Application;

import androidx.room.Room;

import com.example.android_2_dz_2.ui.room.NoteDatabase;

public class App extends Application {

    public static App instance;
    public static PrefsHelper prefsHelper;
    public static NoteDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        prefsHelper = new PrefsHelper(this);
        database = Room.databaseBuilder(getApplicationContext(),
                NoteDatabase.class,
                "database").allowMainThreadQueries()
                .build();
    }
}
