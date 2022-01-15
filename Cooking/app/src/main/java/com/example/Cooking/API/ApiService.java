package com.example.Cooking.API;

import com.example.Cooking.Class.AnhCongThuc;
import com.example.Cooking.Class.CongThuc;
import com.example.Cooking.Class.DanhMuc;
import com.example.Cooking.Class.HistoryFind;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.Class.NguyenLieu;
import com.example.Cooking.Class.ThongBao;
import com.example.Cooking.Class.User;
import com.example.Cooking.Class.YeuThich;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
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

    //lấy món ăn theo id
    @GET("motMonAnId")
    Call<MonAn> getMonById(@Query("id") Long id);

    @GET("yeuThich/")
    Call<List<MonAn>> getMonYeuThichByUser(@Query("userName") String username);

    @POST("yeuThich")
    Call<YeuThich> createYeuThich(@Body YeuThich yeuThich);

    @GET("motYeuThich/")
    Call<YeuThich> getYeuThichByMaMon(@Query("maMon") String maMon, @Query("userName") String userName);

    @DELETE("yeuThich")
    Call<YeuThich> deleteYeuThich(@Query("id") Long id);

    //lấy list thông báo
    @GET("thongBao")
    Call<List<ThongBao>> getListThongBaoByUser(@Query("userName") String username);

    //cập nhật trạng thái thông báo
    @PUT("thongBao/{id}")
    Call<ThongBao> updateThongBao(@Body ThongBao thongBao, @Path("id") Long id);

    //get 1 mon ny mã món
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

    @Multipart
    @POST("image")
    Call<User> uploadImage(@Part MultipartBody.Part file,@Part("userName") RequestBody userName);

//    @Multipart
//    @POST("image1")
//    Call<User> uploadImage1(@Part MultipartBody.Part file);

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
