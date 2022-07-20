package com.safari.deecalc

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    lateinit var Btn_sms:Button
    lateinit var Btn_call:Button
    lateinit var Btn_email:Button
    lateinit var Btn_share:Button
    lateinit var Btn_stk:Button
    lateinit var Btn_camera:Button
    lateinit var Btn_dial:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        Btn_sms=findViewById(R.id.Btn_SMS)
        Btn_call=findViewById(R.id.Btn_Call)
        Btn_dial=findViewById(R.id.Btn_Dial)
        Btn_email=findViewById(R.id.Btn_email)
        Btn_share=findViewById(R.id.Btn_share)
        Btn_stk=findViewById(R.id.Btn_STK)
        Btn_camera=findViewById(R.id.Btn_Camera)


        Btn_sms.setOnClickListener {
            val uri = Uri.parse("smsto:0714603210")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("Hello", "Who are you...?")

            startActivity(intent)
        }
        Btn_call.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254714603210"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }
        Btn_dial.setOnClickListener {
            val phone = "+254714603210"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)
        }

        Btn_email.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "beastover04@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
        Btn_share.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)
        }
        Btn_stk.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }
        }
        Btn_camera.setOnClickListener {

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivity(takePictureIntent)
        }
    }
}