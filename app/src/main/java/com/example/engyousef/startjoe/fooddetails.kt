package com.example.engyousef.startjoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fooddetails.*

class fooddetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fooddetails)
        val bundle = intent.extras

        imageView.setImageResource(bundle.getInt("image"))
        tvName.text=bundle.getString("name")
        tvDetails.text=bundle.getString("des")
    }
}
