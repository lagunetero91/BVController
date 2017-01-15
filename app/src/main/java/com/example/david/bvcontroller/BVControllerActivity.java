package com.example.david.bvcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class BVControllerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bvcontroller);
        final Button buttonUp = (Button) findViewById(R.id.buttonUP);
        final Button buttonBack = (Button) findViewById(R.id.buttonBack);
        final Button buttonRight = (Button) findViewById(R.id.buttonRight);
        final Button buttonLeft = (Button) findViewById(R.id.buttonLeft);

        buttonUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                sendUpCommand();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                sendBackCommand();
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                sendRightCommand();
            }
        });

        buttonLeft.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                sendLeftCommand();
            }
        });

    }
}


