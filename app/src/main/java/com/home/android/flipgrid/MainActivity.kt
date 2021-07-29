package com.home.android.flipgrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commitNow
import com.home.android.flipgrid.register.RegisterFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.commitNow(true) {
            setReorderingAllowed(true)
            add(R.id.fragment_container_view, RegisterFragment.newInstance())
        }
    }
}