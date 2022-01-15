package com.example.Cooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.AnhCongThuc;
import com.example.Cooking.Class.CongThuc;
import com.example.Cooking.Class.IP;
import com.example.Cooking.Class.LoadDuLieu;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.Class.NguyenLieu;
import com.example.Cooking.Class.YeuThich;

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
    private  List<AnhCongThuc> listAnh;
    LinearLayout linearLayout1CT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        MonAn mon = (MonAn) bundle.getSerializable("mon");
        String maDM = bundle.getString("maDM");

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

        CongThucTuongTu(maDM);
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
                        textNguyenLieu.setTextSize(14);
                        textNguyenLieu.setTextColor(Color.BLACK);
                        textNguyenLieu.setLayoutParams(layoutParamsTen);

                        LinearLayout.LayoutParams layoutParamsDL = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
                        layoutParamsDL.weight = 2;
                        TextView textDinhLuong = new TextView(ChiTietActivity.this);
                        textDinhLuong.setText(nl.getDinhLuong());
                        textDinhLuong.setTextSize(14);
                        textDinhLuong.setTextColor(Color.BLACK);
                        textDinhLuong.setLayoutParams(layoutParamsDL);

                        linearLayout.addView(textNguyenLieu);
                        linearLayout.addView(textDinhLuong);
                        lnNguyenLieu.addView(linearLayout);

                    }
