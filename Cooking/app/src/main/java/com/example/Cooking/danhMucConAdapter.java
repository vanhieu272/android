package com.example.Cooking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class danhMucConAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<MonAn> dmucConList;

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

        MonAn sv = dmucConList.get(i);
        tenMon.setText(sv.getTenMon());
        nguoiDang.setText(sv.getNguoiDang());
        luotXem.setText(sv.getLuotXem());
        luotThich.setText(sv.getLuotThich());
        //hinh.setImageResource(Integer.parseInt("R.drawable."+sv.getAnh()));


        Glide.with(context).load("http://192.168.1.7:8081/image/"+sv.getAnh()).into(hinh);

//        ImageButton imgBtYeuThich = view.findViewById(R.id.imgBtYeuThich);
//        imgBtYeuThich.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgBtYeuThich.setImageResource(R.drawable.ic_baseline_favorite_red);
//            }
//        });
        return view;
    }
}
