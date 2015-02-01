package com.timoffex.structure;

import java.util.List;
import java.util.Date;

public abstract class TInterfaceHost {
	public final void broadcastStart() {
		List<TClient> clients = getClients();

		long time = new Date().getTime();

		for (TClient t : clients) {
			t.start(time);
		}
	}

	public final void broadcastStopImmediate() {
		List<TClient> clients = getClients();

		for (TClient t : clients) {
			t.stopNow();
		}
	}

	public final void broadcastPause() {
		List<TClient> clients = getClients();

		long time = new Date().getTime();

		for (TClient t : clients) {
			t.pause(time);
		}
	}

	public final void broadcastSync(long realTime, long clipTime) {
		List<TClient> clients = getClients();

		for (TClient t : clients) {
			t.sync(realTime, clipTime);
		}
	}

	public abstract List<TClient> getClients();
}
