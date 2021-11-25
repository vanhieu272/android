package com.example.Cooking.API;

import com.example.Cooking.Class.DanhMuc;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.Class.User;
import com.example.Cooking.Class.YeuThich;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.6:8081/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);


    @GET("danhMuc")
    Call<List<DanhMuc>> getDanhMuc();

    @GET("getAllMon")
    Call<List<MonAn>> getAllMon();

    @GET("monAn/")
    Call<List<MonAn>> getMonAnByDanhMuc(@Query("maDM") String maDM);

    @GET("yeuThich/")
    Call<List<MonAn>> getMonYeuThichByUser(@Query("userName") String username);

    @POST("yeuThich")
    Call<YeuThich> createYeuThich(@Body YeuThich yeuThich);

    @GET("motYeuThich/")
    Call<YeuThich> getYeuThichByMaMon(@Query("maMon") String maMon, @Query("userName") String userName);

    @DELETE("yeuThich")
    Call<YeuThich> deleteYeuThich(@Query("id") Long id);

    @GET("motMonAn/")
    Call<MonAn> getMotMon(@Query("maMon") String maMon);

    @GET("user/login/")
    Call<User> getUser(@Query("userName") String username);

    @POST("user/register")
    Call<User> createNewUser();


//    Call<User> userLogin(@Body LoginRequest loginRequest);

}
