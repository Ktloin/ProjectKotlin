package com.bj.kotlinproject.upload;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiService2 {
    @POST("upload")
    @Multipart
    Call<ResponseBody> uploadPic(@Part("uid") RequestBody uid, @Part MultipartBody.Part file);
}
