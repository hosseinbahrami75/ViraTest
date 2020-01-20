package com.android.vira.api

/**
 * Created by HosseinBahrami at 1/19/2020
 */

interface RetrofitObject<T> {

    fun onSuccess(body: T)

    fun onFailure(message: String)
}