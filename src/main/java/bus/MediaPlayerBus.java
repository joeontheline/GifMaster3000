package bus;

import com.google.common.eventbus.EventBus;

import mediaPlayer.MediaPlayerEventsListener;

public class MediaPlayerBus {
	private static EventBus eventBus = null;

	public static void post(Object event) {
		if (eventBus == null)
			eventBus = new EventBus("MediaPlayerBus");
		eventBus.post(event);
	}

	public static void register(Object mcel) {
		if (eventBus == null)
			eventBus = new EventBus("MediaPlayerBus");
		eventBus.register(mcel);
	}
}
