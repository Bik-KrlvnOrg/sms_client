package com.cheise_proj.student_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cheise_proj.actions.Actions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Actions.openAuthIntent(this))
    }
}