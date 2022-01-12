package com.example.Cooking.ui.favorite;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.LoadDuLieu;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.Class.YeuThich;
import com.example.Cooking.DangNhapActivity;
import com.example.Cooking.R;
import com.example.Cooking.TimKiemActivity;
import com.example.Cooking.TrangChuActivity;
import com.example.Cooking.danhMucConActivity;
import com.example.Cooking.danhMucConAdapter;
import com.example.Cooking.databinding.FragmentYeuThichBinding;
import com.example.Cooking.ui.home.HomeFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteFragment extends Fragment {

    private FavoriteViewModel favoriteViewModel;
    private FragmentYeuThichBinding binding;
    private ImageButton imgBtSearch;
    public   static ListView listView;
    public static List<MonAn> monAnList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoriteViewModel =
                new ViewModelProvider(this).get(FavoriteViewModel.class);

        binding = FragmentYeuThichBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //start button search
        imgBtSearch = root.findViewById(R.id.imgBtSearch);
        imgBtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), TimKiemActivity.class);
                Bundle bundle=new Bundle();
                bundle.putBoolean("kt",true);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        //end button search

        //get List yeu thich
        

        //Call API yeu thich
        if(TrangChuActivity.userName != null){
            ApiService.apiService.getMonYeuThichByUser(TrangChuActivity.userName).enqueue(new Callback<List<MonAn>>() {
                @Override
                public void onResponse(Call<List<MonAn>> call, Response<List<MonAn>> response) {
                    monAnList = response.body();
                    LoadDuLieu.listYT = monAnList;
                    listView = root.findViewById(R.id.listYeuThich);
                    FavoriteAdapter favoriteAdapter = new FavoriteAdapter(getActivity(),R.layout.dong_yeu_thich,monAnList);
                    listView.setAdapter(favoriteAdapter);

//                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            CheckBox checkBox = view.findViewById(R.id.checkboxYeuThich);
//                            if (checkBox.isChecked()){
//                                listView.removeView(view);
//                            }
//                        }
//                    });
                }

                @Override
                public void onFailure(Call<List<MonAn>> call, Throwable t) {

                }
            });
        }
        else {
            openDialog(Gravity.CENTER);
        }

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