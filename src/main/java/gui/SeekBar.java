package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JSlider;

import com.google.common.eventbus.Subscribe;

import bus.MainFrameBus;
import bus.MediaPlayerBus;
import mediaPlayer.MediaPlayerEvent;

public class SeekBar extends JSlider {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4366900320310320580L;
	JSlider thiss = null;

	SeekBar() {
		thiss = this;
		this.setPreferredSize(new Dimension(1000, 30));
		this.addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				if (thiss.getValue() / 100 < 1) {
					MediaPlayerBus.post(new MediaPlayerEvent(MediaPlayerEvent.EventType.SETPOSITION,
							(float) thiss.getValue() / 100));
				}
			}
		});

		this.setBackground(new Color(255, 0, 98));
		this.setPaintTrack(false);
		MainFrameBus.register(new SeekBarEventsListener());
	}

	private class SeekBarEventsListener {

		@Subscribe
		public void listenMainFrameEvents(MainframeEvent event) {
//			System.out.println("Bus event message: " + event.getType());
			if (event.getType().equals("SEEKBARPOSITION")) {
				thiss.setValue(event.getSeekbarPosition());
			}
		}
	}
}
