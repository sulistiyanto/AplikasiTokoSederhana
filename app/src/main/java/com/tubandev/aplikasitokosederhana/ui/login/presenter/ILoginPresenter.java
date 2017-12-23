package com.tubandev.aplikasitokosederhana.ui.login.presenter;

import android.util.Log;

import com.tubandev.aplikasitokosederhana.ui.login.view.LoginView;

/**
 * Created by sulistiyanto on 23/12/17.
 */

public class ILoginPresenter implements LoginPresenter {

    private LoginView view;

    public ILoginPresenter(LoginView view) {
        this.view = view;
    }

    @Override
    public void login(String username, String password) {
        Log.d("ds", username);
    }
}
