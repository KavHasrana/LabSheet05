package com.example.broadcastproj;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.text.BreakIterator;
import android.os.Build;
import android.os.Bundle;

public class Receiver extends BroadcastReceiver {

    private BreakIterator txtViewMsg;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onReceive(Context context, Intent intent) {
        String currentText = txtViewMsg.getText().toString();
        String message = intent.getStringExtra ("value");
        currentText += "\nReceived" + message;
        txtViewMsg.setText(currentText);
    }
}
