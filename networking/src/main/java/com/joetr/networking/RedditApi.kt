package com.joetr.networking

import io.reactivex.Maybe
import retrofit2.http.GET

interface RedditApi {

    @GET("r/androiddev/.json")
    fun getAndroidDev(): Maybe<Any>

}