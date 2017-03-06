package com.example.du_inferno.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }

    protected void onStart() {
        super.onStart();

        Button button= (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()) {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SignUp_Activity.this.getApplicationContext());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(getString(R.string.SignedIn), true);
                    editor.apply();
                    Intent intent = new Intent(SignUp_Activity.this, NevigationBarActivities.class);
                    startActivity(intent);
                }

            }

        });



    }

    public boolean checkInput(){
        EditText name = (EditText) findViewById(R.id.NameText);
        EditText address = (EditText) findViewById(R.id.AddressText);
        EditText email = (EditText) findViewById(R.id.emailText);
        EditText phone = (EditText) findViewById(R.id.PhoneText);
        EditText pass = (EditText) findViewById(R.id.passwordText);

        String a=name.getText().toString();
        String b=address.getText().toString();
        String c=email.getText().toString();
        String d=phone.getText().toString();
        String e=pass.getText().toString();

        if(a.length()==0 || b.length()==0 ||c.length()==0 || d.length()==0 || e.length()==0 ){
            Toast.makeText(SignUp_Activity.this,"Not Enough Information to Sign Up!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;

    }


}
