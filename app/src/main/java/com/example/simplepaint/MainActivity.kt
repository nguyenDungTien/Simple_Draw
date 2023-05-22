package com.example.simplepaint

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplepaint.PaintView.Companion.colorList
import com.example.simplepaint.PaintView.Companion.currentBrush
import com.example.simplepaint.PaintView.Companion.pathList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //tạo đối tượng đồng hành để khia báo biến toàn cục cho phép biến được  sử dụng taonf bộ trong các class trong ứng dụng
    companion object{
        //path lấy từ android.graphics.Path
        var path = Path()
        // Paint() lấy từ import android.graphics.Paint
        var paintBrush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ẩn actionsbar
        supportActionBar?.hide()
        redColor.setOnClickListener {
            paintBrush.color=Color.RED
            currentColor(paintBrush.color)

        }
        blackColor.setOnClickListener {
            paintBrush.color=Color.BLACK
            currentColor(paintBrush.color)

        }
        blueColer.setOnClickListener {
            paintBrush.color=Color.BLUE
            currentColor(paintBrush.color)

        }
        whiteColor.setOnClickListener {
            pathList.clear()
            colorList.clear()
            path.reset()
        }
    }
    private fun currentColor(color:Int){
        currentBrush=color
        path = Path()
    }
}