package com.example.Cooking.ui.favorite;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.LoadDuLieu;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.Class.YeuThich;
import com.example.Cooking.R;
import com.example.Cooking.TimKiemActivity;
import com.example.Cooking.TrangChuActivity;
import com.example.Cooking.danhMucConActivity;
import com.example.Cooking.danhMucConAdapter;
import com.example.Cooking.databinding.FragmentYeuThichBinding;

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
                    List<MonAn> monAnList = response.body();
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
            Toast.makeText(getActivity(), "Vui long dang nhap", Toast.LENGTH_SHORT).show();
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}