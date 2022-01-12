package com.example.Cooking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.Cooking.Class.NguyenLieu;

import java.util.List;

public class NguyenLieuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<NguyenLieu> listNguyenLieu;

    public NguyenLieuAdapter(Context context, int layout, List<NguyenLieu> listNguyenLieu) {
        this.context = context;
        this.layout = layout;
        this.listNguyenLieu = listNguyenLieu;
    }

    @Override
    public int getCount() {
        return listNguyenLieu.size();
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
        TextView txtTen = convertView.findViewById(R.id.ten);
        TextView txtDinhLuong = convertView.findViewById(R.id.dinhLuong);

        NguyenLieu nguyenLieu = listNguyenLieu.get(position);
        txtTen.setText(nguyenLieu.getTen());
        txtDinhLuong.setText(nguyenLieu.getDinhLuong());
        return convertView;
    }
}
