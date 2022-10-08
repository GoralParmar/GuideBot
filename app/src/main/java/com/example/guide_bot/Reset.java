package com.example.guide_bot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Reset extends AppCompatActivity {

    TextView username;
    EditText pass,repass;
    Button confirm;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        username = (TextView) findViewById(R.id.username_reset);
        pass = (EditText) findViewById(R.id.reset_password);
        repass = (EditText) findViewById(R.id.retype_password);
        confirm = (Button) findViewById(R.id.conform);
        DB = new DBHelper(this);

        Intent intent = getIntent();
        username.setText(intent.getStringExtra("username"));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String password = pass.getText().toString();
                String retypepass = repass.getText().toString();
                if(password.equals(retypepass)) {


                    Boolean checkpasswordupdate = DB.updatepassword(user, password);
                    if (checkpasswordupdate == true) {

                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                        Toast.makeText(Reset.this, "Password Update Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Reset.this, "Password Not Updated Successfully", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(Reset.this, "Password Not Match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}