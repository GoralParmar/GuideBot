package com.example.guide_bot;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {

    Button Res;
    EditText fname, lname, email, Pass, confirpass;
    DBHelper DB;
    TextView Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EditText f = (EditText) findViewById(R.id.fname);
        EditText l = (EditText) findViewById(R.id.lname);
        EditText email = (EditText) findViewById(R.id.Email);
        EditText password = (EditText) findViewById(R.id.Pass);
        EditText confir = (EditText) findViewById(R.id.confirpass);
        TextView signin =(TextView) findViewById(R.id.login);
        ImageView web = (ImageView)findViewById(R.id.imageView2);
        ImageView facebook = (ImageView)findViewById(R.id.imageView);
        ImageView linkdin = (ImageView) findViewById(R.id.imageView3);
        DB = new DBHelper(this);

        Button register =(Button) findViewById(R.id.Res);


        web.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String url = "https://google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        facebook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String url = "https://www.facebook.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        linkdin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String url = "https://in.linkedin.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Registration.this, "Opening", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname = f.getText().toString();
                String lname = l.getText().toString();
                String user = email.getText().toString();
                String pass = password.getText().toString();


                if(user.equals("")||pass.equals(""))
                    Toast.makeText(Registration.this, "Please enter the details", Toast.LENGTH_SHORT).show();
                else
                {
                    if(pass.equals(confir.getText().toString()))
                    {
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(fname,lname,user,pass);
                            if(insert==true){
                                Toast.makeText(Registration.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Main_Page.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Registration.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Registration.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else
                    {
                        Toast.makeText(Registration.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });
    }
}
