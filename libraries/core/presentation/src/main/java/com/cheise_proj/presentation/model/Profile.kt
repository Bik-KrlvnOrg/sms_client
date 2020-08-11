package com.cheise_proj.presentation.model

data class Profile(
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