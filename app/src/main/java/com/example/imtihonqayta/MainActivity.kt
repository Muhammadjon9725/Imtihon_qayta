package com.example.imtihonqayta

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.icu.number.IntegerWidth
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.imtihonqayta.databinding.ActivityHomeBinding
import com.example.imtihonqayta.model.MyObjeckt
import java.lang.invoke.ConstantCallSite

class MainActivity : AppCompatActivity() {
    lateinit var image: ImageView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityHomeBinding
    lateinit var textcolor: TextView
    lateinit var bitmap: Bitmap
    lateinit var color: String
    lateinit var consraint: ConstraintLayout
    lateinit var colorView: View

    @SuppressLint("ClickableViewAccessibility", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE)

        image = findViewById(R.id.imageView)
        textcolor = findViewById(R.id.textcolor)
        colorView = findViewById(R.id.colorView)
        consraint = findViewById(R.id.constraint3)

        image.isDrawingCacheEnabled = true
        image.buildDrawingCache(true)

        image.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_MOVE) {
                bitmap = image.drawingCache
                val pixel = bitmap.getPixel(event.x.toInt(), event.y.toInt())
                var r = Color.red(pixel)
                var g = Color.green(pixel)
                var b = Color.blue(pixel)
                color = "#${Integer.toHexString(pixel)}"
                textcolor.text = color
                colorView.setBackgroundColor(Color.rgb(r, g, b))
                sharedPreferences.edit().putString("color", color).apply()
                MyObjeckt.color = colorView.background
            }
            true
        }
    }
}