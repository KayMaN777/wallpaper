package com.example.oboi

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

//const val KOL : Int = 8

class FavouriteActivity : AppCompatActivity() {
    var pref : SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        val ImageList = mutableListOf<Pair<ImageView, Pair<Pair<Int, Int>, String>>>();
        val image1 = findViewById<ImageView>(R.id.imageView1);
        val image2 = findViewById<ImageView>(R.id.imageView2);
        val image3 = findViewById<ImageView>(R.id.imageView3);
        val image4 = findViewById<ImageView>(R.id.imageView4);
        val image5 = findViewById<ImageView>(R.id.imageView5);
        val image6 = findViewById<ImageView>(R.id.imageView6);
        val image7 = findViewById<ImageView>(R.id.imageView7);
        val image8 = findViewById<ImageView>(R.id.imageView8);
        ImageList.add(Pair(image1, Pair(Pair(R.drawable.image1,R.drawable.image1_co), "image1")));
        ImageList.add(Pair(image2, Pair(Pair(R.drawable.image2,R.drawable.image2_co), "image2")));
        ImageList.add(Pair(image3, Pair(Pair(R.drawable.image3,R.drawable.image3_co), "image3")));
        ImageList.add(Pair(image4, Pair(Pair(R.drawable.image4,R.drawable.image4_co), "image4")));
        ImageList.add(Pair(image5, Pair(Pair(R.drawable.image5,R.drawable.image5_co), "image5")));
        ImageList.add(Pair(image6, Pair(Pair(R.drawable.image6,R.drawable.image6_co), "image6")));
        ImageList.add(Pair(image7, Pair(Pair(R.drawable.image7,R.drawable.image7_co), "image7")));
        ImageList.add(Pair(image8, Pair(Pair(R.drawable.image8,R.drawable.image8_co), "image8")));
        val IndexList = mutableListOf<ImageView>()
        IndexList.add(image1)
        IndexList.add(image2)
        IndexList.add(image3)
        IndexList.add(image4)
        IndexList.add(image5)
        IndexList.add(image6)
        IndexList.add(image7)
        IndexList.add(image8)
        var cnt = 0;
        for (image in ImageList) {
            var opa = pref?.getInt(image.second.second, 0)!!
            if (opa == 1) {
                IndexList[cnt].setImageResource(image.second.first.second)
                IndexList[cnt].setOnClickListener {
                    val intent = Intent(this@FavouriteActivity, ImageActivity::class.java)
                    intent.putExtra("image", image.second.first.first);
                    intent.putExtra("number", image.second.second)
                    startActivity(intent);
                }
                cnt++
            }
        }
    }
}