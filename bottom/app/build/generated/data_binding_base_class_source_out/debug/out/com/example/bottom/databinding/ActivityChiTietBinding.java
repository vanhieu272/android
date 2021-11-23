// Generated by view binder compiler. Do not edit!
package com.example.bottom.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.bottom.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityChiTietBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton back;

  @NonNull
  public final TextView editTextTextPersonName;

  @NonNull
  public final TextView editTextTextPersonName2;

  @NonNull
  public final LinearLayout frameLayout;

  @NonNull
  public final ImageView frameLayout2;

  @NonNull
  public final ImageView frameLayout3;

  @NonNull
  public final ImageView frameLayout5;

  @NonNull
  public final LinearLayout nguyelieu;

  @NonNull
  public final TextView tenMon;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final ConstraintLayout tieude;

  private ActivityChiTietBinding(@NonNull LinearLayout rootView, @NonNull ImageButton back,
      @NonNull TextView editTextTextPersonName, @NonNull TextView editTextTextPersonName2,
      @NonNull LinearLayout frameLayout, @NonNull ImageView frameLayout2,
      @NonNull ImageView frameLayout3, @NonNull ImageView frameLayout5,
      @NonNull LinearLayout nguyelieu, @NonNull TextView tenMon, @NonNull TextView textView2,
      @NonNull TextView textView5, @NonNull TextView textView6, @NonNull ConstraintLayout tieude) {
    this.rootView = rootView;
    this.back = back;
    this.editTextTextPersonName = editTextTextPersonName;
    this.editTextTextPersonName2 = editTextTextPersonName2;
    this.frameLayout = frameLayout;
    this.frameLayout2 = frameLayout2;
    this.frameLayout3 = frameLayout3;
    this.frameLayout5 = frameLayout5;
    this.nguyelieu = nguyelieu;
    this.tenMon = tenMon;
    this.textView2 = textView2;
    this.textView5 = textView5;
    this.textView6 = textView6;
    this.tieude = tieude;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityChiTietBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityChiTietBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_chi_tiet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityChiTietBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back;
      ImageButton back = ViewBindings.findChildViewById(rootView, id);
      if (back == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonName;
      TextView editTextTextPersonName = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonName == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonName2;
      TextView editTextTextPersonName2 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonName2 == null) {
        break missingId;
      }

      id = R.id.frameLayout;
      LinearLayout frameLayout = ViewBindings.findChildViewById(rootView, id);
      if (frameLayout == null) {
        break missingId;
      }

      id = R.id.frameLayout2;
      ImageView frameLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (frameLayout2 == null) {
        break missingId;
      }

      id = R.id.frameLayout3;
      ImageView frameLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (frameLayout3 == null) {
        break missingId;
      }

      id = R.id.frameLayout5;
      ImageView frameLayout5 = ViewBindings.findChildViewById(rootView, id);
      if (frameLayout5 == null) {
        break missingId;
      }

      id = R.id.nguyelieu;
      LinearLayout nguyelieu = ViewBindings.findChildViewById(rootView, id);
      if (nguyelieu == null) {
        break missingId;
      }

      id = R.id.tenMon;
      TextView tenMon = ViewBindings.findChildViewById(rootView, id);
      if (tenMon == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.tieude;
      ConstraintLayout tieude = ViewBindings.findChildViewById(rootView, id);
      if (tieude == null) {
        break missingId;
      }

      return new ActivityChiTietBinding((LinearLayout) rootView, back, editTextTextPersonName,
          editTextTextPersonName2, frameLayout, frameLayout2, frameLayout3, frameLayout5, nguyelieu,
          tenMon, textView2, textView5, textView6, tieude);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
