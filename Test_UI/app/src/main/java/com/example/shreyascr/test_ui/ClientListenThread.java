package com.example.shreyascr.test_ui;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by timoffex on 1/31/15.
 */
public class ClientListenThread extends Thread {
    private BluetoothAdapter adapter;
    private BluetoothDevice device;
    private BluetoothSocket server;

    public ClientListenThread(BluetoothAdapter a, BluetoothDevice d) throws IOException {
        adapter = a;
        device = d;

        server = device.createRfcommSocketToServiceRecord(UUID.fromString("NeedsMoreVolume"));
    }

    public void run() {
        InputStream in;
        try {
            in = server.getInputStream();
        } catch (IOException e) { return; }

        byte[] bytes = new byte[1024];
        try {
            int len;
            while ((len=in.read(bytes)) != -1) {
                process(bytes, len);
            }
        } catch (IOException e) { }
    }

    private void process(byte[] bytes, int len) {

    }

    public void cancel() {

    }
}
