package com.honlin.roomdemo.room.dao;

import android.arch.persistence.room.Database;

import com.honlin.roomdemo.room.bean.User;

import android.arch.persistence.room.RoomDatabase;

/**
 * Created by honglin on 2018/7/21.
 */


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao eventDao();
}