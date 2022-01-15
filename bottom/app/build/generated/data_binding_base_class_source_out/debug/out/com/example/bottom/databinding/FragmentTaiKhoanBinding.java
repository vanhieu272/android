// Generated by view binder compiler. Do not edit!
package com.example.bottom.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.bottom.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentTaiKhoanBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton editAnh;

  @NonNull
  public final ImageButton editGioiTinh;

  @NonNull
  public final ImageButton editNgaySinh;

  @NonNull
  public final ImageButton editSDT;

  @NonNull
  public final ImageButton editTen;

  @NonNull
  public final LinearLayout lnTaiKhoan;

  private FragmentTaiKhoanBinding(@NonNull LinearLayout rootView, @NonNull ImageButton editAnh,
      @NonNull ImageButton editGioiTinh, @NonNull ImageButton editNgaySinh,
      @NonNull ImageButton editSDT, @NonNull ImageButton editTen,
      @NonNull LinearLayout lnTaiKhoan) {
    this.rootView = rootView;
    this.editAnh = editAnh;
    this.editGioiTinh = editGioiTinh;
    this.editNgaySinh = editNgaySinh;
    this.editSDT = editSDT;
    this.editTen = editTen;
    this.lnTaiKhoan = lnTaiKhoan;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentTaiKhoanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentTaiKhoanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_tai_khoan, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentTaiKhoanBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.editAnh;
      ImageButton editAnh = ViewBindings.findChildViewById(rootView, id);
      if (editAnh == null) {
        break missingId;
      }

      id = R.id.editGioiTinh;
      ImageButton editGioiTinh = ViewBindings.findChildViewById(rootView, id);
      if (editGioiTinh == null) {
        break missingId;
      }

      id = R.id.editNgaySinh;
      ImageButton editNgaySinh = ViewBindings.findChildViewById(rootView, id);
      if (editNgaySinh == null) {
        break missingId;
      }

      id = R.id.editSDT;
      ImageButton editSDT = ViewBindings.findChildViewById(rootView, id);
      if (editSDT == null) {
        break missingId;
      }

      id = R.id.editTen;
      ImageButton editTen = ViewBindings.findChildViewById(rootView, id);
      if (editTen == null) {
        break missingId;
      }

      LinearLayout lnTaiKhoan = (LinearLayout) rootView;

      return new FragmentTaiKhoanBinding((LinearLayout) rootView, editAnh, editGioiTinh,
          editNgaySinh, editSDT, editTen, lnTaiKhoan);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}