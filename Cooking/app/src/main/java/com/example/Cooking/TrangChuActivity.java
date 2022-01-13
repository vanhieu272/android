package com.example.Cooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.LoadDuLieu;
import com.example.Cooking.Class.MonAn;
import com.example.Cooking.Class.User;
import com.example.Cooking.ui.favorite.FavoriteAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.Cooking.databinding.ActivityTrangChuBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrangChuActivity extends AppCompatActivity {

    private ActivityTrangChuBinding binding;
    public static String userName;
    public static User user;
    public static List<String> arrKey = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        binding = ActivityTrangChuBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_yeuthich, R.id.navigation_taikhoan, R.id.navigation_thongbao)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            user = (User) bundle.getSerializable("objectUser");
            userName = user.getUserName();
        }

        if(TrangChuActivity.userName != null){
            ApiService.apiService.getMonYeuThichByUser(TrangChuActivity.userName).enqueue(new Callback<List<MonAn>>() {
                @Override
                public void onResponse(Call<List<MonAn>> call, Response<List<MonAn>> response) {
                    List<MonAn> monAnList = response.body();
                    LoadDuLieu.listYT = monAnList;

                }

                @Override
                public void onFailure(Call<List<MonAn>> call, Throwable t) {

                }
            });
        }


    }

}