package com.example.oboi

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView

const val KOL = 8

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ImageList = mutableListOf<Pair<ImageView, Pair<Int, String>>>();
        val image1 = findViewById<ImageView>(R.id.imageView1);
        val image2 = findViewById<ImageView>(R.id.imageView2);
        val image3 = findViewById<ImageView>(R.id.imageView3);
        val image4 = findViewById<ImageView>(R.id.imageView4);
        val image5 = findViewById<ImageView>(R.id.imageView5);
        val image6 = findViewById<ImageView>(R.id.imageView6);
        val image7 = findViewById<ImageView>(R.id.imageView7);
        val image8 = findViewById<ImageView>(R.id.imageView8);
        ImageList.add(Pair(image1, Pair(R.drawable.image1, "image1")));
        ImageList.add(Pair(image2, Pair(R.drawable.image2, "image2")));
        ImageList.add(Pair(image3, Pair(R.drawable.image3, "image3")));
        ImageList.add(Pair(image4, Pair(R.drawable.image4, "image4")));
        ImageList.add(Pair(image5, Pair(R.drawable.image5, "image5")));
        ImageList.add(Pair(image6, Pair(R.drawable.image6, "image6")));
        ImageList.add(Pair(image7, Pair(R.drawable.image7, "image7")));
        ImageList.add(Pair(image8, Pair(R.drawable.image8, "image8")));
        for (image in ImageList) {
            image.first.setOnClickListener{
                val intent = Intent(this@MainActivity, ImageActivity::class.java)
                intent.putExtra("image", image.second.first);
                intent.putExtra("number", image.second.second)
                startActivity(intent);
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu):Boolean {
        val inflater = getMenuInflater()
        inflater.inflate(R.menu.mainmenu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        val id = item.getItemId()
        if (id == R.id.action_plus)
        {
            val intent = Intent(this@MainActivity, FavouriteActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}