//
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
                        txtCongThuc.setTextSize(14);
                        txtCongThuc.setTextColor(Color.BLACK);

                        LinearLayout.LayoutParams layoutParamsAnh = new LinearLayout.LayoutParams(200,200);
                        ImageView img = new ImageView(ChiTietActivity.this);
                        img.setLayoutParams(layoutParamsAnh);
                        Glide.with(ChiTietActivity.this).load(IP.localhostHinhAnh+ct.getAnhCT()).into(img);
                        img.setScaleType(ImageView.ScaleType.CENTER_CROP);

                        lnHuongDan.addView(txtCongThuc);
                        lnHuongDan.addView(img);



                    }
                }
            }

            @Override
            public void onFailure(Call<List<CongThuc>> call, Throwable t) {

            }
        });
    }

    //Công thức tương tự
    private void CongThucTuongTu(String maDM){
        ApiService.apiService.getMonAnByDanhMuc(maDM).enqueue(new Callback<List<MonAn>>() {
            @Override
            public void onResponse(Call<List<MonAn>> call, Response<List<MonAn>> response) {
                LoadDuLieu.listMonAn = response.body();
                if(LoadDuLieu.listMonAn!=null){
                    GridLayout gridLayout = findViewById(R.id.gridTuongTu);
                    int soCot = 2;
                    int soDong = 3;
                    //Collections.shuffle(LoadDuLieu.listMonAn);
                    for(int i = 1;i<=soDong;i++){
                        for (int j=1; j<= soCot; j++){
                            int vitri = soCot*(i-1)+j-1;
                            if(vitri<LoadDuLieu.listMonAn.size()){
                                MonAn monAn = LoadDuLieu.listMonAn.get(vitri);
                                //LinearLayout bao ngoài
                                LinearLayout linearLayoutTong = new LinearLayout(ChiTietActivity.this);
                                LinearLayout.LayoutParams layoutParamsTong = new LinearLayout.LayoutParams(300,LinearLayout.LayoutParams.WRAP_CONTENT);
                                layoutParamsTong.setMargins(45,0,0,0);
                                linearLayoutTong.setLayoutParams(layoutParamsTong);
                                linearLayoutTong.setOrientation(LinearLayout.VERTICAL);

                                //set ảnh
                                LinearLayout linearLayout = new LinearLayout(ChiTietActivity.this);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,250);
                                linearLayout.setLayoutParams(layoutParams);
                                ImageView imageView = new ImageView(ChiTietActivity.this);
                                Glide.with(ChiTietActivity.this).load(IP.localhostHinhAnh+monAn.getAnh()).into(imageView);
                                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                linearLayout.addView(imageView);

                                //set tên món và checkbox yêu thích
                                RelativeLayout relativeLayout = new RelativeLayout(ChiTietActivity.this);
                                RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,50);
                                relativeLayout.setLayoutParams(layoutParams1);

                                TextView textView = new TextView(ChiTietActivity.this);
                                textView.setText(monAn.getTenMon());
                                textView.setTextSize(14);
                                textView.setTextColor(Color.BLACK);
                                textView.setLines(2);

                                CheckBox checkBox = new CheckBox(ChiTietActivity.this);
                                String maYT = "";
                                if(LoadDuLieu.listYT!=null){
                                    for (MonAn mon: LoadDuLieu.listYT) {
                                        maYT +=" " + mon.getMaMon();
                                    }
                                    if(maYT.contains(monAn.getMaMon())){
                                        checkBox.setChecked(true);
                                    }
                                }
                                checkBox.setButtonDrawable(R.drawable.checkbox_15px);
                                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                                layoutParams2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,relativeLayout.getId());
                                checkBox.setLayoutParams(layoutParams2);

                                relativeLayout.addView(textView);
                                relativeLayout.addView(checkBox);

                                //người đăng
                                TextView textView1 = new TextView(ChiTietActivity.this);
                                textView1.setText(monAn.getNguoiDang());
                                textView1.setTextSize(12);
                                textView1.setTextColor(Color.rgb(90,90,90));

                                //giờ
                                TextView textView2 = new TextView(ChiTietActivity.this);
                                textView2.setText("1 gio");
                                textView2.setTextSize(14);
                                textView2.setTextColor(Color.BLACK);

                                linearLayoutTong.addView(linearLayout);
                                linearLayoutTong.addView(relativeLayout);
                                linearLayoutTong.addView(textView1);
                                linearLayoutTong.addView(textView2);

                                gridLayout.addView(linearLayoutTong);

                                //sự kiện checkbox
                                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                        if(isChecked){
                                            Toast.makeText(ChiTietActivity.this, "chon", Toast.LENGTH_SHORT).show();
                                            YeuThich yeuThich = new YeuThich();
                                            yeuThich.setMaMon(LoadDuLieu.listMonAn.get(vitri).getMaMon());
                                            yeuThich.setUser(TrangChuActivity.userName);
                                            ApiService.apiService.createYeuThich(yeuThich).enqueue(new Callback<YeuThich>() {
                                                @Override
                                                public void onResponse(Call<YeuThich> call, Response<YeuThich> response) {
                                                    if(response.isSuccessful()){
                                                        Toast.makeText(ChiTietActivity.this, "thanh cong", Toast.LENGTH_SHORT).show();
                                                    }
                                                    else {
                                                        Toast.makeText(ChiTietActivity.this, "tb", Toast.LENGTH_SHORT).show();
                                                    }
                                                }

                                                @Override
                                                public void onFailure(Call<YeuThich> call, Throwable t) {

                                                }
                                            });
                                        }
                                        else {
                                            Toast.makeText(ChiTietActivity.this, "bo chon", Toast.LENGTH_SHORT).show();
                                            ApiService.apiService.getYeuThichByMaMon(LoadDuLieu.listMonAn.get(vitri).getMaMon(), TrangChuActivity.userName).enqueue(new Callback<YeuThich>() {
                                                @Override
                                                public void onResponse(Call<YeuThich> call, Response<YeuThich> response) {
                                                    YeuThich yeuThich = response.body();
                                                    ApiService.apiService.deleteYeuThich(yeuThich.getId()).enqueue(new Callback<YeuThich>() {
                                                        @Override
                                                        public void onResponse(Call<YeuThich> call, Response<YeuThich> response) {
                                                            if (response.isSuccessful()){
                                                                LoadDuLieu.listYT.remove(yeuThich);
                                                                Log.e("a","xoa tc");
                                                            }
                                                        }

                                                        @Override
                                                        public void onFailure(Call<YeuThich> call, Throwable t) {

                                                        }
                                                    });

                                                }

                                                @Override
                                                public void onFailure(Call<YeuThich> call, Throwable t) {

                                                }
                                            });

                                        }
                                    }
                                });
                            }

                            //

                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<List<MonAn>> call, Throwable t) {

            }
        });
    }

}