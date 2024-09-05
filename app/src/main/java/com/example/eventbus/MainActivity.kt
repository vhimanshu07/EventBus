package com.example.eventbus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {
    lateinit var outputText: AppCompatTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cartButton: Button = findViewById(R.id.moveToNext)
        outputText = findViewById(R.id.outputText)
        EventBus.getDefault().register(this)
        cartButton.setOnClickListener {
            val intent = Intent(this, ChildActivity::class.java)
            startActivity(intent)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onReceiveEvent(event: CustomEvent) {
        outputText.text = event.getMsg()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}