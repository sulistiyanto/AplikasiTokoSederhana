package com.tubandev.aplikasitokosederhana.network;

import com.tubandev.aplikasitokosederhana.model.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by sulistiyanto on 30/12/17.
 */

public interface API {

    @FormUrlEncoded
    @POST("login.php")
    Call<Result> login(@Field("user") String user,
                       @Field("password") String pass);
}
