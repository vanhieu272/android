package com.example.Cooking;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.IP;
import com.example.Cooking.Class.LoadDuLieu;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.Class.YeuThich;
import com.example.Cooking.ui.favorite.FavoriteAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class danhMucConAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<MonAn> dmucConList;
    private CheckBox checkBox;
    String maYT = "";

    public danhMucConAdapter(Context context, int layout, List<MonAn> dmucConList) {
        this.context = context;
        this.layout = layout;
        this.dmucConList = dmucConList;
    }

    @Override
    public int getCount() {
        return dmucConList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        ImageView hinh = view.findViewById(R.id.hinh);
        TextView tenMon = view.findViewById(R.id.tenMon);
        TextView nguoiDang = view.findViewById(R.id.nguoiDang);
        TextView luotXem = view.findViewById(R.id.luotXem);
        TextView luotThich = view.findViewById(R.id.luotThich);

        MonAn monAn = dmucConList.get(i);
        tenMon.setText(monAn.getTenMon());
        nguoiDang.setText(monAn.getNguoiDang());
        luotXem.setText(monAn.getLuotXem());
        luotThich.setText(monAn.getLuotThich());

        checkBox = view.findViewById(R.id.checkbox);
//        checkBox.setButtonDrawable(R.drawable.checkbox_red);

        //lấy mã đã yêu thích

        if(LoadDuLieu.listYT!=null){
            for (MonAn mon: LoadDuLieu.listYT) {
                maYT +=" " + mon.getMaMon();
            }
            if(maYT.contains(monAn.getMaMon())){
                checkBox.setChecked(true);
            }
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.e("e","chon");
                    YeuThich yeuThich = new YeuThich();
                    yeuThich.setMaMon(monAn.getMaMon());
                    yeuThich.setUser(TrangChuActivity.userName);

                    ApiService.apiService.createYeuThich(yeuThich).enqueue(new Callback<YeuThich>() {
                        @Override
                        public void onResponse(Call<YeuThich> call, Response<YeuThich> response) {
                            if(response.isSuccessful()) {
                                Log.e("e", "tc");
                            }
                            else {
                                    Log.e("e","tb");
                            }
                        }

                        @Override
                        public void onFailure(Call<YeuThich> call, Throwable t) {

                        }
                    });
                }
                else{
                    Log.e("e","bochon");
                    ApiService.apiService.getYeuThichByMaMon(monAn.getMaMon(), TrangChuActivity.userName).enqueue(new Callback<YeuThich>() {
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



        Glide.with(context).load(IP.localhostHinhAnh+monAn.getAnh()).into(hinh);

        return view;
    }
    private void getListYeuThich(MonAn monAn){
        if(TrangChuActivity.userName != null){
            ApiService.apiService.getMonYeuThichByUser(TrangChuActivity.userName).enqueue(new Callback<List<MonAn>>() {
                @Override
                public void onResponse(Call<List<MonAn>> call, Response<List<MonAn>> response) {
                    List<MonAn>  monAnList = response.body();
                    LoadDuLieu.listYT = monAnList;

                }

                @Override
                public void onFailure(Call<List<MonAn>> call, Throwable t) {

                }
            });
        }
    }

}
