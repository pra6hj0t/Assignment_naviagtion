package com.example.assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val btnBottom = findViewById<BottomNavigationView>(R.id.navi_Bar)


            replaceWithFragment(Home())

        btnBottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.search -> replaceWithFragment(Search())
                R.id.categories -> replaceWithFragment(Categories())
                R.id.home -> replaceWithFragment(Home())
                R.id.cart -> replaceWithFragment(Cart())
                R.id.user -> replaceWithFragment(User())

            }
            true
        }
    }

    private fun replaceWithFragment(fragment :Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}