package com.example.l02_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String tag = "Lifecycle Step";
    private void setText(String text) {
        TextView tv = (TextView)findViewById(R.id.mainTxtBox);
        tv.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setText("onCreate");
    }

    public void onStart()
    {
        super.onStart();
        setText("onStart");
    }

    public void onRestart()
    {
        super.onRestart();
        setText("onRestart");
    }
    public void onResume()
    {
        super.onResume();
        setText("onResume");
    }
    public void onPause()
    {
        super.onPause();
        setText("onPause");
    }
    public void onStop()
    {
        super.onStop();
        setText("onStop");
    }
    public void onDestroy()
    {
        super.onDestroy();
        setText("onDestroy");
    }
}
