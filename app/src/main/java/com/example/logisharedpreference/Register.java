package com.example.logisharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private Button mBtn_reg;
    private EditText mUser_reg;
    private EditText mPass_reg;
    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mBtn_reg = findViewById(R.id.btn_regiser);
        mUser_reg = findViewById(R.id.user_reg);
        mPass_reg = findViewById(R.id.pass_reg);

        prefs = getSharedPreferences(Login.PREFS, MODE_PRIVATE);

        mBtn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mUser_reg.getText().toString();
                String pass = mPass_reg.getText().toString();
                boolean checking = user.isEmpty() && pass.isEmpty();

                if (checking) {
                    Toast.makeText(Register.this, "User or password empty", Toast.LENGTH_LONG).show();
                } else {

                    SharedPreferences.Editor editor = prefs.edit();

                    editor.putString(Login.PREFS_USERNAME, user);
                    editor.putString(Login.PREFS_PASSWORD, pass);

                    editor.apply();

                    Intent goToLogin = new Intent(Register.this, Login.class);

                    startActivity(goToLogin);
                }
            }
        });
    }

}
