package com.example.instagram

import android.graphics.drawable.Icon
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.instagram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var fragmentM = supportFragmentManager
    var fragment1 = Home()
    var fragment2 = Profile()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            img.setOnClickListener {
                if (binding.id.text == "0"){
                    fragmentM.beginTransaction().remove(fragment2).commit()
                    binding.id.text = "1"
                }
                fragmentM.beginTransaction().add(R.id.con, fragment1).addToBackStack("a").commit()
                img.setImageResource(R.drawable.home)
                imgOval.setImageResource(0)
            }
            img4.setOnClickListener {
                if (binding.id.text.toString() == "1"){
                    fragmentM.beginTransaction().remove(fragment1).commit()
                    binding.id.text = "0"
                }
                fragmentM.beginTransaction().remove(fragment1).commit()
                fragmentM.beginTransaction().replace(R.id.con, fragment2).addToBackStack("a").commit()
                imgOval.setImageResource(R.drawable.profileoval)
                img.setImageResource(R.drawable.img)
            }
        }
    }
}