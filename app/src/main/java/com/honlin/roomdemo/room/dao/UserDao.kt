package com.honlin.roomdemo.room.dao

import android.arch.persistence.room.*
import com.honlin.roomdemo.room.bean.User


/**
 * Created by honglin on 2018/7/21.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(event: User)

    @Delete
    fun delete(event: User)

    @Query("SELECT * FROM user_table")
    fun queryListEvent(): List<User>

    @Query("SELECT * FROM user_table WHERE id = :userId")
    fun load(userId: String): User

}