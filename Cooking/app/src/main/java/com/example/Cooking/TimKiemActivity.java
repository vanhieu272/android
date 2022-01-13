package com.example.Cooking;

import static com.example.Cooking.ui.favorite.FavoriteFragment.listView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.HistoryFind;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.ui.favorite.FavoriteFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TimKiemActivity extends AppCompatActivity {

    ImageButton back;
    ImageButton btnSearch;
    EditText edtKey;
    List<MonAn> listMon = new ArrayList<>();
    danhMucConAdapter danhMucConAdapter;
    HistoryFindAdapter historyFindAdapter;
    ListView listView;
    ListView lvHistory;
    LinearLayout lnHistory;
    Boolean ktYeuThich = false;
    private List<MonAn> monAnListYT;
    private List<HistoryFind> listHistory = new ArrayList<>();
    TextView txtXoaHet ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //mapping
        listView = findViewById(R.id.listFind);
        btnSearch = findViewById(R.id.btnSearch);
        lnHistory = findViewById(R.id.history);
        lvHistory = findViewById(R.id.lvHistory);
        edtKey = findViewById(R.id.keySearch);
        back = findViewById(R.id.back);
        txtXoaHet = findViewById(R.id.deleteAll);

        //nut back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimKiemActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });

        //get intent

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            ktYeuThich = bundle.getBoolean("kt");
            monAnListYT = new ArrayList<>();
            monAnListYT = FavoriteFragment.monAnList;
        }

        //get lich su
        if(TrangChuActivity.userName != null){
            getAllHistory();
        }


        //search
        edtKey.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //String key = String.valueOf(edtKey.getText());
                String key = String.valueOf(s);
                if(key.length()>0){
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0);
                    lnHistory.setLayoutParams(layoutParams);

                }
                else{
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                    lnHistory.setLayoutParams(layoutParams);
                    if(listMon!=null){
                        listView.setVisibility(View.INVISIBLE);
                    }

                    //lấy lịch sử nội dung tìm kiếm
                    if(TrangChuActivity.userName != null){
                        getAllHistory();
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = String.valueOf(edtKey.getText());
                if(TrangChuActivity.userName != null){
                    Boolean kt = false; //kiểm tra xem từ khóa đã có trong mảng chưa
                    for (HistoryFind his:listHistory) {
                        if(key.equals(his.getNoiDung())){
                            kt = true; //nếu có là true
                            break;
                        }
                    }
                    if(!kt){
                        HistoryFind newHistory = new HistoryFind(key,TrangChuActivity.userName);
                        addHistory(newHistory);
                    }
                }

                if(!ktYeuThich){
                    CallApiFind(key);
                }
                else{
                    if(monAnListYT !=null){
                        FindFromListFavorite(key);
                    }
                    else{
                        Toast.makeText(TimKiemActivity.this, "danh sach yeu thich trong", Toast.LENGTH_SHORT).show();
                    }
                    
                }

            }
        });

        //xoa het
        txtXoaHet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TrangChuActivity.userName != null){
                    deleteHistoryAll();
                    getAllHistory();
                }

            }
        });

        //chọn lại 1 item
        lvHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtKey = view.findViewById(R.id.txtKey);
                String key = String.valueOf(txtKey.getText());
                edtKey.setText(key);
                CallApiFind(key);
                
                ImageButton imgDelete = (ImageButton) view.findViewById(R.id.delete);
                imgDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(TimKiemActivity.this, "xoa", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void CallApiFind(String key){
        ApiService.apiService.findMon(key).enqueue(new Callback<List<MonAn>>() {
            @Override
            public void onResponse(Call<List<MonAn>> call, Response<List<MonAn>> response) {
                listMon = response.body();

                if(listMon != null){
                    listView.setVisibility(View.VISIBLE);
                    danhMucConAdapter = new danhMucConAdapter(TimKiemActivity.this,R.layout.dong_danh_muc_con,listMon);
                    listView.setAdapter(danhMucConAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<MonAn>> call, Throwable t) {

            }
        });
    }

    private void FindFromListFavorite(String key){
        listMon.clear();
        for (MonAn mon:monAnListYT) {
            if(mon.getTenMon().toLowerCase().contains(key.toLowerCase())){
                listMon.add(mon);
            }
        }
        if(listMon != null){
            listView.setVisibility(View.VISIBLE);
            danhMucConAdapter = new danhMucConAdapter(TimKiemActivity.this,R.layout.dong_danh_muc_con,listMon);
            listView.setAdapter(danhMucConAdapter);
        }
    }

    private void getAllHistory(){
        ApiService.apiService.getAllHistory(TrangChuActivity.userName).enqueue(new Callback<List<HistoryFind>>() {
            @Override
            public void onResponse(Call<List<HistoryFind>> call, Response<List<HistoryFind>> response) {
                listHistory = response.body();
                if(listHistory!=null){
                    historyFindAdapter = new HistoryFindAdapter(TimKiemActivity.this,R.layout.row_history_find,listHistory);
                    lvHistory.setAdapter(historyFindAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<HistoryFind>> call, Throwable t) {

            }
        });
    }

    private void addHistory(HistoryFind history){
        ApiService.apiService.addHistory(history).enqueue(new Callback<HistoryFind>() {
            @Override
            public void onResponse(Call<HistoryFind> call, Response<HistoryFind> response) {
                HistoryFind his = response.body();
                if(response.body()!=null){
                    Toast.makeText(TimKiemActivity.this, "tc", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<HistoryFind> call, Throwable t) {
                Toast.makeText(TimKiemActivity.this, "loi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteHistoryAll(){
        ApiService.apiService.deleteHistoryAll(TrangChuActivity.userName).enqueue(new Callback<HistoryFind>() {
            @Override
            public void onResponse(Call<HistoryFind> call, Response<HistoryFind> response) {
                Toast.makeText(TimKiemActivity.this, "tc", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<HistoryFind> call, Throwable t) {
                Toast.makeText(TimKiemActivity.this, "loi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}