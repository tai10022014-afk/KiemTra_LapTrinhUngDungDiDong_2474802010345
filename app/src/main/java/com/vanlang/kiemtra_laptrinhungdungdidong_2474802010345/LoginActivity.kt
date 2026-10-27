package com.vanlang.kiemtra_laptrinhungdungdidong_2474802010345  // giữ nguyên package của bạn

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ bằng findViewById (KHÔNG dùng ViewBinding)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            when {
                email.isEmpty() && password.isEmpty() -> {
                    tvStatus.setTextColor(0xFFD32F2F.toInt())
                    tvStatus.text = "Lỗi: Vui lòng nhập Email và Mật khẩu!"
                }
                email.isEmpty() -> {
                    tvStatus.setTextColor(0xFFD32F2F.toInt())
                    tvStatus.text = "Lỗi: Email không được để trống!"
                }
                password.isEmpty() -> {
                    tvStatus.setTextColor(0xFFD32F2F.toInt())
                    tvStatus.text = "Lỗi: Mật khẩu không được để trống!"
                }
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvStatus.setTextColor(0xFFD32F2F.toInt())
                    tvStatus.text = "Lỗi: Email sai định dạng!"
                }
                password.length < 6 -> {
                    tvStatus.setTextColor(0xFFD32F2F.toInt())
                    tvStatus.text = "Lỗi: Mật khẩu phải có ít nhất 6 ký tự!"
                }
                else -> {
                    tvStatus.setTextColor(0xFF2E7D32.toInt())
                    tvStatus.text = "Xác thực thành công!"
                }
            }
        }
    }
}