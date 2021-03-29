package com.example.android_2_dz_2.ui.home.homeadapter;

import java.io.Serializable;

public class HomeModel implements Serializable {
    private String name;
    private String number;

    public HomeModel(String name, String number) {
        this.name = name;
        this.number = number;
    }

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
