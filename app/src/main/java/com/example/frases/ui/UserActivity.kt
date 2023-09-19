package com.example.frases.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.frases.databinding.ActivityUserBinding
import com.example.frases.MotivationConstants
import com.example.frases.SecurityPreferences


class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(this)

        verifyUserName()

    }


    override fun onClick(view: View?) {
        return handleSave()
    }
    private fun handleSave(){
        val name = binding.editName.text.toString()
        if (name != ""){
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))

        } else {
            Toast.makeText(
                this,
                "Digite seu nome",
                Toast.LENGTH_SHORT ).show()
        }
    }


    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}