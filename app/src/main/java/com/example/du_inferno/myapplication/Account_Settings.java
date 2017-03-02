package com.example.du_inferno.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Account_Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account__settings);
    }

    public static class Voluntier_Form extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_volunteer__form);
        }
    }
}
