package com.example.du_inferno.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class Volunteer_Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer__form);

        Button btn = (Button)findViewById(R.id.Submit_Vol);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Volunteer_Form.this, DatabaseHandler.class);
                EditText EName = (EditText) findViewById(R.id.Name);
                String Name= EName.getText().toString();

                EName = (EditText) findViewById(R.id.Email);
                String Email= EName.getText().toString();

                EName = (EditText) findViewById(R.id.Phone);
                String Phone= EName.getText().toString();

                EName = (EditText) findViewById(R.id.Address);
                String Address= EName.getText().toString();

                EName = (EditText) findViewById(R.id.Password);
                String Password= EName.getText().toString();

                Bundle bundle = new Bundle();

//Add your data to bundle
              /*  bundle.putString("Name",Name);
                bundle.putString("Email",Email);
                bundle.putString("Phone",Phone);
                bundle.putString("Address",Address);
                bundle.putString("Password",Password);

//Add the bundle to the intent
                /intent.putExtras(bundle);

                startActivity(intent);*/

                DatabaseHandler dbhandler = new DatabaseHandler(Volunteer_Form.this);
                Volunteer volunteer = new Volunteer(Name,Phone,Email,Password,Address);
                dbhandler.addVolunteer(volunteer);



                Log.d("Reading: ", "Reading all contacts..");
                List<Volunteer> contacts = dbhandler.getAllVolunteers();

                for (Volunteer cn : contacts) {
                    String log = "Id: "+cn.getEmail()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.d("Name: ", log);
                }
            }
        });
    }
}
