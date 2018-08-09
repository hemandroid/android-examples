package github.hemandroid.bcReceiverSample.actionBroadCast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import github.hemandroid.bcReceiverSample.R;

public class ActionActivity extends AppCompatActivity {

    private View.OnClickListener mOnClickListener;
    private Button btn_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        initClickListeners();

        initViewListeners();
    }

    private void initViewListeners() {
        btn_check = findViewById(R.id.btn_action);
        btn_check.setOnClickListener(mOnClickListener);
    }

    private void initClickListeners() {
        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_action:

                        /** Below intent is used to trigger the broadcast receiver
                         * based on the string which was added as a Key to perform Action.
                         * This intent will trigger by matching the key with the
                         * Receiver key from Manifest File*/

                        Intent i_action = new Intent();
                        i_action.setAction("hemandroid.ACTION_PERFORMED");
                        sendBroadcast(i_action);
                        break;
                }
            }
        };
    }
}
