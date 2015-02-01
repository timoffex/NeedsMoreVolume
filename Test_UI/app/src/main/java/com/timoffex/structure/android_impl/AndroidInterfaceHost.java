package com.timoffex.structure.android_impl;

import com.timoffex.structure.TClient;
import com.timoffex.structure.TInterfaceHost;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by timoffex on 1/31/15.
 */
public class AndroidInterfaceHost extends TInterfaceHost {
    private List<TClient> clients;

    public AndroidInterfaceHost() {
        clients = new ArrayList<>();
    }

    @Override
    public List<TClient> getClients() {
        return new ArrayList<TClient>(clients);
    }

    public void clientConnected(TClient client) {
        clients.add(client);
    }

    public void clientDisconnected(TClient client) {
        clients.remove(client);
    }
}
