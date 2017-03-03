package com.example.du_inferno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class adv_faid extends AppCompatActivity {

    TextView textView;
    StringBuffer stringBuffer;
    public void read(View view) throws IOException {
        FileInputStream fileInputStream = openFileInput("faid.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        stringBuffer = new StringBuffer();
        String line;
        while((line = bufferedReader.readLine())!=null)
        {
            stringBuffer.append(line+"\n");
        }
        textView.setText(stringBuffer.toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_faid);
        textView = (TextView)findViewById(R.id.aid_fld);
        textView.setMovementMethod(new ScrollingMovementMethod());
        /*FileInputStream fileInputStream;
        try {
            fileInputStream = openFileInput("faid.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            stringBuffer = new StringBuffer();
            String line;
            while((line = bufferedReader.readLine())!=null)
            {
                stringBuffer.append(line+"\n");
            }
            textView.setText(stringBuffer.toString());
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
