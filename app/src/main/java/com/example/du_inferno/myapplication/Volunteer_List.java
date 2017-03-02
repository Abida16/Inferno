package com.example.du_inferno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class Volunteer_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer__list);
        DatabaseHandler dbhandler = new DatabaseHandler(Volunteer_List.this);
        List<Volunteer> volunteers_list= dbhandler.getAllVolunteers();
        for (Volunteer vn : volunteers_list) {
            System.out.println("Id: "+vn.getEmail()+" ,Name: " + vn.getName() + " ,Phone: " + vn.getPhoneNumber());
            // Writing Contacts to log

        }
    }
}
