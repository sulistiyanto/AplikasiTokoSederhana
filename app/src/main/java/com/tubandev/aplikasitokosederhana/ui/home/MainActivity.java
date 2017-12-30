package com.tubandev.aplikasitokosederhana.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tubandev.aplikasitokosederhana.R;
import com.tubandev.aplikasitokosederhana.ui.form.FormActivity;
import com.tubandev.aplikasitokosederhana.ui.home.presenter.IMainPresenter;
import com.tubandev.aplikasitokosederhana.ui.home.presenter.MainPresenter;
import com.tubandev.aplikasitokosederhana.ui.home.view.MainView;
import com.tubandev.aplikasitokosederhana.utils.ConnectionNetwork;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;
    private ConnectionNetwork connectionNetwork;

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txtEmpty)
    TextView txtEmpty;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        presenter = new IMainPresenter(this);
        connectionNetwork = new ConnectionNetwork();

        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        getSupportActionBar().setSubtitle(user);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        presenter.loadData(connectionNetwork.isConnecting(this));
    }

    @OnClick(R.id.fab)
    void fab() {
        startActivity(new Intent(this, FormActivity.class));
    }

    @Override
    public void error(String message) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressDialog() {
        progressBar.setVisibility(View.VISIBLE);
        txtEmpty.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressDialog() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadData(connectionNetwork.isConnecting(this));
    }

    @Override
    public void showData(AdapterBarang adapterBarang) {
        txtEmpty.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setAdapter(adapterBarang);
    }

    @Override
    public void emptyData() {
        txtEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }
}
