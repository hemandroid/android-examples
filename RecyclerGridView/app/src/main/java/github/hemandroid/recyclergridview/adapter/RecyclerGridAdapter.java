package github.hemandroid.recyclergridview.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import github.hemandroid.recyclergridview.MainActivity;
import github.hemandroid.recyclergridview.R;
import github.hemandroid.recyclergridview.databinding.ItemGridBinding;
import github.hemandroid.recyclergridview.model.ModelImageData;

public class RecyclerGridAdapter extends RecyclerView.Adapter<RecyclerGridAdapter.GridHolder> {

    private Context mContext;
    private ArrayList<ModelImageData> mImageArrayList = new ArrayList<>();

    public RecyclerGridAdapter(MainActivity mainActivity, ArrayList<ModelImageData> modelImageData) {
        this.mContext = mainActivity;
        this.mImageArrayList = modelImageData;
    }

    /** We are using dataBinding to remove the findViewById concept in a reactive way*/
    @NonNull
    @Override
    public GridHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ItemGridBinding itemGridBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_grid, parent, false);
        return new GridHolder(itemGridBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull GridHolder gridHolder, int position) {
        gridHolder.itemGridBinding.ivDroid.setImageResource(mImageArrayList.get(position).getImg_data());
        gridHolder.itemGridBinding.tvImgCount.setText(mImageArrayList.get(position).getStr_count());
    }

    @Override
    public int getItemCount() {
        return mImageArrayList.size();
    }

    public class GridHolder extends RecyclerView.ViewHolder {

        ItemGridBinding itemGridBinding;

        public GridHolder(@NonNull View itemView) {
            super(itemView);
            itemGridBinding = DataBindingUtil.bind(itemView);
        }
    }
}
