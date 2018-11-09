package github.hemandroid.recyclerviewlist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import github.hemandroid.recyclerviewlist.adapter.RecyclerListAdapter;
import github.hemandroid.recyclerviewlist.databinding.ActivityMainBinding;
import github.hemandroid.recyclerviewlist.model.ModelListData;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private LinearLayoutManager layoutManager;
    private ArrayList<ModelListData> modelListData = new ArrayList<>();
    private RecyclerListAdapter recyclerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        loadMyListData();
    }

    private void loadMyListData() {
        mainBinding.rvList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mainBinding.rvList.setLayoutManager(layoutManager);
        for (int i = 1; i <= 30; i++) {
            modelListData.add(new ModelListData("Android API Level " + String.valueOf(i)));
        }
        recyclerListAdapter = new RecyclerListAdapter(this, modelListData);
        mainBinding.rvList.setAdapter(recyclerListAdapter);
    }
}
