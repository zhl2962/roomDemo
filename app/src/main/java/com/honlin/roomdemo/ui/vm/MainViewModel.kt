package com.honlin.roomdemo.ui.vm

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.honlin.roomdemo.room.bean.User
import com.honlin.roomdemo.room.dao.UserEventStore
import com.honlin.roomdemo.room.listener.Callback

/**
 * Created by honglin on 2018/7/21.
 */
class MainViewModel : AndroidViewModel {

     val user = MutableLiveData<User>()

    constructor(application: Application) : super(application) {
        UserEventStore.INSTANCE.init(application)
    }


    fun insert() {
        UserEventStore.INSTANCE.insert(User("1", "121", 1, "hh" + System.currentTimeMillis()))
    }

    fun loadUser() {

        UserEventStore.INSTANCE.getUser(object : Callback {
            override fun call(date: User) {
                user.postValue(date)
            }
        })
    }


}