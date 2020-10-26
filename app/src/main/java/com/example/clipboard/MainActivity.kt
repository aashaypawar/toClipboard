package com.example.clipboard

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val copyTxt = findViewById<EditText>(R.id.txtCopy)
        val copyBtn = findViewById<Button>(R.id.btnCopy)
        val clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        var clipData: ClipData

        copyBtn.setOnClickListener {
            val txtCopy = copyTxt!!.text.toString()
            clipData = ClipData.newPlainText("text", txtCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(applicationContext, "Copied to Clipboard", Toast.LENGTH_SHORT).show()
        }
    }
}