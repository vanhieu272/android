package com.example.Cooking.ui.favorite;

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
import com.example.Cooking.FragmentAdapter;
import com.example.Cooking.R;
import com.example.Cooking.TrangChuActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<MonAn> monAnList;
    private YeuThich yeuThich;

    public FavoriteAdapter(Context context, int layout, List<MonAn> monAnList) {
        this.context = context;
        this.layout = layout;
        this.monAnList = monAnList;
    }

    @Override
    public int getCount() {
        return monAnList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        ImageView hinh = convertView.findViewById(R.id.hinh);
        TextView tenMon = convertView.findViewById(R.id.tenMon);
        TextView nguoiDang = convertView.findViewById(R.id.nguoiDang);
        TextView luotXem = convertView.findViewById(R.id.luotXem);
        TextView luotThich = convertView.findViewById(R.id.luotThich);


        MonAn sv = monAnList.get(position);
        tenMon.setText(sv.getTenMon());
        nguoiDang.setText(sv.getNguoiDang());
        luotXem.setText(sv.getLuotXem());
        luotThich.setText(sv.getLuotThich());
        Glide.with(context).load(IP.localhostHinhAnh+sv.getAnh()).into(hinh);

        CheckBox checkBox = convertView.findViewById(R.id.checkboxYeuThich);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ApiService.apiService.getYeuThichByMaMon(sv.getMaMon(), TrangChuActivity.userName).enqueue(new Callback<YeuThich>() {
                        @Override
                        public void onResponse(Call<YeuThich> call, Response<YeuThich> response) {
                            yeuThich = response.body();
                            ApiService.apiService.deleteYeuThich(yeuThich.getId()).enqueue(new Callback<YeuThich>() {
                                @Override
                                public void onResponse(Call<YeuThich> call, Response<YeuThich> response) {
                                    if (response.isSuccessful()){
                                        LoadDuLieu.listYT.remove(yeuThich);
                                        Log.d("a",LoadDuLieu.listYT.size()+"");
//                                        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(context,R.layout.dong_yeu_thich, LoadDuLieu.listYT);
//                                        FavoriteFragment.listView.setAdapter(favoriteAdapter);
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

        return convertView;
    }

}
