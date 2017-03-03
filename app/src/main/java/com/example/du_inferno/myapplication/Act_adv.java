package com.example.du_inferno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Act_adv extends AppCompatActivity {
    private static Button adv_btn_wp,adv_btn_aid,adv_btn_td;
    public void onClickButtonListenerAdv_wip()
    {
        adv_btn_wp = (Button)findViewById(R.id.out);
        adv_btn_wp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intnt = new Intent("com.example.du_inferno.myapplication.adv_wp_out");
                        startActivity(intnt);
                    }
                }
        );
    }
    public void onClickButtonListenerAdv_aid()
    {
        adv_btn_aid = (Button)findViewById(R.id.F_aid);
        adv_btn_aid.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intnt = new Intent("com.example.du_inferno.myapplication.adv_faid");
                        startActivity(intnt);
                    }
                }
        );
    }
    public void onClickButtonListeneradv_td()
    {
        adv_btn_td = (Button)findViewById(R.id.T_D);
        adv_btn_td.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intnt = new Intent("com.example.du_inferno.myapplication.adv_to_do");
                        startActivity(intnt);
                    }
                }
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_adv);
        onClickButtonListeneradv_td();
        onClickButtonListenerAdv_aid();
        onClickButtonListenerAdv_wip();
    }
}
