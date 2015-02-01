package com.timoffex.structure.android_impl;

import android.bluetooth.BluetoothSocket;

import com.timoffex.structure.TClient;
import static com.timoffex.structure.Util.*;

import java.io.IOException;
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
    public abstract boolean stopNow();
    // pauses clip at given (real world) time
    public abstract boolean pause(long time);

    // synchronizes sound clips such that the clip is at clipTime at realTime (milliseconds from Jan 1, 1970)
    public abstract boolean sync(long realTime, long clipTime);
}
