package com.example.Cooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class danhMucConActivity extends AppCompatActivity {

    ImageButton back, search;
    ListView listView;
    List<dmucCon> dmucConList;
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

        listView = findViewById(R.id.listView);
        dmucConList = new ArrayList<>();
        dmucConList.add(new dmucCon(R.drawable.sodacam,"Soda cam","Bởi user 1", "100", "50"));
        dmucConList.add(new dmucCon(R.drawable.sodathanhlong,"Soda thanh long","Bởi user 2", "100", "50"));
        dmucConList.add(new dmucCon(R.drawable.suagao,"Sữa gạo","Bởi user 2", "100", "50"));
        dmucConList.add(new dmucCon(R.drawable.trabidao,"Trà bí đao","Bởi user 2", "100", "50"));
        dmucConList.add(new dmucCon(R.drawable.trasua,"Trà sữa","Bởi user 2", "100", "50"));
        dmucConList.add(new dmucCon(R.drawable.nhadam,"Nước nha đam","Bởi user 2", "100", "50"));
        dmucConList.add(new dmucCon(R.drawable.travai,"Trà vải","Bởi user 2", "100", "50"));
        dmucConList.add(new dmucCon(R.drawable.tradao,"Trà đào","Bởi user 2", "100", "50"));
        dmucConList.add(new dmucCon(R.drawable.milodam,"Milo dầm","Bởi user 2", "100", "50"));
        dmucConList.add(new dmucCon(R.drawable.trachanh,"Trà chanh","Bởi user 2", "100", "50"));
        dmucConList.add(new dmucCon(R.drawable.tratac,"Trà tắc","Bởi user 2", "100", "50"));

        dmucConList.size();

        danhMucConAdapter = new danhMucConAdapter(this,R.layout.dong_danh_muc_con,dmucConList);
        listView.setAdapter(danhMucConAdapter);


    }
}