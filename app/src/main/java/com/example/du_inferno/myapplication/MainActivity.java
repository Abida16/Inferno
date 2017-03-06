package com.example.du_inferno.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if(sharedPreferences.getBoolean(getString(R.string.SignedIn),false)==false) {
            android.support.v4.app.FragmentTransaction ftr = getSupportFragmentManager().beginTransaction();
            ftr.replace(R.id.activity_main_fragments , new SignInFragment());
            ftr.commit();
        }


        else{
            Intent intent=new Intent(MainActivity.this,NevigationBarActivities.class);
            startActivity(intent);
        }
    }
}
