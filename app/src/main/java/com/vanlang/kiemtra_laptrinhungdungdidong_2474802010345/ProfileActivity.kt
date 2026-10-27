package com.vanlang.kiemtra_laptrinhungdungdidong_2474802010345

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val lvSubjects = findViewById<ListView>(R.id.lvSubjects)

        // Nhận dữ liệu email từ Intent
        val email = intent.getStringExtra("EXTRA_EMAIL")
        tvEmail.text = "Email: $email"

        btnLogout.setOnClickListener { finish() }

        // 3.3. Dữ liệu mẫu (>= 5 phần tử)
        val subjects = listOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android",
            "ListView và Adapter"
        )

        // 3.4. Khởi tạo ArrayAdapter với layout có sẵn của Android
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            subjects
        )
        lvSubjects.adapter = adapter

        // 3.5. Bắt sự kiện click item trên ListView hiển thị Toast
        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, subjects[position], Toast.LENGTH_SHORT).show()
        }
    }
}