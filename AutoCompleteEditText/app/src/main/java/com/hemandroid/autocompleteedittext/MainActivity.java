package com.hemandroid.autocompleteedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppCompatAutoCompleteTextView mAppCompatAutoCompleteTextView;
    private Button btn_search;
    private String str_text;
    private ArrayAdapter<String> countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Below is the code it will explain how to set Auto complete EditText
         * By adding the list of hints, that you want to display to the user,
         * by entering the text in the edittext field.
         *
         * AppCompatAutoCompleteTextView is a widget that it will support for both
         * Lower and Higher versions of Android*/

        mAppCompatAutoCompleteTextView = findViewById(R.id.aet_search);
        countryAdapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,
                getResources().getStringArray(R.array.countries));
        /** Here we are calling the string array from xml file*/
        mAppCompatAutoCompleteTextView.setThreshold(1);
        mAppCompatAutoCompleteTextView.setAdapter(countryAdapter);

        btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_text = mAppCompatAutoCompleteTextView.getText().toString();
                Toast.makeText(MainActivity.this, str_text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
