package com.example.android_2_dz_2.ui.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.android_2_dz_2.ui.home.homeadapter.HomeModel;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM homemodel")
    LiveData<List<HomeModel>> getAll();

    @Insert
    void insert(HomeModel homemodel);
    @Update
    void updata(HomeModel homeModel);

    @Delete
    void dalete(HomeModel homeModel);







}
