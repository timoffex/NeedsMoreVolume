package com.timoffex.structure.android_impl;

import com.timoffex.structure.TInterfaceMain;
import com.timoffex.structure.TServer;

import java.util.List;

/**
 * Created by timoffex on 1/31/15.
 */
public class AndroidInterfaceMain extends TInterfaceMain {
    @Override
    public boolean hostServer() {
        // CODE HERE
        return false;
    }

    @Override
    public boolean joinServer(TServer selectedServer) {
        // CODE HERE
        return false;
    }

    @Override
    public List<TServer> fetchServerList() {
        return null;
    }
}
