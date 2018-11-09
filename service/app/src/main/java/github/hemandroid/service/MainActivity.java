package github.hemandroid.service;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import github.hemandroid.service.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private View.OnClickListener mOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initClicListeners();

        initViewListeners();
    }
    private void initViewListeners() {
        mainBinding.btnStart.setOnClickListener(mOnClickListener);
        mainBinding.btnStop.setOnClickListener(mOnClickListener);
    }
    private void initClicListeners() {
        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_start:
                        startService(new Intent(getApplicationContext(), MyService.class));
                        break;

                    case R.id.btn_stop:
                        stopService(new Intent(getApplicationContext(), MyService.class));
                        break;
                }
            }
        };
    }
}
