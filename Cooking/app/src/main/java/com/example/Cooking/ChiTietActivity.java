package com.example.Cooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.CongThuc;
import com.example.Cooking.Class.IP;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.Class.NguyenLieu;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChiTietActivity extends AppCompatActivity {

    private TextView txtTenMon;
    private ImageButton back;
    private ImageView anhMon;
    private ListView listViewNguyeLieu;
    private NguyenLieuAdapter nguyenLieuAdapter;
    List<NguyenLieu> listNguyenLieu;
    private LinearLayout lnNguyenLieu;
    private LinearLayout lnHuongDan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        MonAn mon = (MonAn) intent.getSerializableExtra("mon");

        //set tên món
        txtTenMon = findViewById(R.id.tenMon);
        txtTenMon.setText(mon.getTenMon());

        //set ảnh món
        anhMon = findViewById(R.id.anhMon);
        Glide.with(this).load(IP.localhostHinhAnh+mon.getAnh()).into(anhMon);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiTietActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });



        //get linearNguyenLieu
        lnNguyenLieu = findViewById(R.id.lnNguyenLieu);
        CallApiGetNguyenLieu(mon.getMaMon());

        //get linear HuongDan
        lnHuongDan = findViewById(R.id.huongDan);
        CallApiGetCongThuc(mon.getMaMon());
    }

    private void CallApiGetNguyenLieu(String maMon){
        ApiService.apiService.getNguyenLieuByMaMon(maMon).enqueue(new Callback<List<NguyenLieu>>() {
            @Override
            public void onResponse(Call<List<NguyenLieu>> call, Response<List<NguyenLieu>> response) {
                listNguyenLieu = response.body();
                if(listNguyenLieu != null){

                    for (NguyenLieu nl: listNguyenLieu) {
                        LinearLayout linearLayout = new LinearLayout(ChiTietActivity.this);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                        layoutParams.setMargins(40,10,0,10);
                        linearLayout.setLayoutParams(layoutParams);
                        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                        //Tên nguyên liệu
                        LinearLayout.LayoutParams layoutParamsTen = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
                        layoutParamsTen.weight = 8;
                        TextView textNguyenLieu = new TextView(ChiTietActivity.this);
                        textNguyenLieu.setText(nl.getTen());
                        textNguyenLieu.setTextSize(18);
                        textNguyenLieu.setTextColor(Color.BLACK);
                        textNguyenLieu.setLayoutParams(layoutParamsTen);

                        LinearLayout.LayoutParams layoutParamsDL = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
                        layoutParamsDL.weight = 2;
                        TextView textDinhLuong = new TextView(ChiTietActivity.this);
                        textDinhLuong.setText(nl.getDinhLuong());
                        textDinhLuong.setTextSize(18);
                        textDinhLuong.setTextColor(Color.BLACK);
                        textDinhLuong.setLayoutParams(layoutParamsDL);

                        linearLayout.addView(textNguyenLieu);
                        linearLayout.addView(textDinhLuong);
                        lnNguyenLieu.addView(linearLayout);

                    }
//                    nguyenLieuAdapter = new NguyenLieuAdapter(ChiTietActivity.this,R.layout.dong_nguyen_lieu,listNguyenLieu);
//                    listViewNguyeLieu.setAdapter(nguyenLieuAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<NguyenLieu>> call, Throwable t) {
                Toast.makeText(ChiTietActivity.this, "loi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void CallApiGetCongThuc(String maMon){
        ApiService.apiService.getCongThucByMaMon(maMon).enqueue(new Callback<List<CongThuc>>() {
            @Override
            public void onResponse(Call<List<CongThuc>> call, Response<List<CongThuc>> response) {
                List<CongThuc> listCongThuc = response.body();
                if(listCongThuc!=null){
                    int i =1;
                    for (CongThuc ct:listCongThuc) {
                        TextView txtCongThuc = new TextView(ChiTietActivity.this);
                        txtCongThuc.setText(i++ + ". "+ ct.getCongThuc());
                        txtCongThuc.setTextSize(16);
                        txtCongThuc.setTextColor(Color.BLACK);
                        lnHuongDan.addView(txtCongThuc);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CongThuc>> call, Throwable t) {

            }
        });
    }
}