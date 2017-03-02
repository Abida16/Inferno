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
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "VolunteersManager";

    // Volunteers table name
    private static final String TABLE_Volunteers = "Volunteers";

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
        String CREATE_VolunteerS_TABLE = "CREATE TABLE " + TABLE_Volunteers + "("
                + KEY_EMAIL + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + KEY_ADDRESS+ " TEXT" + KEY_PASSWORD  + " TEXT" + ")";
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
        values.put(KEY_NAME, Volunteer.getName()); // Volunteer Name
        values.put(KEY_PH_NO, Volunteer.getPhoneNumber()); // Volunteer Phone
        values.put(KEY_EMAIL, Volunteer.getEmail()); // Volunteer Name
        values.put(KEY_ADDRESS, Volunteer.getAddress()); // Volunteer Phone
        values.put(KEY_PASSWORD, Volunteer.getAddress()); // Volunteer Phone
        // Inserting Row
        db.insert(TABLE_Volunteers, null, values);
        db.close(); // Closing database connection
    }

    // Getting single Volunteer
    Volunteer getVolunteer(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_Volunteers, new String[] { KEY_EMAIL,
                        KEY_NAME, KEY_PH_NO ,KEY_ADDRESS,KEY_PASSWORD}, KEY_EMAIL + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Volunteer Volunteer = new Volunteer(cursor.getString(0), cursor.getString(1), cursor.getString(2));
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
                Volunteer.setID(Integer.parseInt(cursor.getString(0)));
                Volunteer.setName(cursor.getString(1));
                Volunteer.setPhoneNumber(cursor.getString(2));
                // Adding Volunteer to list
                VolunteerList.add(Volunteer);
            } while (cursor.moveToNext());
        }

        // return Volunteer list
        return VolunteerList;
    }

    // Updating single Volunteer
    public int updateVolunteer(Volunteer Volunteer) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, Volunteer.getName());
        values.put(KEY_PH_NO, Volunteer.getPhoneNumber());

        // updating row
        return db.update(TABLE_Volunteers, values, KEY_ID + " = ?",
                new String[] { String.valueOf(Volunteer.getID()) });
    }

    // Deleting single Volunteer
    public void deleteVolunteer(Volunteer Volunteer) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Volunteers, KEY_ID + " = ?",
                new String[] { String.valueOf(Volunteer.getID()) });
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