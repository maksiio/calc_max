package com.example.calc1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one.setOnClickListener {pokaz("1",true)}
        two.setOnClickListener {pokaz("2",true)}
        tree.setOnClickListener {pokaz("3",true)}
        four.setOnClickListener {pokaz("4",true)}
        five.setOnClickListener {pokaz("5",true)}
        six.setOnClickListener {pokaz("6",true)}
        seven.setOnClickListener {pokaz("7",true)}
        eight.setOnClickListener {pokaz("8",true)}
        nine.setOnClickListener {pokaz("9",true)}
        dot.setOnClickListener {pokaz(".",true)}

        plus.setOnClickListener {pokaz("+",true)}
        minus.setOnClickListener {pokaz("-",true)}

    }
    fun pokaz(stroka: String, ochistka: Boolean) {

        if (max_Result.text.isNotEmpty()) {
            max_Expression.text = ""
        }
        if (ochistka) {
            max_Result.text = ""
            max_Expression.append(stroka)
        } else {
            max_Expression.append(max_Result.text)
            max_Expression.append(stroka)
            max_Result.text = ""
        }

    }
}