// Generated by view binder compiler. Do not edit!
package com.hanna.makeup4you.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hanna.makeup4you.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLandingBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final AppCompatButton btnLogout;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final FloatingActionButton fabCart;

  @NonNull
  public final RecyclerView rvItems;

  @NonNull
  public final SearchView searchView;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvNoDataFound;

  private ActivityLandingBinding(@NonNull RelativeLayout rootView,
      @NonNull AppCompatButton btnLogout, @NonNull FloatingActionButton fab,
      @NonNull FloatingActionButton fabCart, @NonNull RecyclerView rvItems,
      @NonNull SearchView searchView, @NonNull TextView tvName, @NonNull TextView tvNoDataFound) {
    this.rootView = rootView;
    this.btnLogout = btnLogout;
    this.fab = fab;
    this.fabCart = fabCart;
    this.rvItems = rvItems;
    this.searchView = searchView;
    this.tvName = tvName;
    this.tvNoDataFound = tvNoDataFound;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLandingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLandingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_landing, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLandingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnLogout;
      AppCompatButton btnLogout = ViewBindings.findChildViewById(rootView, id);
      if (btnLogout == null) {
        break missingId;
      }

      id = R.id.fab;
      FloatingActionButton fab = ViewBindings.findChildViewById(rootView, id);
      if (fab == null) {
        break missingId;
      }

      id = R.id.fabCart;
      FloatingActionButton fabCart = ViewBindings.findChildViewById(rootView, id);
      if (fabCart == null) {
        break missingId;
      }

      id = R.id.rvItems;
      RecyclerView rvItems = ViewBindings.findChildViewById(rootView, id);
      if (rvItems == null) {
        break missingId;
      }

      id = R.id.searchView;
      SearchView searchView = ViewBindings.findChildViewById(rootView, id);
      if (searchView == null) {
        break missingId;
      }

      id = R.id.tvName;
      TextView tvName = ViewBindings.findChildViewById(rootView, id);
      if (tvName == null) {
        break missingId;
      }

      id = R.id.tvNoDataFound;
      TextView tvNoDataFound = ViewBindings.findChildViewById(rootView, id);
      if (tvNoDataFound == null) {
        break missingId;
      }

      return new ActivityLandingBinding((RelativeLayout) rootView, btnLogout, fab, fabCart, rvItems,
          searchView, tvName, tvNoDataFound);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
