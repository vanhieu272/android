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
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.Cooking.DangNhapActivity;
import com.example.Cooking.R;
import com.example.Cooking.TrangChuActivity;
import com.example.Cooking.databinding.FragmentTaiKhoanBinding;
import com.example.Cooking.databinding.FragmentThongBaoBinding;

public class NotifyFragment extends Fragment {

    private NotifyViewModel notifyViewModel;
    private FragmentThongBaoBinding binding;
    private LinearLayout lnContent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notifyViewModel =
                new ViewModelProvider(this).get(NotifyViewModel.class);

        binding = FragmentThongBaoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if(TrangChuActivity.userName != null){

        }
        else{
            lnContent = root.findViewById(R.id.content);
            lnContent.setVisibility(View.INVISIBLE);
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