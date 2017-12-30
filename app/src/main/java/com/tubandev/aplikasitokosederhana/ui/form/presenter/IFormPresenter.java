package com.tubandev.aplikasitokosederhana.ui.form.presenter;

import android.view.MenuItem;

import com.tubandev.aplikasitokosederhana.ui.form.view.FormView;

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
}
