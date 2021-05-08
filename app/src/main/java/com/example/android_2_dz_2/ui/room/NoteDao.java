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



    //дастать , сортировка
    @Query("SELECT * FROM homemodel")
    LiveData<List<HomeModel>> getAll();


    @Query("SELECT * FROM HomeModel ORDER by name ASC")
    List<HomeModel> getAsc();


    //добавить
    @Insert
    void insert(HomeModel homemodel);

    //    обновление
    @Update
    void updata(HomeModel homeModel);

//    удаление

    @Delete
    void dalete(HomeModel homeModel);



}
