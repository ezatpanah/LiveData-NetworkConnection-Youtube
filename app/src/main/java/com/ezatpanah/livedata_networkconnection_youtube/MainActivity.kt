package com.ezatpanah.livedata_networkconnection_youtube

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ezatpanah.livedata_networkconnection_youtube.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val checkConnection by lazy { CheckConnection(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            checkConnection.observe(this@MainActivity) {
                if (it) {
                    imgStatus.setImageResource(R.drawable.ic_baseline_wifi_24)
                    imgStatus.setColorFilter(ContextCompat.getColor(this@MainActivity,R.color.connect),PorterDuff.Mode.MULTIPLY)
                    tvStatus.text="Connected ! :)"
                    tvStatus.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.connect))

                } else {
                    imgStatus.setImageResource(R.drawable.ic_baseline_wifi_off_24)
                    imgStatus.setColorFilter(ContextCompat.getColor(this@MainActivity,R.color.disConnect),PorterDuff.Mode.MULTIPLY)
                    tvStatus.text="DisConnected ! :("
                    tvStatus.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.disConnect))

                }
            }
        }


    }
}