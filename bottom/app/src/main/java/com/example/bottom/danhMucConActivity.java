package com.example.bottom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.bottom.API.ApiService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class danhMucConActivity extends AppCompatActivity {

    ImageButton back, search;
    ListView listView;
    List<MonAn> dmucConList;
    danhMucConAdapter danhMucConAdapter;
    private TextView txtTenDMC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc_con);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        String text = intent.getStringExtra("thucuong");

        txtTenDMC = findViewById(R.id.tenDMC);
        txtTenDMC.setText(text);

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

//        listView = findViewById(R.id.listView);
//        dmucConList = new ArrayList<>();
//        dmucConList.add(new MonAn(R.drawable.sodacam,"Soda cam","Bởi user 1", "100", "50"));
//        dmucConList.add(new MonAn(R.drawable.sodathanhlong,"Soda thanh long","Bởi user 2", "100", "50"));
//        dmucConList.add(new MonAn(R.drawable.suagao,"Sữa gạo","Bởi user 2", "100", "50"));
//        dmucConList.add(new MonAn(R.drawable.trabidao,"Trà bí đao","Bởi user 2", "100", "50"));
//        dmucConList.add(new MonAn(R.drawable.trasua,"Trà sữa","Bởi user 2", "100", "50"));
//        dmucConList.add(new MonAn(R.drawable.nhadam,"Nước nha đam","Bởi user 2", "100", "50"));
//        dmucConList.add(new MonAn(R.drawable.travai,"Trà vải","Bởi user 2", "100", "50"));
//        dmucConList.add(new MonAn(R.drawable.tradao,"Trà đào","Bởi user 2", "100", "50"));
//        dmucConList.add(new MonAn(R.drawable.milodam,"Milo dầm","Bởi user 2", "100", "50"));
//        dmucConList.add(new MonAn(R.drawable.trachanh,"Trà chanh","Bởi user 2", "100", "50"));
//        dmucConList.add(new MonAn(R.drawable.tratac,"Trà tắc","Bởi user 2", "100", "50"));
//
//        dmucConList.size();
        callAPIMonAn();

//        danhMucConAdapter = new danhMucConAdapter(this,R.layout.dong_danh_muc_con,dmucConList);
//        listView.setAdapter(danhMucConAdapter);


    }

    private void callAPIMonAn(){
       ApiService.apiService.getMonAnByDanhMuc("thuc-uong").enqueue(new Callback<List<MonAn>>() {
           @Override
           public void onResponse(Call<List<MonAn>> call, Response<List<MonAn>> response) {
               List<MonAn> listMonAns = new ArrayList<>();
               listMonAns = response.body();
               listView = findViewById(R.id.listView);
//               for (MonAn item:listMonAns) {
//                   File file = new File("file:///D:\\Nam3_Ki1\\LTDT_Android\\bottom\\app\\src\\main\\res\\drawable","annhanh.jpg");
//                   //Toast.makeText(danhMucConActivity.this, ""+(CharSequence) file, Toast.LENGTH_SHORT).show();
//               }
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