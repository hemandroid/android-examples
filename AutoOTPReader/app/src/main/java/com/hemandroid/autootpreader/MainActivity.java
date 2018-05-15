package com.hemandroid.autootpreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_otp = findViewById(R.id.et_otp);
    }

    public void getSms(String message) {
        if (message != null) {
            try {
                et_otp.setClickable(false);
                et_otp.setEnabled(false);
                et_otp.clearFocus();
                et_otp.setText(String.valueOf(message));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
