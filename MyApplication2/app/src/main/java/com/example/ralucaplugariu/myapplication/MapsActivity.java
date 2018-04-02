package com.example.ralucaplugariu.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MapsActivity extends AppCompatActivity {

    private DataBaseHelper databaseHelper;
    private User user;

    private static final String TAG = MapsActivity.class.getSimpleName();

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "On Start called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "On Resume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "On Pause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "On Stop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "On Destroy called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText text = (EditText) findViewById(R.id.text);
        TextView txtView = (TextView) findViewById(R.id.result);
        Button button = (Button) findViewById(R.id.accept);
        String buttonString = button.getText().toString();
        String textString = text.getText().toString();
        outState.putString("text", "Login as " + textString + " ?");
        outState.putString("button", buttonString);
        outState.putInt("visibilitybtn",button.getVisibility());
        outState.putInt("vizibilitytxt",txtView.getVisibility());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String myString = savedInstanceState.getString("text");
        String buttonText = savedInstanceState.getString("button");
        int visibility = savedInstanceState.getInt("visibilitybtn");
        int visibTxt = savedInstanceState.getInt("vizibilitytxt");
        TextView text =(TextView) findViewById(R.id.result);
        Button acceptButton = (Button)findViewById(R.id.accept);
        acceptButton.setText(buttonText);
        acceptButton.setVisibility(visibility);
        text.append(myString);
        text.setVisibility(visibTxt);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.feeds:
                Toast.makeText(getApplicationContext(),"Feeds Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.friends:
                Toast.makeText(getApplicationContext(),"Friends Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.about:
                Toast.makeText(getApplicationContext(),"About Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Button clickButton = (Button) findViewById(R.id.button);
        Button register = (Button) findViewById(R.id.register);
        Button acceptBtn = (Button)findViewById(R.id.accept);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Register.class);
                startActivity(myIntent);
            }
        });
        clickButton.setOnClickListener( new View.OnClickListener() {

            public void onClick(View v) {
                final EditText username = (EditText)findViewById(R.id.text);
                final EditText password = (EditText)findViewById(R.id.password);

                databaseHelper = new DataBaseHelper(MapsActivity.this);

                if (databaseHelper.checkUser(username.getText().toString().trim()
                        , password.getText().toString().trim())) {


                    final TextView textView = (TextView) findViewById(R.id.result);
                    textView.setVisibility(View.VISIBLE);
                    Button acceptButton = (Button) findViewById(R.id.accept);
                    textView.setText("Login as "+username.getText()+" ?");
                    acceptButton.setVisibility(View.VISIBLE);

                } else {

                    Toast.makeText(getApplicationContext(),"Wrong credentials",Toast.LENGTH_LONG).show();
                }

            }
        });
        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Home.class);
                EditText inputText = (EditText)findViewById(R.id.text);
                myIntent.putExtra("key", inputText.getText().toString()); //Optional parameters
                MapsActivity.this.startActivity(myIntent);
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

    }



}
