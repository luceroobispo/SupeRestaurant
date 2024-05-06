package com.luceroobispo.superestaurant.feature_auth.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

// --------------- GET ------------------
//https://plain-marbled-muskox.glitch.me/users?username=Lucero&password=1234
//"users" es el endpoint
//?username es el query, Lucero es el valor del query
//&password es el segundo query, 1234 es el valor del segundo query
//Call<List<UserResponse>> es el tipo de dato que devuelve el endpoint
// El endpoint devuelve una lista con un elemento, pero si no encuentra nada devuelve una lista vacia. En resumen: Lista
/*
[
    {
        "username:": "jmayta",
        "last_name": "Mayta",
        "first_name": "Jorge",
        "password": "1234",
        "id": 1
    }
]
*/

// --------------- POST ------------------

//https://plain-marbled-muskox.glitch.me/users
//"users" es el endpoint
//Call<UserResponse> es el tipo de dato que devuelve el endpoint
// El endpoint devuelve un objeto de tipo UserResponse. En resumen: Objeto
/*
{
    "username": "jmayta",
    "last_name": "Mayta",
    "first_name": "Jorge",
    "password": "1234"
}
*/

interface AuthService {
    @GET("users")
    fun logIn(@Query("username") username: String, @Query("password") password: String): Call<List<UserResponse>>

    @POST("users")
    fun signUp(@Body request: UserRequest): Call<UserResponse>
}