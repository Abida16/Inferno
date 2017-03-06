package com.example.du_inferno.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class NevigationBarActivities extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*private static Button adv_btn;

    public void onClickButtonListener()
    {
        adv_btn = (Button)findViewById(R.id.adv);
        adv_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intnt = new Intent("com.example.du_inferno.myapplication");
                        startActivity(intnt);
                    }
                }
        );
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing__account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*Button btn = (Button)findViewById(R.id.map_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NevigationBarActivities.this, MapsActivity.class));
            }
        });

        btn = (Button)findViewById(R.id.Remote_db);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NevigationBarActivities.this, RemoteDatabaseHandling.class));
            }
        });
        //onClickButtonListener();
        Button adv_btn = (Button)findViewById(R.id.adv);
        adv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent("com.example.du_inferno.myapplication.Act_adv"));
               // startActivity(new Intent(NevigationBarActivities.this, RemoteDatabaseHandling.class));
            }
        });*/

        Button button= (Button) findViewById(R.id.menu);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( NevigationBarActivities.this, CardActivity.class);
                startActivity(intent);
            }

        });

        button=(Button) findViewById(R.id.emergency);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(NevigationBarActivities.this, call_Activity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.editing__account, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(NevigationBarActivities.this,Settings.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_volunteer) {

            startActivity(new Intent(NevigationBarActivities.this,Volunteer_Form.class));
        } else if (id == R.id.nav_acc_setting) {
            startActivity(new Intent(NevigationBarActivities.this,Account_Settings.class));
        } else if (id == R.id.nav_add_contact) {
            startActivity(new Intent(NevigationBarActivities.this,Emergency_Contact.class));

        }
        else if (id == R.id.nav_view_location) {
            startActivity(new Intent(NevigationBarActivities.this,MapsActivity.class));

        }
        else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
