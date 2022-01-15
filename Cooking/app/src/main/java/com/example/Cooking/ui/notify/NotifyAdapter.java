package com.example.Cooking.ui.notify;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.IP;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.Class.ThongBao;
import com.example.Cooking.Class.YeuThich;
import com.example.Cooking.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotifyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ThongBao> TBList;

    public NotifyAdapter(Context context, int layout, List<ThongBao> TBList) {
        this.context = context;
        this.layout = layout;
        this.TBList = TBList;
    }

    @Override
    public int getCount() {
        return TBList.size();
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

        ImageView anhTB = convertView.findViewById(R.id.anhTB);
        TextView noidung = convertView.findViewById(R.id.noiDung);
        RelativeLayout rlMau = convertView.findViewById(R.id.mau);


        ThongBao thongBao = TBList.get(position);
        noidung.setText(thongBao.getNoiDung());

        if(thongBao.getStatus() == 1){
            rlMau.setBackgroundColor(Color.WHITE);
        }
        ApiService.apiService.getMonById(thongBao.getMaMon()).enqueue(new Callback<MonAn>() {
            @Override
            public void onResponse(Call<MonAn> call, Response<MonAn> response) {
                MonAn monAn = response.body();
                Glide.with(context).load(IP.localhostHinhAnh+monAn.getAnh()).into(anhTB);

            }

            @Override
            public void onFailure(Call<MonAn> call, Throwable t) {

            }
        });

        return convertView;
    }


}
