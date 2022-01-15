// Generated by view binder compiler. Do not edit!
package com.example.bottom.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.bottom.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentThongBaoBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView LauBo;

  @NonNull
  public final ImageView LauHaiSan;

  @NonNull
  public final ImageView LauHaiSan2;

  @NonNull
  public final LinearLayout lnThongbao;

  @NonNull
  public final RelativeLayout thongbao;

  private FragmentThongBaoBinding(@NonNull LinearLayout rootView, @NonNull ImageView LauBo,
      @NonNull ImageView LauHaiSan, @NonNull ImageView LauHaiSan2, @NonNull LinearLayout lnThongbao,
      @NonNull RelativeLayout thongbao) {
    this.rootView = rootView;
    this.LauBo = LauBo;
    this.LauHaiSan = LauHaiSan;
    this.LauHaiSan2 = LauHaiSan2;
    this.lnThongbao = lnThongbao;
    this.thongbao = thongbao;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentThongBaoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentThongBaoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_thong_bao, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentThongBaoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.LauBo;
      ImageView LauBo = ViewBindings.findChildViewById(rootView, id);
      if (LauBo == null) {
        break missingId;
      }

      id = R.id.LauHaiSan;
      ImageView LauHaiSan = ViewBindings.findChildViewById(rootView, id);
      if (LauHaiSan == null) {
        break missingId;
      }

      id = R.id.LauHaiSan2;
      ImageView LauHaiSan2 = ViewBindings.findChildViewById(rootView, id);
      if (LauHaiSan2 == null) {
        break missingId;
      }

      LinearLayout lnThongbao = (LinearLayout) rootView;

      id = R.id.thongbao;
      RelativeLayout thongbao = ViewBindings.findChildViewById(rootView, id);
      if (thongbao == null) {
        break missingId;
      }

      return new FragmentThongBaoBinding((LinearLayout) rootView, LauBo, LauHaiSan, LauHaiSan2,
          lnThongbao, thongbao);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}