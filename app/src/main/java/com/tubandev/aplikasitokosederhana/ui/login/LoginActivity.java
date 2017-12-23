package com.tubandev.aplikasitokosederhana.ui.login;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.tubandev.aplikasitokosederhana.R;
import com.tubandev.aplikasitokosederhana.ui.login.presenter.ILoginPresenter;
import com.tubandev.aplikasitokosederhana.ui.login.presenter.LoginPresenter;
import com.tubandev.aplikasitokosederhana.ui.login.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etPassword)
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        presenter = new ILoginPresenter(this);

    }

    @OnClick(R.id.btnLogin)
    void btnLogin() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        presenter.login(username, password);
    }
}
