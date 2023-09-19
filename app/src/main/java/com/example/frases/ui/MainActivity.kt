package com.example.frases.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.frases.R
import com.example.frases.databinding.ActivityMainBinding
import com.example.frases.MainViewModel
import com.example.frases.MotivationConstants
import com.example.frases.SecurityPreferences
import com.example.frases.data.Mock

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var categoryId = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        userName()
        filterImageClicked(R.id.ic_all)
        nextPhrase()

        binding.Button.setOnClickListener(this)
        binding.icAll.setOnClickListener(this)
        binding.icHappy.setOnClickListener(this)
        binding.icSun.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if (view != null) {
            if(view.id == R.id.Button){
                nextPhrase()
            } else if (view.id in listOf(R.id.ic_all, R.id.ic_happy, R.id.ic_sun)){
                filterImageClicked(view.id)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun userName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        viewModel.person().observe(this) {
            binding.textUserName.text = it + name
        }
    }

    private fun nextPhrase(){
        val phrase = Mock().getPhrase(categoryId)

        binding.textMotivation.text = phrase
    }

    private fun filterImageClicked(id: Int) {
        binding.icAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.icHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.icSun.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when(id){
            R.id.ic_all -> {
                binding.icAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.ic_happy -> {
                binding.icHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
            R.id.ic_sun -> {
                binding.icSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUN
            }
        }
    }
}