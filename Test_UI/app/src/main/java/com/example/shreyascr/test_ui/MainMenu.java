package com.example.shreyascr.test_ui;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.timoffex.structure.android_impl.AndroidInterfaceHost;
import com.timoffex.structure.android_impl.AndroidInterfaceMain;

import java.util.UUID;


public class MainMenu extends ActionBarActivity {
    private AndroidInterfaceMain interfaceMain;
    private BluetoothAdapter btAdapter;

    // null unless used
    private AndroidInterfaceHost interfaceHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        interfaceMain = new AndroidInterfaceMain(btAdapter);
    }

    public void sendHost(View view) {
        String serverName = "NeedsMoreVolume";
        UUID serverUUID = UUID.fromString("NeedsMoreVolume");

        interfaceMain.hostServer(interfaceHost = new AndroidInterfaceHost(), serverName, serverUUID);
        // UPDATE GUI
    }
    public void sendJoin(View view) {
        interfaceMain.joinServer(/*TServer type*/);
        // UPDATE GUI
    }
}
