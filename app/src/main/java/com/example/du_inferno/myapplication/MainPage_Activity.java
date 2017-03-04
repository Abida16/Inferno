package com.example.du_inferno.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainPage_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        FragmentTransaction ftr = getSupportFragmentManager().beginTransaction();
        ftr.replace(R.id.activity_mainpage_fragments , new Main_Fragment());
        ftr.commit();


    }
}
