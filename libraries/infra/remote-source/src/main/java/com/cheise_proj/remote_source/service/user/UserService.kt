package com.cheise_proj.remote_source.service.user

import com.cheise_proj.remote_source.model.CredentialDto
import com.cheise_proj.remote_source.model.LoginDto
import com.cheise_proj.remote_source.model.StaffProfileDto
import com.cheise_proj.remote_source.model.StudentProfileDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface UserService {

    @POST("users/login")
    fun loginUser(@Body credentialDto: CredentialDto): Observable<LoginDto>

    @GET("student/profile")
    fun getStudentProfile(): Observable<StudentProfileDto>

    @GET("staff/profile")
    fun getStaffProfile(): Observable<StaffProfileDto>


}