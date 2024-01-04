package com.ardev.barcelona

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PlayerDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)

        val playerName = findViewById<TextView>(R.id.player_name)
        val playerPost = findViewById<TextView>(R.id.player_post)
        val playerPhoto = findViewById<ImageView>(R.id.player_profile)
        val playerDesc = findViewById<TextView>(R.id.player_desc)
        val playerSpecial = findViewById<TextView>(R.id.player_special)

        val playerDetail = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Player_Identity>("key_player", Player_Identity::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Player_Identity>("key_player")
        }

        if (playerDetail != null) {
            playerName.text = playerDetail.name
            playerPost.text = playerDetail.position
            playerPhoto.setImageResource(playerDetail.photo)
            playerDesc.text = playerDetail.desc
            playerSpecial.text = playerDetail.special
        }
    }
}