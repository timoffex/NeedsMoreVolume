package com.timoffex.structure;

// Server from client side.
// Messages received from the server are directed to this class.
// ACTUALLY PLAYS SOUND.
public abstract class TServer {
    // starts sound clip at time milliseconds from Jan 1, 1970
    public abstract void start(long time);
    // stops immediately (as soon as message received; no synchronization needed)
    public abstract void stopNow();
    // pauses clip at given (real world) time
    public abstract void pause(long time);

    // synchronizes sound clips such that the clip is at clipTime at realTime (milliseconds from Jan 1, 1970)
    public abstract void sync(long realTime, long clipTime);
}