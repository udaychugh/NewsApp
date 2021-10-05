package com.udaychugh.newapp

import retrofit2.Retrofit
import com.udaychugh.newapp.ApiInterface
import com.udaychugh.newapp.ApiUtilites
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilites {
    private var retrofit: Retrofit? = null
    @kotlin.jvm.JvmStatic
    val apiInterface: ApiInterface
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(ApiInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit!!.create(ApiInterface::class.java)
        }
}