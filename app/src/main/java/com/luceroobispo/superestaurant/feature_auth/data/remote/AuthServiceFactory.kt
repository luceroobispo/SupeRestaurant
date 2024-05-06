package com.luceroobispo.superestaurant.feature_auth.data.remote

import com.luceroobispo.superestaurant.core_network.RetrofitFactory

class AuthServiceFactory private constructor() {
    companion object {
        fun getAuthService(): AuthService {
            return RetrofitFactory.getRetrofit().create(AuthService::class.java)
        }
    }
}