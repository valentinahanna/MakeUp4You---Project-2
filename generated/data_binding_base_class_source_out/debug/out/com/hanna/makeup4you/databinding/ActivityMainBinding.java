// Generated by view binder compiler. Do not edit!
package com.hanna.makeup4you.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hanna.makeup4you.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView makeup4youLabelTextview;

  @NonNull
  public final EditText passwordInputEdittext;

  @NonNull
  public final Button signinConvertButtom;

  @NonNull
  public final EditText usernameInputEdittext;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView makeup4youLabelTextview, @NonNull EditText passwordInputEdittext,
      @NonNull Button signinConvertButtom, @NonNull EditText usernameInputEdittext) {
    this.rootView = rootView;
    this.makeup4youLabelTextview = makeup4youLabelTextview;
    this.passwordInputEdittext = passwordInputEdittext;
    this.signinConvertButtom = signinConvertButtom;
    this.usernameInputEdittext = usernameInputEdittext;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.makeup4you_label_textview;
      TextView makeup4youLabelTextview = ViewBindings.findChildViewById(rootView, id);
      if (makeup4youLabelTextview == null) {
        break missingId;
      }

      id = R.id.password_input_edittext;
      EditText passwordInputEdittext = ViewBindings.findChildViewById(rootView, id);
      if (passwordInputEdittext == null) {
        break missingId;
      }

      id = R.id.signin_convert_buttom;
      Button signinConvertButtom = ViewBindings.findChildViewById(rootView, id);
      if (signinConvertButtom == null) {
        break missingId;
      }

      id = R.id.username_input_edittext;
      EditText usernameInputEdittext = ViewBindings.findChildViewById(rootView, id);
      if (usernameInputEdittext == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, makeup4youLabelTextview,
          passwordInputEdittext, signinConvertButtom, usernameInputEdittext);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
