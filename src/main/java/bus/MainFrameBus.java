package bus;

import com.google.common.eventbus.EventBus;

import gui.MainFrameEventsListener;

public class MainFrameBus {
	private static EventBus eventBus = null;

	public static void post(Object event) {
		if (eventBus == null)
			eventBus = new EventBus("MainFrameBus");
		eventBus.post(event);
	}

	public static void register(MainFrameEventsListener mel) {
		if (eventBus == null)
			eventBus = new EventBus("MainFrameBus");
		eventBus.register(mel);
	}
}