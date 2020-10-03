package gui;

import com.google.common.eventbus.Subscribe;

import bus.MainFrameBus;

public class MainFrameEventsListener {
	private Mainframe mainframe = null;
	MainFrameEventsListener(Mainframe mf) {
		this.mainframe = mf;
		MainFrameBus.register(this);
	}

	@Subscribe
	public void listenMainFrameEvents(MainframeEvent event) {
		System.out.println("Bus event message: " + event);
		switch (event.getType()) {
			case "REPAINT" :
				mainframe.repaint();
				System.out.println("repainted");
				break;
			default :
				break;
		}
	}
}
