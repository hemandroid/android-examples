package github.hemandroid.recyclergridview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;

import github.hemandroid.recyclergridview.adapter.RecyclerGridAdapter;
import github.hemandroid.recyclergridview.databinding.ActivityMainBinding;
import github.hemandroid.recyclergridview.model.ModelImageData;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private GridLayoutManager gridLayoutManager;
    private ArrayList<ModelImageData> modelImageData = new ArrayList<>();
    private RecyclerGridAdapter recyclerGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        loadGridData();
    }

    private void loadGridData() {
        mainBinding.rvGrid.setHasFixedSize(true);
        gridLayoutManager = new GridLayoutManager(this, 3);
        mainBinding.rvGrid.setLayoutManager(gridLayoutManager);
        for (int i = 1; i <= 30; i++) {
            modelImageData.add(new ModelImageData(R.drawable.jetpack, String.valueOf(i)));
        }
        recyclerGridAdapter = new RecyclerGridAdapter(this, modelImageData);
        mainBinding.rvGrid.setAdapter(recyclerGridAdapter);
    }
}
