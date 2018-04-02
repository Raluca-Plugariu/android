package com.example.ralucaplugariu.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by raluca.plugariu on 22.03.2018.
 */

public class Register extends AppCompatActivity  {

    private DataBaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        Button submit = (Button) findViewById(R.id.submit);
        user = new User();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper = new DataBaseHelper(Register.this);
                if (!databaseHelper.checkUser(username.getText().toString().trim(),password.getText().toString().trim())) {

                    user.setUsername(username.getText().toString().trim());
                    user.setPassword(password.getText().toString().trim());

                    databaseHelper.addUser(user);

                    // Snack Bar to show success message that record saved successfully
                    Toast.makeText(getApplicationContext(),"Succes register",Toast.LENGTH_LONG).show();
                    emptyInputEditText();


                } else {
                    // Snack Bar to show error message that record already exists
                    Toast.makeText(getApplicationContext(),"User already exists",Toast.LENGTH_LONG).show();
                }
            }

            private void emptyInputEditText() {
                username.setText(null);
                password.setText(null);

            }
        });



    }



}
