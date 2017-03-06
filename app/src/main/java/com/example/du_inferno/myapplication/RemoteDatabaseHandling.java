package com.example.du_inferno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class RemoteDatabaseHandling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_database_handling);
        final ListView listView = (ListView) findViewById(R.id.listView);

        // Create a new Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // Connect to the Firebase database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseDatabase ref;
        //ref = new FirebaseDatabase("https://console.firebase.google.com/project/inferno-9944a/Users");FirebaseDatabase("https://console.firebase.google.com/project/inferno-9944a/Users");

        // Get a reference to the todoItems child items it the database
       final DatabaseReference Users = database.getReference("Users");
      //  final DatabaseReference  Users = database.getReference("Volunteers");

        // Assign a listener to detectanges to the child items
        // of the database reference.
        Users.addChildEventListener(new ChildEventListener() {

            // This function is called once for each child that exists
            // when the listener is added. Then it is called
            // each time a new child is added.
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                String value = dataSnapshot.getValue(String.class);
                adapter.add(value);
            }

            // This function is called each time a child item is removed.
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                adapter.remove(value);
            }

            // The following functions are also required in ChildEventListener implementations.
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG:", "Failed to read value.", error.toException());
            }
        });

        // Add items via the Button and EditText at the bottom of the window.
        final EditText text = (EditText) findViewById(R.id.nametext);
        final Button button = (Button) findViewById(R.id.addButton);





        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

               /* DatabaseHandler dbhandler = new DatabaseHandler(RemoteDatabaseHandling.this);
                List<Volunteer> volunteers_list= dbhandler.getAllVolunteers();

                for (Volunteer vn : volunteers_list) {
                    String str="";
                    str="Email: "+vn.getEmail()+" ,?Name: " + vn.getName() + " ,?Phone: " + vn.getPhoneNumber()
                            +" ,?Address: " + vn.getAddress() ;
                    System.out.println(str+"\n");
                    DatabaseReference childRef = Users.push();
                    childRef.setValue(str);
                    // Writing Contacts to log

                }*/
               // DatabaseReference childRef = Users.push();

                // Set the child's data to the value passed in from the text box.
                DatabaseReference childRef = Users.push();
                childRef.setValue(text.getText().toString());
                //childRef.setValue(str);

            }
        });

        final Button button2 = (Button) findViewById(R.id.showButton);
        //final LinkedList<String> al=new LinkedList<String>();
        //final String str="";
        button2.setOnClickListener(new View.OnClickListener(){
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
                            str+=dsp.getValue().toString()+"\n";
                            //al.add(str);
                            System.out.println(str);
                            //dataSnapshot.getChildren().iterator().next();
                        }
                        System.out.println(" our database list of volun "+str);
                        Intent intent = new Intent("com.example.du_inferno.myapplication.vol_database");
                        intent.putExtra("mytext",str);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
                /*System.out.println(" our database list of volun "+str);
                Intent intent = new Intent("com.example.du_inferno.myapplication.vol_database");
                intent.putExtra("mytext",str);
                startActivity(intent);*/
                /*Users.child("<dbLocationTag>").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        // the changed value is going to be stored into the dataSnapshot
                        // to retrieve value from dataSnapshot we write

                        String value = dataSnapshot.getValue(String.class);
                        System.out.println(value+"\n\r");
                        //mValueView.setText(value);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //mValueView.setText(databaseError.toString());
                        System.out.println(databaseError.toString());

                    }
                });*/

            }

        });
        // Delete items when clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Query myQuery = Users.orderByValue().equalTo((String)
                        listView.getItemAtPosition(position));

                myQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()) {
                            DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                            firstChild.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                })
                ;
            }
        })
        ;
    }

    public void DataSave()
    {

    }

    public void DataRetrieve()
    {

    }
}