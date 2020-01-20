package com.android.vira.api

import android.view.View
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by HosseinBahrami at 1/19/2020
 */

object RetrofitCallBack {

    fun <T> callRetrofit(call: Call<T>, loading: View?, retrofitObject: RetrofitObject<T>) {
        //Show Loading if Exists
        if (loading != null) loading.visibility = View.VISIBLE

        //Call Api With Generic CallBack
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                //Hidden Loading if Exists
                if (loading != null) loading.visibility = View.GONE

                if (response.isSuccessful) {
                    retrofitObject.onSuccess(body = response.body()!!)
                } else {
                    retrofitObject.onFailure(message = response.errorBody()!!.string())
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                //Hidden Loading if Exists
                if (loading != null) loading.visibility = View.GONE

                retrofitObject.onFailure(message = t.message.toString())
            }
        })
    }
}