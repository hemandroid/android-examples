package github.hemandroid.webview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebViewClient;

import github.hemandroid.webview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private View.OnClickListener mOnClickListener;
    private String str_Get_Url;
    private String str_url_header = "https://";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        webSettings();
        mainBinding.webview.setWebViewClient(new WebViewClient());
        mainBinding.webview.loadUrl(str_url_header + "www.google.com");

        initClikListeners();

        initViewListeners();
    }

    private void initViewListeners() {
        mainBinding.btnLoad.setOnClickListener(mOnClickListener);
    }

    private void initClikListeners() {
        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_load:
                        str_Get_Url = str_url_header + mainBinding.etEnterUrl.getText().toString();

                        webSettings();
//                      Below line setWebViewClient used to load the Url within the app.
                        mainBinding.webview.setWebViewClient(new WebViewClient());
                        mainBinding.webview.loadUrl(str_Get_Url);
                        showSoftwareKeyboard(false);
                        break;
                }
            }
        };
    }

    private void webSettings() {
        mainBinding.webview.getSettings().setJavaScriptEnabled(false);
        mainBinding.webview.getSettings().setLoadsImagesAutomatically(true);
        mainBinding.webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    }

    protected void showSoftwareKeyboard(boolean showKeyboard) {
        final InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        assert inputManager != null;
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), showKeyboard ? InputMethodManager.SHOW_FORCED : InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
