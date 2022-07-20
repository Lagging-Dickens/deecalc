package com.safari.deecalc

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.service.autofill.OnClickAction
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var Btn_Add:Button
    lateinit var Btn_Sub:Button
    lateinit var Btn_Mult:Button
    lateinit var Btn_Div:Button
    lateinit var Edt_Fnam:EditText
    lateinit var Edt_Snam:EditText
    lateinit var Txt_Ans:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        Btn_Add=findViewById(R.id.Btn_add)
        Btn_Div=findViewById(R.id.Btn_divide)
        Btn_Mult=findViewById(R.id.Btn_multiply)
        Btn_Sub=findViewById(R.id.Btn_minus)
        Edt_Fnam=findViewById(R.id.firstnumber)
        Edt_Snam=findViewById(R.id.secondnumber)
        Txt_Ans=findViewById(R.id.ans)
        //addition button
        Btn_Add.setOnClickListener {
            var fnamba=Edt_Fnam.text.toString()
            var snam=Edt_Snam.text.toString()

            if (fnamba.isEmpty() && snam.isEmpty()){
                Txt_Ans.text="Please fill in both numbers."
            }else{
                var answer=fnamba.toDouble()+snam.toDouble()
                Txt_Ans.text=answer.toString()
            }
        }
        //subtract button
        Btn_Sub.setOnClickListener {
            var fnamba=Edt_Fnam.text.toString()
            var snam=Edt_Snam.text.toString()

            if (fnamba.isEmpty() && snam.isEmpty()){
                Txt_Ans.text="Please fill in both numbers."
            }else{
                var answer=fnamba.toDouble()-snam.toDouble()
                Txt_Ans.text=answer.toString()
            }
        }
        //multiply button
        Btn_Mult.setOnClickListener {
            var fnamba=Edt_Fnam.text.toString()
            var snam=Edt_Snam.text.toString()

            if (fnamba.isEmpty() && snam.isEmpty()){
                Txt_Ans.text="Please fill in both numbers."
            }else{
                var answer=fnamba.toDouble()*snam.toDouble()
                Txt_Ans.text=answer.toString()
            }
        }
        //divide button
        Btn_Div.setOnClickListener {
            var fnamba=Edt_Fnam.text.toString()
            var snam=Edt_Snam.text.toString()

            if (fnamba.isEmpty() && snam.isEmpty()){
                Txt_Ans.text="Please fill in both numbers."
            }else{
                var answer=fnamba.toDouble()/snam.toDouble()
                Txt_Ans.text=answer.toString()
            }
        }
    }
}