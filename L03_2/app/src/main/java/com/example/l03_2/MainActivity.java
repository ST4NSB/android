package com.example.l03_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int BOUNDED = 1, UNBOUNDED = 0;
    private int status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = UNBOUNDED;
    }

    public void onClick(View view) {
        if(status == UNBOUNDED) {
            status = BOUNDED;
            Button et = (Button) findViewById(R.id.serviceBttn);
            et.setText("STATUS: CONNECTED");

            Intent intent = new Intent(this, ToastService.class);
            startService(intent);
        }
        else {
            status = UNBOUNDED;
            Button et = (Button) findViewById(R.id.serviceBttn);
            et.setText("STATUS: DISCONNECTED");

            Intent intent = new Intent(this, ToastService.class);
            stopService(intent);
        }
    }

}
