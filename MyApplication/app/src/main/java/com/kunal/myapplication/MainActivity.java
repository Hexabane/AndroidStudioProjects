package com.kunal.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Bt_Hello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bt_Hello=findViewById(R.id.hello_button);


        Bt_Hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Welcome to OPSC", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, NewWindow.class);
                startActivity(i);

                //STEPHAN WAS HEHRE



            }

        });
    }
}