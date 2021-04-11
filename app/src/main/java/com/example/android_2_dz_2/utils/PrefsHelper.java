package com.example.android_2_dz_2.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsHelper {
    private SharedPreferences sharedPreferences  = null;
    private final String BOARD_KEY = "bard_key";

       public PrefsHelper(Context context) {
           sharedPreferences = context.getSharedPreferences("pref",
                    Context.MODE_PRIVATE);

        }
        public void saveBoardShown(Boolean isShown){
        sharedPreferences.edit().putBoolean(BOARD_KEY,isShown).apply();
        }


         public Boolean isBoardShow(){
      return   sharedPreferences.getBoolean(BOARD_KEY, false);
     }



}

