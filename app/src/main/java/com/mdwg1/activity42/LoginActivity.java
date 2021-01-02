package com.mdwg1.activity42;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edit1 , edit2 ;
    Button login ;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this) ;
        edit1 = (EditText) findViewById(R.id.edit) ;
        edit2 = (EditText) findViewById(R.id.editt) ;
        login = (Button) findViewById(R.id.login) ;

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edit1.getText().toString() ;
                String password = edit2.getText().toString() ;
                Boolean chkemailpass = db.emailpassword(email,password) ;
                if(chkemailpass==true)
                    Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT).show();






            }
        });

    }
}