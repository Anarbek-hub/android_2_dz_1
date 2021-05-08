package com.example.android_2_dz_2.ui.home.homeadapter;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class HomeModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String number;
    private String date;
    private String editDate = "НЕ был изменен";

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    public HomeModel(String name, String number, String date) {
        this.name = name;
        this.number = number;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//    private DateFormat dateFormat = new SimpleDateFormat("MMMM dd hh mm ss");
//    private String date = dateFormat.format(new Date());

//    public String getDate() {
//        return date;
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
