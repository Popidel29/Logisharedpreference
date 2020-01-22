package com.example.logisharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    private TextView mTextView;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mTextView = findViewById(R.id.textView);

        Intent welcome = getIntent();

        String display = prefs.getString(Login.PREFS_USERNAME, "");
        mTextView.setText(""+display);

        

    }
}
