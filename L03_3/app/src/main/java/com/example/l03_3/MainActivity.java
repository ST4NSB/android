package com.example.l03_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private MathService mathService = null;
    final int BOUNDED = 1, UNBOUNDED = 0;
    private int status;

    HashSet A, B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            mathService = ((MathService.SomeBinder)service).getService();
            status = BOUNDED;
        }
        @Override
        public void onServiceDisconnected(ComponentName className) {
            mathService = null;
            status = UNBOUNDED;
        }
    };


    public void onClickCon(View view) {
        Intent intent = new Intent(this, MathService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        TextView statusTv = (TextView)findViewById(R.id.statusTv);
        statusTv.setText("status: Connected");
    }

    public void onClickDis(View view) {
        if (status == BOUNDED) {
            unbindService(serviceConnection);
            TextView statusTv = (TextView)findViewById(R.id.statusTv);
            statusTv.setText("status: Disconnected");
        }
    }

    private void getValForSet() {
        A = new HashSet();
        B = new HashSet();

        EditText aText = (EditText)findViewById(R.id.SetA);
        String[] strA = aText.getText().toString().split(",");
        for(String str : strA)
            A.add(str);

        EditText bText = (EditText)findViewById(R.id.SetB);
        String[] strB = bText.getText().toString().split(",");
        for(String str : strB)
            B.add(str);
    }


    public void onClickUnion(View view) {
        getValForSet();
        HashSet res = mathService.setUnion(A, B);
        TextView result = (TextView)findViewById(R.id.result);
        result.setText("Union Result: " + res.toString());
    }

    public void onClickIntersection(View view) {
        getValForSet();
        HashSet res = mathService.setIntersection(A, B);
        TextView result = (TextView)findViewById(R.id.result);
        result.setText("Intersection Result: " + res.toString());
    }

    public void onClickDifference(View view) {
        getValForSet();
        HashSet res = mathService.setDifference(A, B);
        TextView result = (TextView)findViewById(R.id.result);
        result.setText("Difference Result: " + res.toString());
    }

    public void onClickSymDifference(View view) {
        getValForSet();
        HashSet res = mathService.setSymmetricDifference(A, B);
        TextView result = (TextView)findViewById(R.id.result);
        result.setText("Symmetric Difference Result: " + res.toString());
    }
}


