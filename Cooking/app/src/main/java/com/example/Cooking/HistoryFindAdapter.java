package com.example.Cooking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.Cooking.Class.HistoryFind;
import com.example.Cooking.Class.MonAn;

import java.util.List;

public class HistoryFindAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HistoryFind> listkey;

    public HistoryFindAdapter(Context context, int layout, List<HistoryFind> listkey) {
        this.context = context;
        this.layout = layout;
        this.listkey = listkey;
    }

    @Override
    public int getCount() {
        return listkey.size();
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
        TextView txtKey = convertView.findViewById(R.id.txtKey);
        txtKey.setText(listkey.get(position).getNoiDung());
        return convertView;
    }
}
