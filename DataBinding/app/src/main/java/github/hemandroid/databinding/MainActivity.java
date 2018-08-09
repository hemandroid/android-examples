package github.hemandroid.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import github.hemandroid.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private View.OnClickListener mOnClickListener;

    /** This complete example explains about the MVVM design pattern.
     * As we applying dataBinding to reduce the boilerplate coding, and
     * We writing the code that can be understandable to everyone.*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** Default setContentView declaration has been replaced by DataBindingUtil.
         * It can be possible only after adding the attribute in app.gradle file
         * Once we enable the data-binding, then we have to initialize it in globally to access the entire class.*/
//        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        /** Below method is created for all Click-listener actions*/
        initViewClickListeners();

        /** Below method if created for all view-listener initializer*/
        initViewListeners();
    }

    private void initViewListeners(){
        mainBinding.btnCheck.setOnClickListener(mOnClickListener);
        mainBinding.btnSubmit.setOnClickListener(mOnClickListener);
    }

    private void initViewClickListeners(){
        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_check:
                        Toast.makeText(MainActivity.this, "This button checked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.btn_submit:
                        Toast.makeText(MainActivity.this, "This button submitted", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
    }
}
