// Generated by view binder compiler. Do not edit!
package com.hanna.makeup4you.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hanna.makeup4you.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddProductsBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final Button btnAdd;

  @NonNull
  public final EditText etPrice;

  @NonNull
  public final EditText etProductName;

  @NonNull
  public final AppCompatImageView ivImage;

  @NonNull
  public final AppCompatImageView ivUpload;

  @NonNull
  public final RelativeLayout rlAdd;

  @NonNull
  public final RelativeLayout rlGone;

  private ActivityAddProductsBinding(@NonNull LinearLayoutCompat rootView, @NonNull Button btnAdd,
      @NonNull EditText etPrice, @NonNull EditText etProductName,
      @NonNull AppCompatImageView ivImage, @NonNull AppCompatImageView ivUpload,
      @NonNull RelativeLayout rlAdd, @NonNull RelativeLayout rlGone) {
    this.rootView = rootView;
    this.btnAdd = btnAdd;
    this.etPrice = etPrice;
    this.etProductName = etProductName;
    this.ivImage = ivImage;
    this.ivUpload = ivUpload;
    this.rlAdd = rlAdd;
    this.rlGone = rlGone;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddProductsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddProductsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_products, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddProductsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAdd;
      Button btnAdd = ViewBindings.findChildViewById(rootView, id);
      if (btnAdd == null) {
        break missingId;
      }

      id = R.id.etPrice;
      EditText etPrice = ViewBindings.findChildViewById(rootView, id);
      if (etPrice == null) {
        break missingId;
      }

      id = R.id.etProductName;
      EditText etProductName = ViewBindings.findChildViewById(rootView, id);
      if (etProductName == null) {
        break missingId;
      }

      id = R.id.ivImage;
      AppCompatImageView ivImage = ViewBindings.findChildViewById(rootView, id);
      if (ivImage == null) {
        break missingId;
      }

      id = R.id.ivUpload;
      AppCompatImageView ivUpload = ViewBindings.findChildViewById(rootView, id);
      if (ivUpload == null) {
        break missingId;
      }

      id = R.id.rlAdd;
      RelativeLayout rlAdd = ViewBindings.findChildViewById(rootView, id);
      if (rlAdd == null) {
        break missingId;
      }

      id = R.id.rlGone;
      RelativeLayout rlGone = ViewBindings.findChildViewById(rootView, id);
      if (rlGone == null) {
        break missingId;
      }

      return new ActivityAddProductsBinding((LinearLayoutCompat) rootView, btnAdd, etPrice,
          etProductName, ivImage, ivUpload, rlAdd, rlGone);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
