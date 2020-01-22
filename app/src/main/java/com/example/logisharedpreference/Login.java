package com.example.logisharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button mbtn_login;
    private Button mbtn_register;
    private EditText mlog_username;
    private EditText mlog_password;
    private SharedPreferences preferences;
    public static final String PREFS="prefs";
    public static final String PREFS_USERNAME= "username";
    public static final String PREFS_PASSWORD= "password";

    Register register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mbtn_login = findViewById(R.id.btn_reg);
        mbtn_register = findViewById(R.id.btn_register);
        mlog_username = findViewById(R.id.log_username);
        mlog_password = findViewById(R.id.log_password);

        preferences =  getSharedPreferences(PREFS,MODE_PRIVATE);

        mbtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String loginUser = mlog_username.getText().toString();
               String loginPass = mlog_password.getText().toString();

               String saveUsername = preferences.getString(PREFS_USERNAME, "");
               String savePassword = preferences.getString(PREFS_PASSWORD,"");


                boolean checking =  loginUser.isEmpty() || loginPass.isEmpty();
                if (checking){
                    Toast.makeText(Login.this, "User or password empty", Toast.LENGTH_LONG).show();
                }
                else {
                    boolean userNotExist= saveUsername.isEmpty()||savePassword.isEmpty();

                    if(userNotExist){
                       // Intent goToRegister = new Intent(Login.this, Register.class);
                        Toast.makeText(Login.this, "User do not exist, must register", Toast.LENGTH_LONG).show();
                        //startActivity(goToRegister);
                    }
                    else{
                        boolean userExist = loginUser.equals(saveUsername) && loginPass.equals(savePassword);
                        if(userExist){
                            Intent goToWelcome = new Intent(Login.this, Welcome.class);
                            startActivity(goToWelcome);
                        }
                        else{
                            Toast.makeText(Login.this,"User or Password are wrong!",Toast.LENGTH_LONG).show();
                        }


                    }

                }

            }
        });
        mbtn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegister = new Intent(Login.this, Register.class);
                startActivity(goToRegister);
            }
        });

    }
}
