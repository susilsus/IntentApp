package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication2.util.StringUtility
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var ads= StringUtility()
        println(ads.asstring())
        Toast.makeText(this, "asd", Toast.LENGTH_SHORT).show()
        Log.i("checkintent", "onCreate: ${intent.action}")
        //Thi scode is used to activate by othe application intent
        if(intent.action == Intent.ACTION_SEND)
        { val res= intent?.getStringExtra(Intent.EXTRA_TEXT)
            val iconid=resources.getIdentifier(res?.trim(),"drawable",packageName)
            imageView.setImageResource(iconid)
            Toast.makeText(this, "hi from another app", Toast.LENGTH_SHORT).show()
        }
        // using intent between two activities

        //1.By using Uri as intent.data
        val lastpart=intent.data?.lastPathSegment
        if(lastpart!!.equals("view"))
        {
            val iconid=intent.data?.getQueryParameter("id")
            Log.i("intentrecieve", "onCreate: $iconid")
            imageView.setImageResource(iconid!!.toInt())

        }


//        This is used to intent data using intent.extra
        val iconid=intent.extras!!.getInt("id")
        Log.i("intentrecieve", "onCreate: $iconid")
        imageView.setImageResource(iconid)
    }

}