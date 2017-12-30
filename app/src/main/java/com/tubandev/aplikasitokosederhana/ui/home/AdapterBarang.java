package com.tubandev.aplikasitokosederhana.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tubandev.aplikasitokosederhana.R;
import com.tubandev.aplikasitokosederhana.model.Barang;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sulistiyanto on 30/12/17.
 */

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.ViewHolder> {

    private List<Barang> barangList;

    public AdapterBarang(List<Barang> barangList) {
        this.barangList = barangList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(barangList.get(position));
    }

    @Override
    public int getItemCount() {
        return barangList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtNama)
        TextView txtNama;
        @BindView(R.id.txtStock)
        TextView txtStock;
        @BindView(R.id.txtPemasok)
        TextView txtPemasok;
        @BindView(R.id.txtDesc)
        TextView txtDesc;
        @BindView(R.id.txtTime)
        TextView txtTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindData(Barang barang) {
            txtNama.setText(barang.getNama());
            txtStock.setText("Stok : " + barang.getStok());
            txtPemasok.setText("Pemasok : " + barang.getPemasok());
            txtDesc.setText("Keterangan : " + barang.getKeterangan());
            txtTime.setText(barang.getTanggal());
        }
    }
}
