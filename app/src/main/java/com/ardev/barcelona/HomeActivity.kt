package com.ardev.barcelona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var rvPlayer: RecyclerView
    private val list = ArrayList<Player_Identity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvPlayer = findViewById(R.id.rvPlayer)
        rvPlayer.setHasFixedSize(true)

        list.addAll(getListPlayer())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intentAbout = Intent(this, AboutActivity::class.java)
        startActivity(intentAbout)

        return super.onOptionsItemSelected(item)
    }

    private fun getListPlayer(): ArrayList<Player_Identity> {
        val dataName = resources.getStringArray(R.array.player_name)
        val dataPosition = resources.getStringArray(R.array.player_position)
        val dataDesc = resources.getStringArray(R.array.player_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.player_photo)
        val playerSpecial = resources.getStringArray(R.array.player_special)
        val listPlayer = ArrayList<Player_Identity>()

        for (i in dataName.indices) {
            val player = Player_Identity(
                dataName[i],
                dataPosition[i],
                dataDesc[i],
                dataPhoto.getResourceId(i, -1),
                playerSpecial[i]
            )
            listPlayer.add(player)
        }
        return listPlayer
    }

    private fun showRecyclerList() {
        rvPlayer.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = ListPlayerAdapter(list)
        rvPlayer.adapter = listPlayerAdapter
    }
}