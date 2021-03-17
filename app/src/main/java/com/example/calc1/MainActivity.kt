package com.example.calc1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one.setOnClickListener { pokaz("1", true) }
        two.setOnClickListener { pokaz("2", true) }
        tree.setOnClickListener { pokaz("3", true) }
        four.setOnClickListener { pokaz("4", true) }
        five.setOnClickListener { pokaz("5", true) }
        six.setOnClickListener { pokaz("6", true) }
        seven.setOnClickListener { pokaz("7", true) }
        eight.setOnClickListener { pokaz("8", true) }
        nine.setOnClickListener { pokaz("9", true) }
        zero.setOnClickListener { pokaz("0", true) }

        dot.setOnClickListener { pokaz(".", false) }
        plus.setOnClickListener { pokaz("+", false) }
        minus.setOnClickListener { pokaz("-", false) }
        equally.setOnClickListener { pokaz("=", false) }
        multiply.setOnClickListener { pokaz("*", false) }
        points.setOnClickListener { pokaz("/", false) }
        open.setOnClickListener { pokaz(")", false) }
        open2.setOnClickListener { pokaz("(", false) }

        //стирание
        erase.setOnClickListener {
            val stroka = Expression.text.toString()
            if (stroka.isNotEmpty()) {
                Expression.text = stroka.substring(0, stroka.length - 1)
            }
            Result.text = ""
        }

        //очистка полная
        AS.setOnClickListener {
            Result.text = ""
            Expression.text = ""
        }

        //вычисление
        equally.setOnClickListener {
            try {
             val expression = ExpressionBuilder(Expression.text.toString()).build()
             val result = expression.evaluate()
             val longResult = result.toLong()
             if(result == longResult.toDouble())
                Result.text = longResult.toString()
             else
                 Result.text = result.toString()
            } catch (e: Exception)
            {
                Log.d("на ноль делить нельзя!","msg"+e.message)
            }
        }




    }

    fun pokaz(stroka: String, ochistka: Boolean) {

        if (Result.text.isNotEmpty()) {
            Expression.text = ""
        }
        if (ochistka) {
            Result.text = ""
            Expression.append(stroka)
        } else {
            Expression.append(Result.text)
            Expression.append(stroka)
            Result.text = ""
        }

    }
}