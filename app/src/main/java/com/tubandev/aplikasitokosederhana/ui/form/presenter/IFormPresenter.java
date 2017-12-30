package com.tubandev.aplikasitokosederhana.ui.form.presenter;

import android.view.MenuItem;

import com.tubandev.aplikasitokosederhana.model.Result;
import com.tubandev.aplikasitokosederhana.network.API;
import com.tubandev.aplikasitokosederhana.network.APIClient;
import com.tubandev.aplikasitokosederhana.ui.form.view.FormView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sulistiyanto on 30/12/17.
 */

public class IFormPresenter implements FormPresenter {

    private FormView view;

    public IFormPresenter(FormView view) {
        this.view = view;
    }

    @Override
    public void backHome(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                view.back();
                break;
        }
    }

    @Override
    public void saveData(boolean connecting, String name, String stock, String supplier, String desc) {
        if (connecting) {
            if (name.equals("")) {
                view.error("Isi nama barang");
            } else if (stock.equals("")) {
                view.error("Isi stok barang");
            } else if (supplier.equals("")) {
                view.error("Isi pemasok barang");
            } else {
                view.showProgressDialog();
                API api = APIClient.getService();
                Call<Result> call = api.save(name, stock, supplier, desc);
                call.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        view.hideProgressDialog();
                        boolean error = response.body().getError();
                        if (error) {
                            String msg = response.body().getError_msg();
                            view.error(msg);
                        } else {
                            view.success();
                        }
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        t.printStackTrace();
                        view.hideProgressDialog();
                        view.error("Service tidak dapat diakses, silahkan coba beberapa saat lagi");
                    }
                });
            }
        } else {
            view.error("Tidak ada koneksi internet");
        }
    }
}
