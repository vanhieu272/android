package com.example.Cooking.API;

import com.example.Cooking.Class.AnhCongThuc;
import com.example.Cooking.Class.CongThuc;
import com.example.Cooking.Class.DanhMuc;
import com.example.Cooking.Class.HistoryFind;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.Class.NguyenLieu;
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
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.12:8081/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);


    @GET("danhMuc")
    Call<List<DanhMuc>> getDanhMuc();

    @GET("getAllMon")
    Call<List<MonAn>> getAllMon();

    @GET("monAn/")
    Call<List<MonAn>> getMonAnByDanhMuc(@Query("maDM") String maDM);

    @GET("find/")
    Call<List<MonAn>> findMon(@Query("key") String key);

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

    //nguyen lieu
    @GET("nguyenLieu")
    Call<List<NguyenLieu>> getNguyenLieuByMaMon(@Query("maMon") String maMon);

    //cong thuc
    @GET("congThuc")
    Call<List<CongThuc>> getCongThucByMaMon(@Query("maMon") String maMon);



    @POST("user/login")
    Call<User> loginUser(@Body User user);

    @GET("user/")
    Call<String> getUserInfor(@Query("userName") String username);

    @POST("user/register")
    Call<User> registerUser(@Body User user);

    @PUT("user/{id}")
    Call<User> updateUser(@Body User user, @Path("id") Long id);

    //lich su
    @GET("lichsu")
    Call<List<HistoryFind>> getAllHistory(@Query("username") String user);

    @POST("lichsu")
    Call<HistoryFind> addHistory(@Body HistoryFind history);

    @DELETE("lichsu")
    Call<HistoryFind> deleteHistory(@Query("id") Long id);

    @DELETE("lichsuAll")
    Call<HistoryFind> deleteHistoryAll(@Query("username") String user);
//    Call<User> userLogin(@Body LoginRequest loginRequest);

}
