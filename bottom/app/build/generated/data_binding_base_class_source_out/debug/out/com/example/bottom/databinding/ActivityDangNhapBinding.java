// Generated by view binder compiler. Do not edit!
package com.example.bottom.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.bottom.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDangNhapBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnSignUp;

  @NonNull
  public final Button btnSignin;

  @NonNull
  public final Button btnVaoNgay;

  @NonNull
  public final LinearLayout lnDangKy;

  @NonNull
  public final EditText txtPassword;

  @NonNull
  public final EditText txtUser;

  @NonNull
  public final RelativeLayout txtUserPass;

  @NonNull
  public final ImageView vIcon;

  @NonNull
  public final RelativeLayout vTitle;

  @NonNull
  public final TextView vWelcome;

  private ActivityDangNhapBinding(@NonNull RelativeLayout rootView, @NonNull Button btnSignUp,
      @NonNull Button btnSignin, @NonNull Button btnVaoNgay, @NonNull LinearLayout lnDangKy,
      @NonNull EditText txtPassword, @NonNull EditText txtUser, @NonNull RelativeLayout txtUserPass,
      @NonNull ImageView vIcon, @NonNull RelativeLayout vTitle, @NonNull TextView vWelcome) {
    this.rootView = rootView;
    this.btnSignUp = btnSignUp;
    this.btnSignin = btnSignin;
    this.btnVaoNgay = btnVaoNgay;
    this.lnDangKy = lnDangKy;
    this.txtPassword = txtPassword;
    this.txtUser = txtUser;
    this.txtUserPass = txtUserPass;
    this.vIcon = vIcon;
    this.vTitle = vTitle;
    this.vWelcome = vWelcome;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDangNhapBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDangNhapBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_dang_nhap, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDangNhapBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnSignUp;
      Button btnSignUp = ViewBindings.findChildViewById(rootView, id);
      if (btnSignUp == null) {
        break missingId;
      }

      id = R.id.btnSignin;
      Button btnSignin = ViewBindings.findChildViewById(rootView, id);
      if (btnSignin == null) {
        break missingId;
      }

      id = R.id.btnVaoNgay;
      Button btnVaoNgay = ViewBindings.findChildViewById(rootView, id);
      if (btnVaoNgay == null) {
        break missingId;
      }

      id = R.id.lnDangKy;
      LinearLayout lnDangKy = ViewBindings.findChildViewById(rootView, id);
      if (lnDangKy == null) {
        break missingId;
      }

      id = R.id.txtPassword;
      EditText txtPassword = ViewBindings.findChildViewById(rootView, id);
      if (txtPassword == null) {
        break missingId;
      }

      id = R.id.txtUser;
      EditText txtUser = ViewBindings.findChildViewById(rootView, id);
      if (txtUser == null) {
        break missingId;
      }

      id = R.id.txtUserPass;
      RelativeLayout txtUserPass = ViewBindings.findChildViewById(rootView, id);
      if (txtUserPass == null) {
        break missingId;
      }

      id = R.id.vIcon;
      ImageView vIcon = ViewBindings.findChildViewById(rootView, id);
      if (vIcon == null) {
        break missingId;
      }

      id = R.id.vTitle;
      RelativeLayout vTitle = ViewBindings.findChildViewById(rootView, id);
      if (vTitle == null) {
        break missingId;
      }

      id = R.id.vWelcome;
      TextView vWelcome = ViewBindings.findChildViewById(rootView, id);
      if (vWelcome == null) {
        break missingId;
      }

      return new ActivityDangNhapBinding((RelativeLayout) rootView, btnSignUp, btnSignin,
          btnVaoNgay, lnDangKy, txtPassword, txtUser, txtUserPass, vIcon, vTitle, vWelcome);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}