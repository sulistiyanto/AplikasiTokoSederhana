package com.tubandev.aplikasitokosederhana.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.tubandev.aplikasitokosederhana.R;
import com.tubandev.aplikasitokosederhana.ui.home.MainActivity;
import com.tubandev.aplikasitokosederhana.ui.login.presenter.ILoginPresenter;
import com.tubandev.aplikasitokosederhana.ui.login.presenter.LoginPresenter;
import com.tubandev.aplikasitokosederhana.ui.login.view.LoginView;
import com.tubandev.aplikasitokosederhana.utils.ConnectionNetwork;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;
    private ProgressDialog progressDialog;
    private ConnectionNetwork connectionNetwork;

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
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
        progressDialog = new ProgressDialog(this);
        connectionNetwork = new ConnectionNetwork();
        presenter = new ILoginPresenter(this);

    }

    @OnClick(R.id.btnLogin)
    void btnLogin() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        presenter.login(connectionNetwork.isConnecting(this), username, password);
    }

    @Override
    public void error(String message) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void success(String user) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    @Override
    public void showProgressDialog() {
        progressDialog.setMessage("Mohon tunggu...");
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }
}
