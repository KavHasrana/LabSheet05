package com.example.broadcastproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String BROADCAST_ACTION = "Start";
    private BroadcastReceiver localListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart ();
        Receiver localListener = new Receiver ();
        IntentFilter intentFilter = new IntentFilter (BROADCAST_ACTION);
        this.registerReceiver (localListener,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop ();
        this.unregisterReceiver (localListener);
    }

    //@Override
    public void onClick(View view) {
        if(view.getId () == R.id.button){
            BackgroundService.startAction (this.getApplicationContext ());
        }
    }
}
