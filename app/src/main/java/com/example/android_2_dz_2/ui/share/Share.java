package com.example.android_2_dz_2.ui.share;

import android.content.Context;
import android.content.SharedPreferences;

public class Share {

    private SharedPreferences sharedPreferences = null;
    public static final String APP_PREFERNCES = "my setting";
    public static final String BOOLEAN_FOR_SHOW_OPEN = "show";
    public static final String FOR_NAME = "name";
    public static final String SAVE_SORT = "sort";

    public Share(Context context){
        sharedPreferences = context.getSharedPreferences(APP_PREFERNCES,context.MODE_PRIVATE);
    }
    public void saveBoardShow(Boolean isShown){
        sharedPreferences.edit().putBoolean(BOOLEAN_FOR_SHOW_OPEN,isShown).apply();
    }

    public Boolean isBoardShow(){
        return sharedPreferences.getBoolean(BOOLEAN_FOR_SHOW_OPEN,false);
    }
    public void setForName(String name){
        sharedPreferences.edit().putString(FOR_NAME,name).apply();
    }
    public String getForName(){
        return sharedPreferences.getString(FOR_NAME,"");
    }
    public void saveSort(Boolean saveSort){
        sharedPreferences.edit().putBoolean(SAVE_SORT,saveSort).apply();
    }
    public Boolean getSaveSort(){
        return sharedPreferences.getBoolean(SAVE_SORT,false);
    }
}

