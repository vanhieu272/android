package com.example.Cooking.ui.account;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.Cooking.API.ApiService;
import com.example.Cooking.Class.IP;
import com.example.Cooking.Class.MD5;
import com.example.Cooking.Class.RealPathUtil;
import com.example.Cooking.Class.User;
import com.example.Cooking.DangNhapActivity;
import com.example.Cooking.DatePicker;
import com.example.Cooking.R;
import com.example.Cooking.TrangChuActivity;
import com.example.Cooking.databinding.FragmentTaiKhoanBinding;
import com.google.android.material.textfield.TextInputEditText;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountFragment extends Fragment {

    private AccountViewModel accountViewModel;
    private FragmentTaiKhoanBinding binding;
    private TextView txtUsername;
    private TextView txtEmail;
    private TextView txtFullname;
    private TextView txtDob;
    private TextView txtGioiTinh;
    private TextView txtSdt;
    private Button btnDangXuat;
    private Button btnDatLai;

    private User user;
    private ImageButton btnEditTen;
    private ImageButton btnEditNgaySinh;
    private ImageButton btnEditGioiTinh;
    private ImageButton btnEditSDT;
    private ImageButton btnEditAnh;
    private View root;
    private LinearLayout lnContent;
    private ImageView imgAva;
    private Uri mUri;


    private int REQUEST_IMAGE = 123;
    private int MY_REQUEST = 111;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);

        binding = FragmentTaiKhoanBinding.inflate(inflater, container, false);
        root = binding.getRoot();


        //mapping
        txtFullname = root.findViewById(R.id.vFullname);
        txtDob = root.findViewById(R.id.vDoB);
        txtGioiTinh = root.findViewById(R.id.vGender);
        txtSdt = root.findViewById(R.id.vPhoneNumber);
        txtUsername = root.findViewById(R.id.vUsername);
        txtEmail = root.findViewById(R.id.vEmail);
        btnDangXuat = root.findViewById(R.id.btnDangXuat);
        btnDatLai = root.findViewById(R.id.btnPass);
        btnEditTen = root.findViewById(R.id.editTen);
        btnEditNgaySinh = root.findViewById(R.id.editNgaySinh);
        btnEditGioiTinh = root.findViewById(R.id.editGioiTinh);
        btnEditSDT = root.findViewById(R.id.editSDT);
        btnEditAnh = root.findViewById(R.id.editAnh);
        imgAva = root.findViewById(R.id.ava);




        //get user
        user = TrangChuActivity.user;

        if(user != null){


            //settext

            txtFullname.setText(user.getHoTen());
            txtDob.setText(user.getNgaySinh());
            txtGioiTinh.setText(user.getGioiTinh());
            txtSdt.setText(user.getSdt());
            txtUsername.setText(user.getUserName());
            txtEmail.setText(user.getEmail());


            //dang xuat
            btnDangXuat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TrangChuActivity.userName = "";
                    TrangChuActivity.user = null;
                    Intent intent = new Intent(root.getContext(),DangNhapActivity.class);
                    startActivity(intent);
                }
            });

            //edit ten
            btnEditTen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openDialog(Gravity.CENTER, R.layout.dialog_change_fullname);
                }
            });

            //edit SDT
            btnEditSDT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog(Gravity.CENTER, R.layout.dialog_change_sdt);
                }
            });

            //edit ngày sinh
            DatePicker datePicker = new DatePicker();
            btnEditNgaySinh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    datePicker.openDatePicker_TextView(root.getContext(), txtDob);
                }
            });

            //edit giới tính
            btnEditGioiTinh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog(Gravity.CENTER, R.layout.dialog_change_gender);
                }
            });

            //edit mật khẩu
            btnDatLai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog(Gravity.CENTER, R.layout.dialog_change_password);
                }
            });

            //set ava
            Glide.with(getContext()).load(IP.localhostHinhAnh+user.getAnh()).into(imgAva);
            //edit anh
            btnEditAnh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M )
                    {
                        return;
                    }
                    if(getContext().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent,REQUEST_IMAGE);
                    }
                    else
                    {
                        String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permission, MY_REQUEST);
                    }
                }
            });
        }
        else{
            lnContent = root.findViewById(R.id.lnContent);
            lnContent.setVisibility(View.INVISIBLE);
            openDialogDangNhap(Gravity.CENTER);
        }

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void openDialog(int gravity, int view){
        final Dialog dialog = new Dialog(root.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);
        // if click outside area, dialog will hide
        if(Gravity.CENTER == gravity){
            dialog.setCancelable(true);
        } else{
            dialog.setCancelable(false);
        }

        //cap nhat ho ten
        if(view == R.layout.dialog_change_fullname){
            EditText edtNewName = (EditText) dialog.findViewById(R.id.newFullname);
            Button btnSubmit = (Button) dialog.findViewById(R.id.submitFullname);
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newName = String.valueOf(edtNewName.getText());
                    if(newName.length()>0){
                        user.setHoTen(newName);
                        updateUser();
                        dialog.dismiss();
                        txtFullname.setText(newName);
                    }
                }
            });
        }

        //cap nhat sdt
        if(view == R.layout.dialog_change_sdt){
            EditText edtNewSDT = (EditText) dialog.findViewById(R.id.newSDT);
            Button btnSubmit = (Button) dialog.findViewById(R.id.submitSDT);
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newSDT = String.valueOf(edtNewSDT.getText());
                    if(newSDT.length()>0){
                        user.setSdt(newSDT);
                        updateUser();
                        dialog.dismiss();
                        txtSdt.setText(newSDT);
                    }
                }
            });
        }

        //cap nhat password
        if(view == R.layout.dialog_change_password){
            TextInputEditText oldPassword = (TextInputEditText) dialog.findViewById(R.id.oldPassword);
            TextInputEditText newPassword = (TextInputEditText) dialog.findViewById(R.id.newPassword);
            Button submit = (Button) dialog.findViewById(R.id.submitPassword);

            oldPassword.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(s.length()==0){
                        oldPassword.setError("Không được để trống");
                    }
                    else{
                        oldPassword.setError(null);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            newPassword.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(s.length()==0){
                        newPassword.setError("Không được để trống");
                    }
                    else{
                        newPassword.setError(null);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String oldPass = String.valueOf(oldPassword.getText());
                    String newPass = String.valueOf(newPassword.getText());

                    if(oldPass.length()!=0 && newPass.length()!=0){
                        String d = MD5.md5(oldPass);
                        if(d.equals(user.getPassWord())){
                            oldPassword.setError(null);
                            user.setPassWord(MD5.md5(newPass));
                            updateUser();
                            dialog.dismiss();
                        }
                        else{
                            oldPassword.setError("Mật khẩu không đúng!");
                        }
                    }
                    else{
                        if(oldPass.length()==0){
                            oldPassword.setError("Không được để trống");
                        }
                        else{
                            newPassword.setError("Không được để trống");
                        }
                    }
                }
            });
        }

        //cap nhat gioi tinh
        if(view == R.layout.dialog_change_gender){
            Spinner spinner = dialog.findViewById(R.id.spinner);
            Button submit = dialog.findViewById(R.id.submitGender);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newGender="";
                    newGender = spinner.getSelectedItem().toString();
                    if(!newGender.equals("Chọn giới tính")){
                        txtGioiTinh.setText(newGender);
                        user.setGioiTinh(newGender);
                        updateUser();
                        dialog.dismiss();

                    }


                }
            });
        }

        //hien thong bao thanh cong
        if(view == R.layout.dialog_success){
            Button btnSubmit = dialog.findViewById(R.id.submit);
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        dialog.show();
    }

    private void updateUser(){
        ApiService.apiService.updateUser(user,user.getId()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    openDialog(Gravity.CENTER, R.layout.dialog_success);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(root.getContext(), "loi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openDialogDangNhap(int gravity) {
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_IMAGE && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            mUri = uri;
            try {
                InputStream inputStream = getContext().getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imgAva.setImageBitmap(bitmap);
                callApiImage();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void callApiImage(){
        String name = user.getUserName();
        RequestBody requestBodyUsername = RequestBody.create(MediaType.parse("*/*"),user.getUserName());

        String realFile = RealPathUtil.getRealPath(getContext(),mUri);
        Log.e("d",realFile);
        File file = new File(realFile);
        RequestBody requestBodyAva = RequestBody.create(MediaType.parse("*/*"),file);
        MultipartBody.Part multipartAva = MultipartBody.Part.createFormData("file",file.getName(),requestBodyAva);
        ApiService.apiService.uploadImage(multipartAva,requestBodyUsername).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
                if(user!=null){
                    Glide.with(getContext()).load(IP.localhostHinhAnh+user.getAnh()).into(imgAva);
                    TrangChuActivity.user = user;
                }
                Toast.makeText(getContext(), "tc", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getContext(), "loi", Toast.LENGTH_SHORT).show();
            }
        });


    }
}