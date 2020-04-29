package com.example.l02_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int request_Code = 1;
    boolean start = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        Intent i = new Intent(this, SecondActivity.class);
        Bundle bundle = new Bundle();
        EditText actText = (EditText)findViewById(R.id.txtUsername);
        bundle.putString("key", actText.getText().toString());
        i.putExtras(bundle);
        startActivityForResult(i, request_Code);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == request_Code) {
            if (resultCode == RESULT_OK) {
                String res = data.getData().toString();
                EditText actText = (EditText)findViewById(R.id.txtUsername);
                actText.setText(res);
                Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
            }
        }
    }

}
