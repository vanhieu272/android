package com.example.Cooking.ui.notify;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.Cooking.API.ApiService;
import com.example.Cooking.ChiTietActivity;
import com.example.Cooking.Class.LoadDuLieu;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.Class.ThongBao;
import com.example.Cooking.DangNhapActivity;
import com.example.Cooking.R;
import com.example.Cooking.TrangChuActivity;
import com.example.Cooking.databinding.FragmentTaiKhoanBinding;
import com.example.Cooking.databinding.FragmentThongBaoBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotifyFragment extends Fragment {

    private NotifyViewModel notifyViewModel;
    private FragmentThongBaoBinding binding;
    private LinearLayout lnContent;
    List<ThongBao> listTB;
    MonAn monAn = new MonAn();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notifyViewModel =
                new ViewModelProvider(this).get(NotifyViewModel.class);

        binding = FragmentThongBaoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ListView lvThongBao = root.findViewById(R.id.lvThongBao);
        if(TrangChuActivity.userName != null){
            ApiService.apiService.getListThongBaoByUser(TrangChuActivity.userName).enqueue(new Callback<List<ThongBao>>() {
                @Override
                public void onResponse(Call<List<ThongBao>> call, Response<List<ThongBao>> response) {
                    listTB = response.body();
                    NotifyAdapter notifyAdapter = new NotifyAdapter(getActivity(), R.layout.dong_thong_bao, listTB);
                    lvThongBao.setAdapter(notifyAdapter);
                }

                @Override
                public void onFailure(Call<List<ThongBao>> call, Throwable t) {

                }
            });
        }
        else{
            lnContent = root.findViewById(R.id.content);
            lnContent.setVisibility(View.INVISIBLE);
            openDialog(Gravity.CENTER);
        }

        lvThongBao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(listTB.get(position).getStatus() == 0){
                    ThongBao thongBao = listTB.get(position);
                    thongBao.setStatus(1);
                    ApiService.apiService.updateThongBao(thongBao, thongBao.getId()).enqueue(new Callback<ThongBao>() {
                        @Override
                        public void onResponse(Call<ThongBao> call, Response<ThongBao> response) {

                        }

                        @Override
                        public void onFailure(Call<ThongBao> call, Throwable t) {

                        }
                    });

                }
                ApiService.apiService.getMonById(listTB.get(position).getMaMon()).enqueue(new Callback<MonAn>() {
                    @Override
                    public void onResponse(Call<MonAn> call, Response<MonAn> response) {
                        monAn = response.body();
                        Intent intent = new Intent(getActivity(), ChiTietActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("maDM",monAn.getMaDM());
                        bundle.putSerializable("mon",monAn);
                        intent.putExtra("bundle",bundle);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<MonAn> call, Throwable t) {

                    }
                });


            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void openDialog(int gravity) {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_dang_nhap);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);
        // if click outside area, dialog will hide
        if (Gravity.CENTER == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }
        Button btnCancel = dialog.findViewById(R.id.cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrangChuActivity.class);
                startActivity(intent);
            }
        });

        Button btnDangNhap = dialog.findViewById(R.id.submit);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DangNhapActivity.class);
                startActivity(intent);

            }
        });
        dialog.show();
    }
}