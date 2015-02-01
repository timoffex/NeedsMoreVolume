package com.example.shreyascr.test_ui;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

import com.timoffex.structure.android_impl.AndroidInterfaceHost;
import com.timoffex.structure.android_impl.AndroidClient;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by timoffex on 1/31/15.
 */
public class ServerAcceptThread extends Thread {
    private AndroidInterfaceHost host;
    private BluetoothAdapter adapter;
    private BluetoothServerSocket serverSocket;

    public ServerAcceptThread(AndroidInterfaceHost h, BluetoothAdapter a, String name, UUID uuid) {
        host = h;
        adapter = a;

        BluetoothServerSocket tmp = null;

        try {
            tmp = listenUsingRfcommWithServiceRecord(name, uuid);
        } catch (IOException e) {}

        serverSocket = tmp;
    }

    @Override
    public void run() {
        BluetoothSocket socket = null;
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                break;
            }

            if (socket != null) {
                AndroidClient client = new AndroidClient(socket);
                host.clientConnected(client);
            }
        }
    }
}
