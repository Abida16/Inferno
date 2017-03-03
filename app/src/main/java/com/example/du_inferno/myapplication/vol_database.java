package com.example.du_inferno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class vol_database extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vol_database);
        textView = (TextView)findViewById(R.id.vol_data);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(getIntent().getStringExtra("mytext"));

    }
}
