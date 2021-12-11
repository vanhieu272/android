package com.example.Cooking;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DangNhapActivity extends AppCompatActivity {

    private Button btnVaoNgay, btnSignUp;
    private Button btnSignIn;
    private EditText txtUser;
    private EditText txtPassword;
//    private User userSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txtUser = (EditText) findViewById(R.id.txtUserLogin);
        txtPassword = (EditText) findViewById(R.id.txtPasswordLogin);
        btnSignIn = (Button) findViewById(R.id.btnSigninLogin);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUser.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                if (!username.isEmpty() && !password.isEmpty())
                {
                    User loginUser=new User();
                    loginUser.setUserName(username);
                    loginUser.setPassWord(password);
                    Log.e("User",  " " +loginUser.getPassWord());
                    clickLogin(loginUser);
                }
                else{
                    Toast.makeText(DangNhapActivity.this, "Vui lòng nhập tên đăng nhập và mật khẩu", Toast.LENGTH_SHORT).show();
                    Log.e("API Error", "username or password null");
                    return;
                }
            }
        });


        btnVaoNgay = findViewById(R.id.btnVaoNgay);
        btnVaoNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhapActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DangNhapActivity.this, DangKy1Activity.class);
                startActivity(intent);

            }
        });
    }

    private void clickLogin(User UserLogin) {
        ApiService.apiService.loginUser(UserLogin).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if (user == null) {
                    Toast.makeText(DangNhapActivity.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                    Log.e("No User", "User is null");
                    return;
                }
                boolean isHasUser = true;
//                if (UserLogin.getPassWord().trim().equals(user.getPassWord())) {
//                    isHasUser = true;
//                }
                if (isHasUser) {
                    Log.e("User", user.getUserName() + " " +user.getPassWord());
                    Intent intent = new Intent(DangNhapActivity.this, TrangChuActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("objectUser", user);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    Toast.makeText(DangNhapActivity.this, "Mật khẩu không hợp lệ", Toast.LENGTH_SHORT).show();
                    Log.e("User",  " " +user.getPassWord());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
//                Toast.makeText(DangNhapActivity.this, "Call API Error", Toast.LENGTH_SHORT).show();
                Toast.makeText(DangNhapActivity.this, "Mật khẩu không hợp lệ", Toast.LENGTH_SHORT).show();
                Log.e("API Error", "Call API Error. Mật khẩu k hợp lệ");
            }
        });
//        ApiService.apiService.getUser(loginUser).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user = response.body();
//                if (user == null) {
//                    Toast.makeText(DangNhapActivity.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
//                    Log.e("No User", "User is null");
//                    return;
//                }
//                boolean isHasUser = false;
//                if (loginUser.getPassWord().trim().equals(user.getPassWord())) {
//                    isHasUser = true;
//                }
//                else
//                {
//                    Toast.makeText(DangNhapActivity.this, "Mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
//                }
//                if (isHasUser) {
//                    Log.e("User", user.getUserName() + " " +user.getPassWord());
//                    Intent intent = new Intent(DangNhapActivity.this, TrangChuActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("objectUser", user);
//                    intent.putExtras(bundle);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(DangNhapActivity.this, "Mật khẩu không hợp lệ", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Toast.makeText(DangNhapActivity.this, "Call API Error", Toast.LENGTH_SHORT).show();
//                Log.e("API Error", "Call API Error");
//            }
//        });
    }
//    private void clickLogin(String username, String password) {
//        Log.e("UserInfo",user.getUserName()+" "+user.getPassWord());
//        if (user == null) {
//            Log.e("No User", "User is null");
//            return;
//        }
//        boolean isHasUser = false;
//        if (password.trim().equals(user.getPassWord())) {
//            isHasUser = true;
//        }
//        if (isHasUser) {
//            Intent intent = new Intent(DangNhapActivity.this, TrangChuActivity.class);
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("objectUser", user);
//            intent.putExtras(bundle);
//            startActivity(intent);
//        } else {
//            Toast.makeText(DangNhapActivity.this, "Mật khẩu không hợp lệ", Toast.LENGTH_SHORT).show();
//        }
//    }
//    private void getUser(){
//        ApiService.apiService.getUser().enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                listUser=response.body();
//                Log.e("List User", listUser.size()+"");
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//                Toast.makeText(DangNhapActivity.this, "Call API Error", Toast.LENGTH_SHORT).show();
//                Log.e("API Error", "Call API Error");
//            }
//        });
//    }
}