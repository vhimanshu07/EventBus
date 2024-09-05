package com.example.eventbus

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import org.greenrobot.eventbus.EventBus

class ChildActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)
        val inputText: EditText = findViewById(R.id.inputText)
        val eventButton: AppCompatButton = findViewById(R.id.eventButton)
        eventButton.setOnClickListener {
            val event = CustomEvent()
            event.setMsg(inputText.text.toString())
            EventBus.getDefault().post(event)
        }
        val navigationButton: AppCompatTextView = findViewById(R.id.navigation)
        navigationButton.setOnClickListener {
            finish()
        }
    }
}