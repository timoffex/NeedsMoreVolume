package com.timoffex.structure.android_impl;

import android.bluetooth.BluetoothAdapter;

import com.example.shreyascr.test_ui.ServerAcceptThread;
import com.timoffex.structure.TInterfaceHost;
import com.timoffex.structure.TInterfaceMain;
import com.timoffex.structure.TServer;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by timoffex on 1/31/15.
 */
public class AndroidInterfaceMain extends TInterfaceMain {
    private ServerAcceptThread acceptThread;
    private BluetoothAdapter adapter;

    public AndroidInterfaceMain(BluetoothAdapter a) {
        adapter = a;
    }

    @Override
    public boolean hostServer(TInterfaceHost host, String serverName, UUID uuid) {
        try {
            acceptThread = new ServerAcceptThread((AndroidInterfaceHost)host, adapter, serverName, uuid);
            acceptThread.start();
        } catch (IOException e) { return false; }

        return true;
    }

    @Override
    public boolean joinServer(TServer selectedServer) {
        // CODE HERE
        return false;
    }

    @Override
    public List<TServer> fetchServerList() {
        // CODE HERE
        return null;
    }
}
