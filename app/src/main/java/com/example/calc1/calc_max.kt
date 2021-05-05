package com.example.calc1

import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.calc_max_xml.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.Result

class calc_max : AppCompatActivity() {

    private var soundPool:  SoundPool?= null
    private var soundId1 : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calc_max_xml)

        findViewById<ImageView>(R.id.AS).setOnClickListener {
            playSound(it)
            
        }

        soundPool = SoundPool(30, AudioManager.STREAM_MUSIC, 0)
        soundId1 = soundPool!!.load(baseContext, R.raw.mag_two, 1)



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
            }
            catch (e: Exception)
            {
                Log.d("error","код"+e.message)
            }
        }




    }


    fun playSound(view: View)
    {
        soundPool?.play(soundId1, 1F, 1F, 0, 0, 1F)
        Toast.makeText(this, "Playing sound. . . .", Toast.LENGTH_SHORT).show()
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