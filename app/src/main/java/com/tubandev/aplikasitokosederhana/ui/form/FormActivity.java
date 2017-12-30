package com.tubandev.aplikasitokosederhana.ui.form;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.tubandev.aplikasitokosederhana.R;
import com.tubandev.aplikasitokosederhana.ui.form.presenter.FormPresenter;
import com.tubandev.aplikasitokosederhana.ui.form.presenter.IFormPresenter;
import com.tubandev.aplikasitokosederhana.ui.form.view.FormView;
import com.tubandev.aplikasitokosederhana.utils.ConnectionNetwork;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FormActivity extends AppCompatActivity implements FormView {

    private FormPresenter presenter;
    private ProgressDialog progressDialog;
    private ConnectionNetwork connectionNetwork;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Form Barang");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressDialog = new ProgressDialog(this);
        connectionNetwork = new ConnectionNetwork();
        presenter = new IFormPresenter(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        presenter.backHome(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void back() {
        finish();
    }

    @OnClick(R.id.btnSave)
    void btnSave() {

    }

    @Override
    public void error(String message) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }
}
