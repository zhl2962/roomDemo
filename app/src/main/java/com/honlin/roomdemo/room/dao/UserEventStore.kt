package com.honlin.roomdemo.room.dao

import android.arch.persistence.room.Room
import android.content.Context
import com.honlin.roomdemo.room.bean.User
import com.honlin.roomdemo.room.listener.Callback

/**
 * Created by honglin on 2018/7/21.
 */
enum class UserEventStore {

    INSTANCE;

    private var mDao: UserDao? = null

    fun init(context: Context) {
        val db = Room.databaseBuilder(context, UserDatabase::class.java, "user_table").build()
        mDao = db.eventDao()
    }


    fun insert(event: User) {
        Thread(Runnable { mDao!!.insert(event) }).start()
    }

    @Synchronized
    fun getUser(callback: Callback) {
        //在io线程进行数据库操作
        Thread(Runnable {
            val entity = mDao!!.load("1")
            callback.call(entity)
        }).start()
    }


}