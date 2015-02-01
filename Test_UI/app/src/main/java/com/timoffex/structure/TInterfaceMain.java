package com.timoffex.structure;

import java.util.List;
import java.util.UUID;

public abstract class TInterfaceMain {
	/** Creates server on the current device. 
	  * @return True on success. */
	public abstract boolean hostServer(TInterfaceHost host, String serverName, UUID uuid);
	/** Finds all nearby compatible servers.
	  * @return List of all servers */
	public abstract List<TServer> fetchServerList();

	/** Joins selected server.
	  * @param selectedServer - Information about server (defined by your code).
	  * @return True on success. */
	public abstract boolean joinServer(TServer selectedServer);
}