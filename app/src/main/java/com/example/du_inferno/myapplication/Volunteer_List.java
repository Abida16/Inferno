package com.example.du_inferno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class Volunteer_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer__list);


       Button btn = (Button)findViewById(R.id.vollist);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseDatabase ref;
        //ref = new FirebaseDatabase("https://console.firebase.google.com/project/inferno-9944a/Users");FirebaseDatabase("https://console.firebase.google.com/project/inferno-9944a/Users");

        // Get a reference to the todoItems child items it the database
        final DatabaseReference Users = database.getReference("Users");

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                //mDatabase.child("<dbLocationTag>").addValueEventListener(new ValueEventListener() {
                Users.addValueEventListener(new ValueEventListener() {
                    //String str;
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String str = "";
                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            //while(dataSnapshot.hasChildren()) {
                            //DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                            str += dsp.getValue().toString();
                            //al.add(str);
                            System.out.println(str);
                            //dataSnapshot.getChildren().iterator().next();
                        }
                        System.out.println(" our database list of volun " + str);
                        Intent intent = new Intent("com.example.du_inferno.myapplication.vol_database");
                        intent.putExtra("mytext", str);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }



                });
            }

        });

       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Volunteer_List.this, RemoteDatabaseHandling.class));
            }
        });

        DatabaseHandler dbhandler = new DatabaseHandler(Volunteer_List.this);
        List<Volunteer> volunteers_list= dbhandler.getAllVolunteers();
        for (Volunteer vn : volunteers_list) {
            System.out.println("Id: "+vn.getEmail()+" ,Name: " + vn.getName() + " ,Phone: " + vn.getPhoneNumber());
            // Writing Contacts to log

        }*/
    }
}
