package com.example.android_exercise_shared_preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "exercise_shared_preferences";
    private static final String PREF_NAME = "shared_preferences";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor data;

    String name;
    String birth;
    float doc;
    float phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: Running");

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        Log.i(TAG, "onCreate: Folder Shared Preferences Created");

        data = sharedPreferences.edit();
        name = "Gustavo Mendes Zucolo";
        birth = "13/05/1988";
        doc = 12345678912F;
        phoneNumber = 12345678912F;

        data.putString("name", name);
        data.putString("birth", birth);
        data.putFloat("doc", doc);
        data.putFloat("phoneNumber", phoneNumber);

        data.apply();

        //debug mode

        Log.i(TAG, "onCreate: Saving Data");
        Log.i(TAG, "onCreate: name: " + name);
        Log.i(TAG, "onCreate: birth: " + birth);
        Log.i(TAG, "onCreate: doc: " + doc);
        Log.i(TAG, "onCreate: phoneNumber: " + phoneNumber);

        /*
        to clean data
        data.clear();
        data.apply();
        */

        /*
        to remove data
        data.remove("phoneNumber");
        data.apply();
        */

        Log.i(TAG, "onCreate: Recovering Data");
        Log.i(TAG, "onCreate: name: " + sharedPreferences.getString("name", "Unknown"));
        Log.i(TAG, "onCreate: birth: " + sharedPreferences.getString("birth", "Unknown"));
        Log.i(TAG, "onCreate: doc: " + sharedPreferences.getFloat("doc", 11111111111F));
        Log.i(TAG, "onCreate: phoneNumber: " + sharedPreferences.getFloat("phoneNumber", 11111111111F));

        //deleting phoneNumber

        data.remove("phoneNumber");
        data.apply();

        Log.i(TAG, "onCreate: Recovering Data");
        Log.i(TAG, "onCreate: name: " + sharedPreferences.getString("name", "Unknown"));
        Log.i(TAG, "onCreate: birth: " + sharedPreferences.getString("birth", "Unknown"));
        Log.i(TAG, "onCreate: doc: " + sharedPreferences.getFloat("doc", 11111111111F));
        Log.i(TAG, "onCreate: phoneNumber: " + sharedPreferences.getFloat("phoneNumber", 11111111111F));

    }
}