package com.honlin.roomdemo.room.bean

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

/**
 * Created by honglin on 2018/7/21.
 */
@Entity(tableName = "user_table")
open class User(
        @PrimaryKey
        @NotNull
        @SerializedName("id")
        var id: String,
        @SerializedName("name")
        var name: String?,
        @SerializedName("sex")
        var sex: Int? = 0,
        @SerializedName("intro")
        var intro: String?
)