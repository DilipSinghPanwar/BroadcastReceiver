package com.androiddevs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    IntentFilter customActionIntentFilter;
    private BroadcastReceiver customActionBroadcastReceiver;
    private TextView valueReceiverValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSendBroadcast).setOnClickListener(this);

        customActionIntentFilter = new IntentFilter();
        customActionIntentFilter.addAction("androiddevs");

        valueReceiverValue = (TextView) findViewById(R.id.tvValueReceiverValue);
        findViewById(R.id.btnDynamicSendBroadcast).setOnClickListener(this);
        findViewById(R.id.btnRegisterDynamicReceiver).setOnClickListener(this);

        customActionBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "Value Received", Toast.LENGTH_SHORT).show();
                valueReceiverValue.setText(intent.getStringExtra("DBR"));
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendBroadcast:
                Intent intent = new Intent(getApplicationContext(), BRWithoutAction.class);
                intent.putExtra("key", "Hi! I am enjoying my work.");
                sendBroadcast(intent);
                break;
            case R.id.btnRegisterDynamicReceiver:
                registerReceiver(customActionBroadcastReceiver, customActionIntentFilter);
                Toast.makeText(getApplicationContext(), "Receiver Registered Successfully!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnDynamicSendBroadcast:
                Intent _intent = new Intent();
                _intent.setAction("androiddevs");
                _intent.putExtra("DBR", "DYNAMIC BROADCAST RECEIVER VALUE");
                sendBroadcast(_intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause()");
        /* we should unregister BroadcastReceiver here*/
//        unregisterReceiver(customActionBroadcastReceiver);

      /*  try {
            if (customActionBroadcastReceiver != null) {
                this.unregisterReceiver(customActionBroadcastReceiver);
            }
        } catch (IllegalArgumentException e) {
            Log.i(TAG,"customActionBroadcastReceiver is already unregistered");
            customActionBroadcastReceiver = null;
        }*/
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume()");
        /* we register BroadcastReceiver here*/
//        registerReceiver(customActionBroadcastReceiver, customActionIntentFilter);
        super.onResume();
    }
}