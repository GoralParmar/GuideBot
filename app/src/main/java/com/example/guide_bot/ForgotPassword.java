package com.example.guide_bot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    EditText username;
    Button send;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        username = (EditText) findViewById(R.id.username);
        send = (Button) findViewById(R.id.send);
        DB = new DBHelper(this);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();

                Boolean checkuser = DB.checkusername(user);
                if(checkuser==true)
                {
                    Intent intent = new Intent(getApplicationContext(),Reset.class);
                    intent.putExtra("username",user);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(ForgotPassword.this, "User does nto exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}