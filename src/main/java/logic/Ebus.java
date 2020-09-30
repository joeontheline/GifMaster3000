package logic;

import com.google.common.eventbus.EventBus;

import gui.MainFrameEventsListener;
import mediaPlayer.MediaPlayerEventsListener;

public class Ebus {
	private static EventBus eventBus = null;

	public static void post(Object event) {
		if (eventBus == null)
			eventBus = new EventBus();
		eventBus.post(event);
	}
	
	public static void register(MediaPlayerEventsListener mcel) {
		if (eventBus == null)
			eventBus = new EventBus();
		eventBus.register(mcel);
	}

	public static void register(MainFrameEventsListener mel) {
		if (eventBus == null)
			eventBus = new EventBus();
		eventBus.register(mel);
	}
}