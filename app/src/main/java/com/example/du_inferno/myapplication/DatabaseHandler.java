package com.example.du_inferno.myapplication;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "VolunteersManager";

    // Volunteers table name
    private static final String TABLE_Volunteers = "TVolunteer";

    // Volunteers Table Columns names

    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PH_NO = "phone_number";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_PASSWORD = "password";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
      // onUpgrade( db,1,2);
       String CREATE_VolunteerS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_Volunteers + "("
                + KEY_EMAIL + " TEXT PRIMARY KEY," + KEY_ADDRESS+ " TEXT," + KEY_PASSWORD  + " TEXT," +KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT " +  ")";
        db.execSQL(CREATE_VolunteerS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Volunteers);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new Volunteer
    void addVolunteer(Volunteer Volunteer) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, Volunteer.getEmail());
        values.put(KEY_ADDRESS, Volunteer.getAddress()); // Volunteer Phone
        values.put(KEY_PASSWORD, Volunteer.getPassword()); // Volunteer Phone// Volunteer Name
        values.put(KEY_NAME, Volunteer.getName()); // Volunteer Name
        values.put(KEY_PH_NO, Volunteer.getPhoneNumber()); // Volunteer Phone


        // Inserting Row
        db.insert(TABLE_Volunteers, null, values);
        db.close(); // Closing database connection
    }

    // Getting single Volunteer
    Volunteer getVolunteer(String Email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_Volunteers, new String[] { KEY_EMAIL,KEY_ADDRESS,KEY_PASSWORD,
                        KEY_NAME, KEY_PH_NO }, KEY_EMAIL + "=?",
                new String[] {Email }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Volunteer Volunteer = new Volunteer(cursor.getString(0), cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4));
        // return Volunteer
        return Volunteer;
    }

    // Getting All Volunteers
    public List<Volunteer> getAllVolunteers() {
        List<Volunteer> VolunteerList = new ArrayList<Volunteer>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_Volunteers;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Volunteer Volunteer = new Volunteer();
                Volunteer.setEmail(cursor.getString(0));
                Volunteer.setAddress(cursor.getString(1));
                Volunteer.setPassword(cursor.getString(2));
                Volunteer.setName(cursor.getString(3));
                Volunteer.setPhoneNumber(cursor.getString(4));

                // Adding Volunteer to list
                VolunteerList.add(Volunteer);
            } while (cursor.moveToNext());
        }

        // return Volunteer list
        return VolunteerList;
    }

    // Updating single Volunteer


    // Deleting single Volunteer
    public void deleteVolunteer(Volunteer Volunteer) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Volunteers, KEY_EMAIL  + " = ?",
                new String[] { String.valueOf(Volunteer.getEmail()) });
        db.close();
    }


    // Getting Volunteers Count
    public int getVolunteersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_Volunteers;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}