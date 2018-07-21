package com.honlin.roomdemo.room.listener

import com.honlin.roomdemo.room.bean.User

/**
 * Created by honglin on 2018/7/21.
 */
interface Callback {

    fun call(date: User)

}