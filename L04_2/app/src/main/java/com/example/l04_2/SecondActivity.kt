package com.example.l04_2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {

    private val requestCode = 10;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val res = intent.getStringExtra("kotlin_key")
        val textBox = findViewById<EditText>(R.id.txtBox_second)
        textBox.setText(res)
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show()
    }

    fun onClick(view: View) {
        val data = Intent()
        val textBox: EditText = findViewById(R.id.txtBox_second)
        data!!.data = Uri.parse(textBox.text.toString())
        setResult(Activity.RESULT_OK, data)
        finish()
    }
}
