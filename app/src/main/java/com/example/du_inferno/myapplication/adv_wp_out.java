package com.example.du_inferno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class adv_wp_out extends AppCompatActivity {

    TextView textView;
    StringBuffer stringBuffer;
    public void read() throws IOException {
        FileInputStream fileInputStream = openFileInput("out.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        stringBuffer = new StringBuffer();
        String line;
        while((line = bufferedReader.readLine())!=null)
        {
            stringBuffer.append(line+"\n");
        }
        //textView.setText(stringBuffer.toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_wp_out);
        textView = (TextView)findViewById(R.id.out_fld);
        textView.setMovementMethod(new ScrollingMovementMethod());
        try {
            read();
            textView.setText(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
