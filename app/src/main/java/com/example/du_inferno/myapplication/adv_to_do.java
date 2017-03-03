package com.example.du_inferno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class adv_to_do extends AppCompatActivity {

    EditText editText;
    TextView textView;
    StringBuffer stringBuffer;
    public void read() throws IOException {
        FileInputStream fileInputStream = openFileInput("td.txt");
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
    public void write(View view) throws IOException {
        String str = editText.getText().toString();
        FileOutputStream fileOutputStream = openFileOutput("File.txt",MODE_APPEND);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
        Toast.makeText(getApplicationContext(), "Saved myFIle.txt", Toast.LENGTH_SHORT).show();
        editText.setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_to_do);
        textView = (TextView)findViewById(R.id.td_fld);
        textView.setMovementMethod(new ScrollingMovementMethod());
        //editText = (EditText)findViewById(R.id.in);

        /*try {
            read();
            textView.setText(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
