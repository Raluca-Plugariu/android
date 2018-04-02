package com.example.ralucaplugariu.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by raluca.plugariu on 15.03.2018.
 */

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        Intent intent = getIntent();
        final String value = intent.getStringExtra("key");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Hello "+value);
        alertDialogBuilder.setMessage("Do you want to log out?");
        alertDialogBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent myIntent = new Intent(getBaseContext(), MapsActivity.class);
                        Home.this.startActivity(myIntent);
                    }
                });

        alertDialogBuilder.setNegativeButton("cancel",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        Button btn = (Button) findViewById(R.id.youtube);
        Button pref = (Button) findViewById(R.id.pref);
        Button sensor = (Button) findViewById(R.id.sensor);
        Button location = (Button) findViewById(R.id.location);

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getBaseContext(),LocationCheckerActivity.class);
                startActivity(intent2);


            }
        });

        sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),Sensors.class);

                startActivity(intent);

            }
        });

        pref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), ShowPreferences.class);
                myIntent.putExtra("username",value);
                startActivity(myIntent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.youtube.com/watch?v=4X3qkXZ7wXs";
                      Intent i = new Intent(Intent.ACTION_VIEW);
                       i.setData(Uri.parse(url));
                       startActivity(i);
            }
        });
    }
}
