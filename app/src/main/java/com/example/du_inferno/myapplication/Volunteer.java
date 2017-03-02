package com.example.du_inferno.myapplication;


/**
 * Created by abida on 02/03/17.
 */

public class Volunteer  {

    //private variables

    String _name;
    String _phone_number;String Email ;String Password; String Address;

    // Empty constructor
    public  Volunteer(){

    }
    // constructor
    public  Volunteer( String name, String _phone_number,String Email , String Password, String Address){

        this._name = name;
        this._phone_number = _phone_number;
        this.Email = Email;
        this.Password = Password;
        this.Address = Address;
    }

    // constructor
    public  Volunteer(String name, String _phone_number){
        this._name = name;
        this._phone_number = _phone_number;
    }
    // getting ID


    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getPhoneNumber(){
        return this._phone_number;
    }

    // setting phone number
    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }
    public String getEmail(){
        return this.Email;
    }

    // setting phone number
    public void setEmail(String Email){
        this.Email = Email;
    }
    public String getAddress(){
        return this.Address;
    }

    // setting phone number
    public void setAddress(String Address){
        this.Address = Address;
    }

    public String getPassword(){
        return this.Password;
    }

    // setting phone number
    public void setPassword(String Address){
        this.Password = Password;
    }
}