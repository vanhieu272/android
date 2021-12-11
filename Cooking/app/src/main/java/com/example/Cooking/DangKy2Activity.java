package com.example.Cooking;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DangKy2Activity extends AppCompatActivity {

    private Button btnSignIn, btnSignUp;
    private EditText txtFirstName, txtLastName, txtDob, txtPhone, txtEmail;
    private User userSignUp;
//    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky2);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnSignIn = findViewById(R.id.btnSignIn);
        txtFirstName=(EditText) findViewById(R.id.txtFirstName);
        txtLastName=(EditText) findViewById(R.id.txtLastName);
        txtDob=(EditText) findViewById(R.id.txtDoB);
        txtPhone=(EditText) findViewById(R.id.txtSDT);
        txtEmail=(EditText) findViewById(R.id.txtEmail);
        btnSignUp=(Button) findViewById(R.id.btnSignUp);

        Bundle bundle=getIntent().getExtras();
        if (bundle!=null)
        {
            User user=new User();
            Log.e("User not null", "User not null");
            user= (User) bundle.get("objectNewUser");
            if (user!=null){
                userSignUp=user;
                Log.e("User transfer", userSignUp.getUserName()+" "+ userSignUp.getPassWord());
            }
        }
        else{
            Log.e("User null", "User null");
        }
        txtDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickDate();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("User", userSignUp.getUserName()+" "+userSignUp.getPassWord());
                String lastname = txtLastName.getText().toString()+" ";
                String firstname=txtFirstName.getText().toString();
                String txtdob= txtDob.getText().toString();
                Date dob=new Date(txtdob);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String Dob = formatter.format(dob);
//                Date DateOB= null;
//                try {
//                    DateOB = new SimpleDateFormat("MM/dd/yyyy").parse(dob);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
                String phone=txtPhone.getText().toString();
                String email=txtEmail.getText().toString();
                String hoten=lastname.concat(firstname);
//                userSignUp.setId(null);
                userSignUp.setHoTen(hoten);
                userSignUp.setEmail(email);
                userSignUp.setSdt(phone);
                userSignUp.setNgaySinh(Dob);
//                userSignUp.setAnh("");
//                userSignUp.setGioiTinh("");
                userSignUp.setStatus(1);
                Log.e("User SignUp",userSignUp.getUserName()+" "+userSignUp.getHoTen());
                clickSignUp(userSignUp);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKy2Activity.this,DangNhapActivity.class);
                startActivity(intent);
            }
        });
    }
    private void clickSignUp(User newUser)
    {
        ApiService.apiService.registerUser(newUser).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e("Register", newUser.getUserName()+" "+newUser.getPassWord());
                User user = response.body();
                Log.e("Error register", response.message()+" ");
                if (response.isSuccessful())
                {
                    Toast.makeText(DangKy2Activity.this, "Đăng ký thành công. Vui lòng đăng nhập để tiếp tục", Toast.LENGTH_SHORT).show();
                    Log.e("Register", "Register successful");
                    Intent intent=new Intent(DangKy2Activity.this, DangNhapActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(DangKy2Activity.this, "Đăng ký k thành công", Toast.LENGTH_SHORT).show();
                    Log.e("Register not success", "Register is not successful"+" "+newUser.getUserName());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(DangKy2Activity.this, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                Log.e("API Error", "Register Error");
            }
        });
    }
    private void PickDate(){
        final Calendar calendar=Calendar.getInstance();
        int ngay=calendar.get(Calendar.DATE);
        int thang=calendar.get(Calendar.MONTH);
        int nam=calendar.get(Calendar.YEAR);
        DatePickerDialog datePick=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/yyyy");
                txtDob.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        datePick.show();
    }
}