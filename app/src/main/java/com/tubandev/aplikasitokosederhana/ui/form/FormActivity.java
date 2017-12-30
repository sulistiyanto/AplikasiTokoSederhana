package com.tubandev.aplikasitokosederhana.ui.form;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

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

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etStock)
    EditText etStock;
    @BindView(R.id.etSupplier)
    EditText etSupplier;
    @BindView(R.id.etDesc)
    EditText etDesc;

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

    @Override
    public void success() {
        finish();
    }

    @OnClick(R.id.btnSave)
    void btnSave() {
        String name = etName.getText().toString();
        String stock = etStock.getText().toString();
        String supplier = etSupplier.getText().toString();
        String desc = etDesc.getText().toString();
        presenter.saveData(connectionNetwork.isConnecting(this), name, stock, supplier, desc);
    }

    @Override
    public void error(String message) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT).show();
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
