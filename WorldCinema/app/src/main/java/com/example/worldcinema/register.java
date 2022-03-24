package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.worldcinema.Networking.RegUser.RegMock;


public class register extends AppCompatActivity {

    private EditText et_email, et_password, et_firstName, et_lastName, et_repeat;
    private String email, password, firstName, lastName, repeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        et_email = findViewById(R.id.act_reg_ed_email);
        et_firstName = findViewById(R.id.act_reg_ed_firstname);
        et_lastName = findViewById(R.id.act_reg_ed_lastname);
        et_password = findViewById(R.id.act_reg_ed_password);
        et_repeat = findViewById(R.id.act_reg_ed_password_repeat);
    }

    public void r_register_click(View view){
        email = et_email.getText().toString();
        firstName = et_firstName.getText().toString();
        lastName = et_lastName.getText().toString();
        password = et_password.getText().toString();
        repeat = et_repeat.getText().toString();

        new RegMock(email, firstName, lastName, password, this);
    }
}