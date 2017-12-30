package com.tubandev.aplikasitokosederhana.ui.login.presenter;


import com.tubandev.aplikasitokosederhana.model.Result;
import com.tubandev.aplikasitokosederhana.network.API;
import com.tubandev.aplikasitokosederhana.network.APIClient;
import com.tubandev.aplikasitokosederhana.ui.login.view.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sulistiyanto on 23/12/17.
 */

public class ILoginPresenter implements LoginPresenter {

    private LoginView view;

    public ILoginPresenter(LoginView view) {
        this.view = view;
    }

    @Override
    public void login(boolean connecting, final String username, String password) {
        if (connecting) {
            view.showProgressDialog();
            API api = APIClient.getService();
            Call<Result> call = api.login(username, password);
            call.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    view.hideProgressDialog();
                    boolean error = response.body().getError();
                    if (error) {
                        String msg = response.body().getError_msg();
                        view.error(msg);
                    } else {
                        view.success(username);
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
