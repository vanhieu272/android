package com.example.Cooking;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.User;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatePicker {

    private User user = TrangChuActivity.user;;
    Calendar calendar = Calendar.getInstance();
    public int dayOfMonth = calendar.get(calendar.DATE);
    public int month = calendar.get(calendar.MONTH);
    public int year = calendar.get(calendar.YEAR);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void openDatePicker(Context mcontext, TextInputEditText mtext){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                mcontext,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        mtext.setText("");
                        mtext.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                },
                year,month,dayOfMonth );
        datePickerDialog.show();
    }
    public void openDatePicker_TextView(Context mcontext, TextView mtext){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                mcontext,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        mtext.setText("");
                        mtext.setText(simpleDateFormat.format(calendar.getTime()));
                        user.setNgaySinh(String.valueOf(mtext.getText()));
                        updateUser();
                    }
                },
                year,month,dayOfMonth );
        datePickerDialog.show();
    }

    private void updateUser(){
        ApiService.apiService.updateUser(user,user.getId()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    //openDialog(Gravity.CENTER, R.layout.dialog_success);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //Toast.makeText(root.getContext(), "loi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
