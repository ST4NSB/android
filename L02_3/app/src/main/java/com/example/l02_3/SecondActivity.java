package com.example.l02_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    int request_Code = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String res = getIntent().getStringExtra("key");
        EditText actText = (EditText)findViewById(R.id.txtUsername);
        actText.setText(res);
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        Intent data = new Intent();
        EditText txt_username = (EditText)findViewById(R.id.txtUsername);
        data.setData(Uri.parse(txt_username.getText().toString()));
        setResult(RESULT_OK, data);
        finish();
    }
}
