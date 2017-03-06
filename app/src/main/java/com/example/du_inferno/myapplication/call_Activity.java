package com.example.du_inferno.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

import static java.security.AccessController.getContext;


public class call_Activity extends AppCompatActivity {
    String phoneNo;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.content_editing__account);
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:01767698004"));
        phoneNo = "01953057383";
        message = "ebar?";

        if (ActivityCompat.checkSelfPermission(call_Activity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        sendSMS(phoneNo, message);
        startActivity(callIntent);
        Intent intent = new Intent(call_Activity.this , MainPage_Activity.class);
        startActivity(intent);

    }
    private void sendSMS(String phoneNumber, String message)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
}
