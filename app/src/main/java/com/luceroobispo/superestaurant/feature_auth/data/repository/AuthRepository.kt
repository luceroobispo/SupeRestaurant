package com.luceroobispo.superestaurant.feature_auth.data.repository

import android.util.Log
import com.luceroobispo.superestaurant.feature_auth.data.remote.AuthService
import com.luceroobispo.superestaurant.feature_auth.data.remote.AuthServiceFactory
import com.luceroobispo.superestaurant.feature_auth.data.remote.UserRequest
import com.luceroobispo.superestaurant.feature_auth.data.remote.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class AuthRepository (val authService: AuthService = AuthServiceFactory.getAuthService()){
    fun logIn(username: String, password: String){

        val logIn = authService.logIn(username, password)

        logIn.enqueue(object: Callback<List<UserResponse>>{
            override fun onResponse(call: Call<List<UserResponse>>, response: Response<List<UserResponse>>) {
                if(response.isSuccessful){
                    val user = response.body()?.first()
                    println(user)
                }
            }
            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                t.message?.let {
                    Log.d("AuthRepository", it)
                }
            }
        })
    }
    fun signUp(userRequest: UserRequest, callback: (UserResponse) -> Unit){
        val signUp = authService.signUp(userRequest)

        signUp.enqueue(object: Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful){
                    val userResponse = response.body() as UserResponse
                    callback(userResponse)
                }
            }
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                t.message?.let {
                    Log.d("AuthRepository", it)
                }
            }
        })
    }
}