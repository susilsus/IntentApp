package com.example.myapplication2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(findViewById(R.id.toolbar))

        fab.setOnClickListener{viewlarge(R.drawable.ic_launcher_foreground)}
    }

    private fun viewlarge(iconid: Int) {

        var i=Intent(this,MainActivity::class.java)
        i.setAction(Intent.ACTION_VIEW)
        val uri=Uri.parse("hhtp://com.example.application2/view?id=$iconid")
        i.data=uri
        i.putExtra("id",iconid)
        startActivity(i)
    }
}