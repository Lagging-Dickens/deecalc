package com.safari.deecalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var Btn_Calc:Button ?=null
    var Btn_Intent:Button ?=null
    var Btn_Web:Button ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Btn_Calc=findViewById(R.id.Btn_Calc)
        Btn_Intent=findViewById(R.id.Btn_Int)
        Btn_Web=findViewById(R.id.Btn_Web)

        Btn_Calc!!.setOnClickListener{
            val intent=Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }
        Btn_Intent!!.setOnClickListener {
            val intent=Intent(this,IntentActivity::class.java)
            startActivity(intent)
        }
        Btn_Web!!.setOnClickListener{
            val intent=Intent(this,WebActivity::class.java)
            startActivity(intent)
        }
    }
}