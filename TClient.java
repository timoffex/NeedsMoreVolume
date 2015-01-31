public abstract class TClient {
	// starts sound clip at time milliseconds from Jan 1, 1970
	public abstract void start(long time);
	// stops immediately (as soon as message received; no synchronization needed)
	public abstract void stopNow();
	// pauses clip at given (real world) time
	public abstract void pause(long time);

	// synchronizes sound clips such that the clip is at clipTime at realTime (milliseconds from Jan 1, 1970)
	public abstract void sync(long realTime, long clipTime);
}