package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var history = ""
    var number1 = ""
    var number2 = ""

    var type : Int? = null

    val ADD : Int = 0
    val SUB : Int = 1
    val MUL : Int = 2
    val DIV : Int = 3
    val Reminder : Int = 4

    var d1 : Double = 0.0
    var d2 : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonADD = findViewById<Button>(R.id.buttonADD)
        val buttonSUB = findViewById<Button>(R.id.buttonSUB)
        val buttonMUL = findViewById<Button>(R.id.buttonMUL)
        val buttonDIV = findViewById<Button>(R.id.buttonDIV)
        val buttonReminder = findViewById<Button>(R.id.buttonReminder)
        val buttonRES = findViewById<Button>(R.id.buttonRES)
        val buttonPM = findViewById<Button>(R.id.buttonPM)
        val buttonC = findViewById<Button>(R.id.buttonC)
        val buttonDEL = findViewById<Button>(R.id.buttonDEL)
        val et_result = findViewById<EditText>(R.id.et_result)
        val et_show = findViewById<EditText>(R.id.et_show)

        buttonC.setOnClickListener{
            et_show.setText("")
            et_result.setText("")
            d1 = 0.toDouble()
            d2 = 0.toDouble()
        }

        buttonPM.setOnClickListener {
            Toast.makeText(this, "foo!", Toast.LENGTH_LONG).show()
        }

        buttonADD.setOnClickListener {
            number1 = et_result.text.toString()
            history = et_result.text.toString() + " + "
            et_show.setText(history)
            et_result.setText("")

            type = ADD
        }

        buttonSUB.setOnClickListener {
            number1 = et_result.text.toString()
            history = et_result.text.toString() + " - "
            et_show.setText(history)
            et_result.setText("")

            type = SUB
        }

        buttonMUL.setOnClickListener {
            number1 = et_result.text.toString()
            history = et_result.text.toString() + " * "
            et_show.setText(history)
            et_result.setText("")

            type = MUL
        }

        buttonDIV.setOnClickListener {
            number1 = et_result.text.toString()
            history = et_result.text.toString() + " / "
            et_show.setText(history)
            et_result.setText("")

            type = DIV
        }

        buttonReminder.setOnClickListener {
            number1 = et_result.text.toString()
            history = et_result.text.toString() + " % "
            et_show.setText(history)
            et_result.setText("")

            type = Reminder
        }

        buttonDEL.setOnClickListener {
            var del_num = et_result.text.toString()
            Toast.makeText(this, del_num, Toast.LENGTH_LONG).show()
            et_result.setText(del_num.substring(0, del_num.length -1))
        }

        buttonRES.setOnClickListener {
            var result = 0.0
            number2 = et_result.text.toString()
            history += et_result.text.toString()

            et_result.setText(history)

            d1 = number1.toDouble()
            d2 = number2.toDouble()

            if (type == ADD){
                result = d1 + d2
                et_result.setText("" + result)
            } else if (type == SUB){
                result = d1 - d2
                et_result.setText("" + result)
            } else if (type == MUL){
                result = d1 * d2
                et_result.setText("" + result)
            } else if (type == DIV){
                result = d1 / d2
                et_result.setText("" + result)
            } else if (type == Reminder){
                result = d1 % d2
                et_result.setText("" + result)
            }

            number1 = et_result.text.toString()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button0 -> et_result.setText(et_result.text.toString() + 0)
            R.id.button1 -> et_result.setText(et_result.text.toString() + 1)
            R.id.button2 -> et_result.setText(et_result.text.toString() + 2)
            R.id.button3 -> et_result.setText(et_result.text.toString() + 3)
            R.id.button4 -> et_result.setText(et_result.text.toString() + 4)
            R.id.button5 -> et_result.setText(et_result.text.toString() + 5)
            R.id.button6 -> et_result.setText(et_result.text.toString() + 6)
            R.id.button7 -> et_result.setText(et_result.text.toString() + 7)
            R.id.button8 -> et_result.setText(et_result.text.toString() + 8)
            R.id.button9 -> et_result.setText(et_result.text.toString() + 9)
            R.id.buttonDOT -> et_result.setText(et_result.text.toString() + ".")
        }
    }


}
