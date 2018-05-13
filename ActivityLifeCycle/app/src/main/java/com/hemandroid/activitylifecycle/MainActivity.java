package com.hemandroid.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv_activity_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_activity_state = findViewById(R.id.tv_activity_state);
        tv_activity_state.setText(getString(R.string.on_create));
        Toast.makeText(this, getString(R.string.on_create), Toast.LENGTH_SHORT).show();
        Log.d("LifecycleState-->", getString(R.string.on_create));
    }

    @Override
    protected void onStart() {
        super.onStart();
        tv_activity_state.setText(getString(R.string.on_start));
        Toast.makeText(this, getString(R.string.on_start), Toast.LENGTH_SHORT).show();
        Log.d("LifecycleState-->", getString(R.string.on_start));
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv_activity_state.setText(getString(R.string.on_resume));
        Toast.makeText(this, getString(R.string.on_resume), Toast.LENGTH_SHORT).show();
        Log.d("LifecycleState-->", getString(R.string.on_resume));
    }

    @Override
    protected void onPause() {
        super.onPause();
        tv_activity_state.setText(getString(R.string.on_pause));
        Toast.makeText(this, getString(R.string.on_pause), Toast.LENGTH_SHORT).show();
        Log.d("LifecycleState-->", getString(R.string.on_pause));
    }

    @Override
    protected void onStop() {
        super.onStop();
        tv_activity_state.setText(getString(R.string.on_stop));
        Toast.makeText(this, getString(R.string.on_stop), Toast.LENGTH_SHORT).show();
        Log.d("LifecycleState-->", getString(R.string.on_stop));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tv_activity_state.setText(getString(R.string.on_restart));
        Toast.makeText(this, getString(R.string.on_restart), Toast.LENGTH_SHORT).show();
        Log.d("LifecycleState-->", getString(R.string.on_restart));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv_activity_state.setText(getString(R.string.on_destroy));
        Toast.makeText(this, getString(R.string.on_destroy), Toast.LENGTH_SHORT).show();
        Log.d("LifecycleState-->", getString(R.string.on_destroy));
    }
}
