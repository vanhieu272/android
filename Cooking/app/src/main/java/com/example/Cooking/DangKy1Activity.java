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


public class DangKy1Activity extends AppCompatActivity {

    private Button btnNext, btnSignIn;
    private EditText txtUsername;
    private EditText txtPassword;
    private EditText txtPassword2nd;
    private User userSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky1);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        txtUsername=(EditText) findViewById(R.id.txtUserLogin);
        txtPassword=(EditText) findViewById(R.id.txtPasswordLogin);
        txtPassword2nd=(EditText) findViewById(R.id.txtRepeatPassword);

        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=txtUsername.getText().toString().trim();
                String password=txtPassword.getText().toString().trim();
                String password2nd=txtPassword2nd.getText().toString().trim();
                if (!username.isEmpty() && !password.isEmpty() && !password2nd.isEmpty()){
                    if (password.equals(password2nd))
                    {
                        clickNext(username, password);
                    }
                    else
                    {
                        Toast.makeText(DangKy1Activity.this, "Xác nhận mật khẩu không chính xác. Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(DangKy1Activity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    Log.e("No full info Error", "Error no full info");
                    return;
                }
            }
        });

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKy1Activity.this,DangNhapActivity.class);
                startActivity(intent);
            }
        });
    }
    private void clickNext(String username, String password){
        ApiService.apiService.getUser(username+"").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                userSignUp = response.body();
                if (userSignUp != null) {
                    Log.e("User account existed", "User account existed");
                    Toast.makeText(DangKy1Activity.this, "User account existed", Toast.LENGTH_SHORT).show();
                }
                if (userSignUp==null)
                {
//                    String txtusername=txtUsername.getText().toString().trim();
//                    String txtpassword=txtPassword.getText().toString().trim();
                    userSignUp=new User();
                    userSignUp.setUserName(username);
                    userSignUp.setPassWord(password);
                    Log.e("User", userSignUp.getUserName()+"");
                    Intent intent = new Intent(DangKy1Activity.this, DangKy2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("objectNewUser", userSignUp);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(DangKy1Activity.this, "Call API Error", Toast.LENGTH_SHORT).show();
                Log.e("API Error", "Call API Error");
            }
        });
    }
}