package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        if (validate()){
            new RegMock(email, firstName, lastName, password, this);
        }
        else{
            Toast.makeText(register.this, "Введённые пароли не совпадают", Toast.LENGTH_SHORT).show();
        }
    }

    public void have_acc_click(View view){
        startActivity(new Intent(register.this, MainActivity.class));
    }

    private boolean validate(){
        if (email.equals("")){
            Toast.makeText(register.this, "Введите электронную почту", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (firstName.equals("")){
            Toast.makeText(register.this, "Введите имя", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (lastName.equals("")){
            Toast.makeText(register.this, "Введите фамилию", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.equals("")){
            Toast.makeText(register.this, "Введите пароль", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (repeat.equals("")){
            Toast.makeText(register.this, "Введите пароль ещё раз", Toast.LENGTH_SHORT).show();
            return false;
        }

        return repeat.equals(password);
    }
}