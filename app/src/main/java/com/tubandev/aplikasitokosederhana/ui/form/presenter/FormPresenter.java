package com.tubandev.aplikasitokosederhana.ui.form.presenter;

import android.view.MenuItem;

/**
 * Created by sulistiyanto on 30/12/17.
 */

public interface FormPresenter {
    void backHome(MenuItem item);
    void saveData(boolean connecting, String name, String stock, String supplier, String desc);
}
