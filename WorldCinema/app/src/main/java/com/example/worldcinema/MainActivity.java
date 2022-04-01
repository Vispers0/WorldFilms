package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.worldcinema.Networking.LogUser.LogMock;
import com.example.worldcinema.Networking.LogUser.LogResponse;

public class MainActivity extends AppCompatActivity {

    private EditText et_email, et_password;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        et_email = findViewById(R.id.act_log_et_email);
        et_password = findViewById(R.id.act_log_et_password);
    }

    //Переход на активность регистрации
    public void register_click(View view){
        startActivity(new Intent(MainActivity.this, com.example.worldcinema.register.class));
    }

    //Вход пользователя
    public void login_click(View view){
        email = et_email.getText().toString();
        password = et_password.getText().toString();

        new LogMock(email, password, MainActivity.this);
    }


}