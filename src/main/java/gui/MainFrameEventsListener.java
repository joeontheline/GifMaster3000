package gui;

import com.google.common.eventbus.Subscribe;

import logic.Ebus;

public class MainFrameEventsListener {
	private Mainframe mainframe = null;
	MainFrameEventsListener(Mainframe mf) {
		this.mainframe = mf;
		Ebus.register(this);
	}

	@Subscribe
	public void listenMainFrameEvents(MainframeEvent event) {
		System.out.println("Bus event message: " + event);
		switch (event.getType()) {
			case "REPAINT" :
				mainframe.repaint();
				break;
			default :
				break;
		}
	}
}
