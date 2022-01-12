package com.example.Cooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.MonAn;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class danhMucConActivity extends AppCompatActivity {

    ImageButton back, search;
    ListView listView;
    List<MonAn> listMonAns;
    danhMucConAdapter danhMucConAdapter;
    private TextView txtTenDMC;
    String[] listNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc_con);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        listNhan = intent.getStringArrayExtra("tenDM");

        txtTenDMC = findViewById(R.id.tenDMC);
        txtTenDMC.setText(listNhan[0]);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(danhMucConActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });

        search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(danhMucConActivity.this, TimKiemActivity.class);
                startActivity(intent);
            }
        });

        listView = findViewById(R.id.listView);
        callAPIMonAn();

        //chọn món - xem chi tiết món
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MonAn monAn = listMonAns.get(position);
                TextView txtTenMon = view.findViewById(R.id.tenMon);
                String tenMon = String.valueOf(txtTenMon.getText());
                Intent intent = new Intent(danhMucConActivity.this, ChiTietActivity.class);

                intent.putExtra("mon",monAn);
                startActivity(intent);
            }
        });
    }

    private void callAPIMonAn(){
       ApiService.apiService.getMonAnByDanhMuc(listNhan[1]).enqueue(new Callback<List<MonAn>>() {
           @Override
           public void onResponse(Call<List<MonAn>> call, Response<List<MonAn>> response) {
               listMonAns = new ArrayList<>();
               listMonAns = response.body();

               if(listMonAns != null){
                   danhMucConAdapter = new danhMucConAdapter(danhMucConActivity.this,R.layout.dong_danh_muc_con,listMonAns);
                   listView.setAdapter(danhMucConAdapter);
               }
           }

           @Override
           public void onFailure(Call<List<MonAn>> call, Throwable t) {
               Toast.makeText(danhMucConActivity.this, "lỗi", Toast.LENGTH_SHORT).show();
           }
       });
    }
}