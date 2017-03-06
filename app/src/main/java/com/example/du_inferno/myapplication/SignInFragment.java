package com.example.du_inferno.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SignInFragment extends Fragment {


    public SignInFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);

    }

    public void onStart() {
        super.onStart();
        View v = getView();
        Button button= (Button)v.findViewById(R.id.signInBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check()) {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(getString(R.string.SignedIn), true);
                    editor.apply();
                    Intent intent = new Intent(getContext() , NevigationBarActivities.class);
                    startActivity(intent);
                }

            }

        });
        TextView textview=(TextView)v.findViewById(R.id.textView);
        textview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SignUp_Activity.class);
                startActivity(intent);
            }

        });


    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public boolean check(){
        View view = getView();
        EditText pass = (EditText)view.findViewById(R.id.password);
        EditText email = (EditText) view.findViewById(R.id.email);
        String a=pass.getText().toString();
        String b=email.getText().toString();
        if(a.length()==0 || b.length()==0){
            Toast.makeText(getActivity(),"Not Enough Information to Sign In!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
