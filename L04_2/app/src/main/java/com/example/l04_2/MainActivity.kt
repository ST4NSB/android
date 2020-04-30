package com.example.l04_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val requestCode = 10;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        val bundle = Bundle();
        val textBox: EditText = findViewById(R.id.txtBox)
        bundle.putString("kotlin_key", textBox.text.toString())
        intent.putExtras(bundle)
        startActivityForResult(intent, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == requestCode) {
            if (resultCode == Activity.RESULT_OK) {
                val res = data!!.data.toString()
                val newTextBox: EditText = findViewById(R.id.txtBox)
                newTextBox.setText(res);
                Toast.makeText(this, res, Toast.LENGTH_SHORT).show()
            }
        }
    }

}
