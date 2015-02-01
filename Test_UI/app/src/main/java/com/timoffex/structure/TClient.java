package com.timoffex.structure;

import java.io.File;
import java.io.InputStream;

// Client from server side.
// Each method sends a message to the client, DOES NOT TRY TO ACTUALLY PLAY SOUND.
public abstract class TClient {
	// starts sound clip at time milliseconds from Jan 1, 1970
	public abstract boolean start(long time);
	// stops immediately (as soon as message received; no synchronization needed)
	public abstract boolean stopNow();
	// pauses clip at given (real world) time
	public abstract boolean pause(long time);

    public abstract boolean stream(InputStream f);


	// synchronizes sound clips such that the clip is at clipTime at realTime (milliseconds from Jan 1, 1970)
	public abstract boolean sync(long realTime, long clipTime);
}