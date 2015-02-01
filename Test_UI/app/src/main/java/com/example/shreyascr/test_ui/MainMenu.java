package com.example.shreyascr.test_ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.timoffex.structure.android_impl.AndroidInterfaceHost;
import com.timoffex.structure.android_impl.AndroidInterfaceMain;


public class MainMenu extends ActionBarActivity {
    private AndroidInterfaceHost interfaceHost;
    private AndroidInterfaceMain interfaceMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        interfaceHost = new AndroidInterfaceHost();
        interfaceMain = new AndroidInterfaceMain();
    }

    public void sendHost(View view) {
        interfaceMain.hostServer();
    }
    public void sendJoin(View view) {
        interfaceMain.joinServer(/*TServer type*/);
    }
}
