package com.cheise_proj.local_source.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class ProfileEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val username: String,
    val regNo: String,
    val gender: String,
    val dob: String,
    val avatar: String,
    val bloodGroup: String,
    val address: String,
    val className: String
) {
    var userId:Int = -1
    var father: String? = null
    var mother: String? = null
    var contact: String? = null
    var email:String? = null
    var department:String? = null
    var education:String? = null
    var subject:String? = null
}