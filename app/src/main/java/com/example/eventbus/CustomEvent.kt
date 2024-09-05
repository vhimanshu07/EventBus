package com.example.eventbus

class CustomEvent {
    private lateinit var msg: String
    fun setMsg(msg: String) {
        this.msg = msg
    }

    fun getMsg(): String {
        return msg
    }


}
