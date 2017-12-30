package com.tubandev.aplikasitokosederhana.ui.home.view;

import com.tubandev.aplikasitokosederhana.base.BaseView;
import com.tubandev.aplikasitokosederhana.ui.home.AdapterBarang;

/**
 * Created by sulistiyanto on 30/12/17.
 */

public interface MainView extends BaseView {
    void showData(AdapterBarang adapterBarang);
    void emptyData();
}
