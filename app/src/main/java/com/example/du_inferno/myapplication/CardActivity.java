package com.example.du_inferno.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.security.AccessController.getContext;

public class CardActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseDatabase ref;
    //ref = new FirebaseDatabase("https://console.firebase.google.com/project/inferno-9944a/Users");FirebaseDatabase("https://console.firebase.google.com/project/inferno-9944a/Users");

    // Get a reference to the todoItems child items it the database
    final DatabaseReference Users = database.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        //View v ;

        CardView cardview=(CardView )findViewById(R.id.vol);
        cardview.setOnClickListener(new View.OnClickListener() {
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
        cardview=(CardView )findViewById(R.id.doc);
        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CardActivity.this,Act_adv.class ));
            }
        });

        cardview=(CardView )findViewById(R.id.water);
        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CardActivity.this,water_image.class ));
            }
        });

        cardview=(CardView )findViewById(R.id.fire);
        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CardActivity.this,Fire_image.class ));
            }
        });

        cardview=(CardView )findViewById(R.id.hos);
        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CardActivity.this,hospital_image.class ));
            }
        });
    }
}
