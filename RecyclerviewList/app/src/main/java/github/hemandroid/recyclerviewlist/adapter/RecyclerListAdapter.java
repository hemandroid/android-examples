package github.hemandroid.recyclerviewlist.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import github.hemandroid.recyclerviewlist.MainActivity;
import github.hemandroid.recyclerviewlist.R;
import github.hemandroid.recyclerviewlist.databinding.ItemListBinding;
import github.hemandroid.recyclerviewlist.model.ModelListData;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ListHolder> {

    private ArrayList<ModelListData> mArrayListData = new ArrayList<>();
    private Context mContext;

    public RecyclerListAdapter(MainActivity mainActivity, ArrayList<ModelListData> modelListData) {
        this.mContext = mainActivity;
        this.mArrayListData = modelListData;
    }

    /** We are using dataBinding to remove the findViewById concept in a reactive way*/
    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ItemListBinding mItemListBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_list, parent, false);
        mContext = parent.getContext();
        return new ListHolder(mItemListBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder listHolder, int position) {
        listHolder.itemListBinding.tvDataItem.setText(mArrayListData.get(position).getStr_data());
    }

    @Override
    public int getItemCount() {
        return mArrayListData.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder {

        ItemListBinding itemListBinding;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            itemListBinding = DataBindingUtil.bind(itemView);
        }
    }
}
