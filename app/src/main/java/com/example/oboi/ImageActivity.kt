package com.example.oboi

import android.app.WallpaperManager
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.time.chrono.HijrahEra

class ImageActivity : AppCompatActivity() {
    var pref : SharedPreferences? = null
    var counter = 0;
    var number : String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        val arg = getIntent().getExtras()
        val img_ind = arg?.get("image").toString().toInt()
        val image = findViewById<ImageView>(R.id.imageView)
        number = arg?.get("number").toString()
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        counter = pref?.getInt(number, 0)!!
        image.setImageResource(img_ind);
        val button1 = findViewById<FloatingActionButton>(R.id.button1);
        val Heart = findViewById<ImageButton>(R.id.imageButton)
        if (counter == 0) {
            Heart.setImageResource(R.drawable.heart)
        } else {
            Heart.setImageResource(R.drawable.red_heart)
        }
        button1.setOnClickListener {
            ShowDialog(img_ind)
        }
        Heart.setOnClickListener {
            counter++
            counter %= 2
            if (counter == 0) {
                Heart.setImageResource(R.drawable.heart)
            } else {
                Heart.setImageResource(R.drawable.red_heart)
            }
        }
    }
    fun ShowDialog(img_ind : Int) {
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.bottom_sheet)
        val WallpaperButton = dialog.findViewById<Button>(R.id.WallpaperButton)
        val HomeScreenButton = dialog.findViewById<Button>(R.id.HomeScreenButton)
        WallpaperButton?.setOnClickListener {
            val bitmap : Bitmap = BitmapFactory.decodeResource(resources, img_ind)
            val wallpaperManager = WallpaperManager.getInstance(baseContext)
            wallpaperManager.setBitmap(bitmap)

        }
        HomeScreenButton?.setOnClickListener {
            val bitmap : Bitmap = BitmapFactory.decodeResource(resources, img_ind)
            val wallpaperManager = WallpaperManager.getInstance(baseContext)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //print("KUKU EPTA NAXER")
                wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK)
                //HomeScreenButton.setText("KUKU EPTA")
            }
        }
        dialog.show()
    }

    fun saveData(res : Int) {
        val editor = pref?.edit()
        editor?.putInt(number, res)
        editor?.apply()
    }
    override fun onDestroy() {
        super.onDestroy()
        saveData(counter)
    }
}