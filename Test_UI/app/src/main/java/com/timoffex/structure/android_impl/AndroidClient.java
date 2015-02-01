package com.timoffex.structure.android_impl;

import android.bluetooth.BluetoothSocket;
import android.provider.MediaStore;

import com.timoffex.structure.TClient;
import static com.timoffex.structure.Util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by timoffex on 1/31/15.
 */
public class AndroidClient extends TClient {
    private BluetoothSocket socket;

    public AndroidClient(BluetoothSocket socket) {
        this.socket = socket;
    }

    // starts sound clip at time milliseconds from Jan 1, 1970
    public boolean start(long time) {
        OutputStream o;
        try {
            o = socket.getOutputStream();
            o.write(concat(toBytes("start"), toBytes(time)));
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    // stops immediately (as soon as message received; no synchronization needed)
    public boolean stopNow() {
        OutputStream o;
        try {
            o = socket.getOutputStream();
            o.write(concat(toBytes("stopNow")));
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    // pauses clip at given (real world) time
    public boolean pause(long time) {
        OutputStream o;
        try {
            o = socket.getOutputStream();
            o.write(concat(toBytes("pause"), toBytes(time)));
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    // synchronizes sound clips such that the clip is at clipTime at realTime (milliseconds from Jan 1, 1970)
    public boolean sync(long realTime, long clipTime) {
        OutputStream o;
        try {
            o = socket.getOutputStream();
            o.write(concat(toBytes("sync"), toBytes(realTime), toBytes(clipTime)));
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean stream(InputStream f) {
        OutputStream o;

        try {
            o = socket.getOutputStream();

            byte[] buffer = new byte[1024<<10];
            int len;
            while ((len = f.read(buffer)) != -1) {
                o.write(buffer, 0, len);
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
