// Generated by view binder compiler. Do not edit!
package com.hanna.makeup4you.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hanna.makeup4you.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ListProductsBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button btnCart;

  @NonNull
  public final CardView cvImage;

  @NonNull
  public final RelativeLayout cvMain;

  @NonNull
  public final ImageView ivDelete;

  @NonNull
  public final ImageView ivEdit;

  @NonNull
  public final ImageView ivImage;

  @NonNull
  public final RelativeLayout rlEnd;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvPrice;

  private ListProductsBinding(@NonNull CardView rootView, @NonNull Button btnCart,
      @NonNull CardView cvImage, @NonNull RelativeLayout cvMain, @NonNull ImageView ivDelete,
      @NonNull ImageView ivEdit, @NonNull ImageView ivImage, @NonNull RelativeLayout rlEnd,
      @NonNull TextView tvName, @NonNull TextView tvPrice) {
    this.rootView = rootView;
    this.btnCart = btnCart;
    this.cvImage = cvImage;
    this.cvMain = cvMain;
    this.ivDelete = ivDelete;
    this.ivEdit = ivEdit;
    this.ivImage = ivImage;
    this.rlEnd = rlEnd;
    this.tvName = tvName;
    this.tvPrice = tvPrice;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ListProductsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListProductsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.list_products, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListProductsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCart;
      Button btnCart = ViewBindings.findChildViewById(rootView, id);
      if (btnCart == null) {
        break missingId;
      }

      id = R.id.cvImage;
      CardView cvImage = ViewBindings.findChildViewById(rootView, id);
      if (cvImage == null) {
        break missingId;
      }

      id = R.id.cvMain;
      RelativeLayout cvMain = ViewBindings.findChildViewById(rootView, id);
      if (cvMain == null) {
        break missingId;
      }

      id = R.id.ivDelete;
      ImageView ivDelete = ViewBindings.findChildViewById(rootView, id);
      if (ivDelete == null) {
        break missingId;
      }

      id = R.id.ivEdit;
      ImageView ivEdit = ViewBindings.findChildViewById(rootView, id);
      if (ivEdit == null) {
        break missingId;
      }

      id = R.id.ivImage;
      ImageView ivImage = ViewBindings.findChildViewById(rootView, id);
      if (ivImage == null) {
        break missingId;
      }

      id = R.id.rlEnd;
      RelativeLayout rlEnd = ViewBindings.findChildViewById(rootView, id);
      if (rlEnd == null) {
        break missingId;
      }

      id = R.id.tvName;
      TextView tvName = ViewBindings.findChildViewById(rootView, id);
      if (tvName == null) {
        break missingId;
      }

      id = R.id.tvPrice;
      TextView tvPrice = ViewBindings.findChildViewById(rootView, id);
      if (tvPrice == null) {
        break missingId;
      }

      return new ListProductsBinding((CardView) rootView, btnCart, cvImage, cvMain, ivDelete,
          ivEdit, ivImage, rlEnd, tvName, tvPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}