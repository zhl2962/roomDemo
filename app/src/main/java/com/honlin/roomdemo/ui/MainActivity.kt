package com.honlin.roomdemo.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.honlin.roomdemo.R
import com.honlin.roomdemo.room.bean.User
import com.honlin.roomdemo.ui.vm.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this@MainActivity).get(MainViewModel::class.java)

        tv1.setOnClickListener {
            mainViewModel.insert()
            mainViewModel.loadUser()
        }

        mainViewModel.user.observe(this, Observer<User> {

            user: User? ->
            if (user == null) {
                tv2.text = "1111"
            } else {
                tv2.text = (user.intro)
            }
        })

    }


}
