package com.example.android_2_dz_2.ui.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.android_2_dz_2.ui.home.homeadapter.HomeModel;

@Database(entities = {HomeModel.class},version = 1)
public abstract class  NoteDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
