package com.tubandev.aplikasitokosederhana.ui.home.presenter;

import com.tubandev.aplikasitokosederhana.model.Barang;
import com.tubandev.aplikasitokosederhana.model.Result;
import com.tubandev.aplikasitokosederhana.network.API;
import com.tubandev.aplikasitokosederhana.network.APIClient;
import com.tubandev.aplikasitokosederhana.ui.home.AdapterBarang;
import com.tubandev.aplikasitokosederhana.ui.home.view.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sulistiyanto on 30/12/17.
 */

public class IMainPresenter implements MainPresenter {

    private MainView view;

    public IMainPresenter(MainView view) {
        this.view = view;
    }

    @Override
    public void loadData(boolean connecting) {
        if (connecting) {
            view.showProgressDialog();
            API api = APIClient.getService();
            Call<Result> call = api.loadData();
            call.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    view.hideProgressDialog();
                    boolean error = response.body().getError();
                    if (error) {
                        view.error("Service tidak dapat diakses, silahkan coba beberapa saat lagi");
                    } else {
                        List<Barang> barangList = response.body().getBarang();
                        if (barangList.size() > 0) {
                            AdapterBarang adapterBarang = new AdapterBarang(barangList);
                            view.showData(adapterBarang);
                        } else {
                            view.emptyData();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    t.printStackTrace();
                    view.hideProgressDialog();
                    view.error("Service tidak dapat diakses, silahkan coba beberapa saat lagi");
                }
            });
        } else {
            view.error("Tidak ada koneksi internet");
        }
    }
}
