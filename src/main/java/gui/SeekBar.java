package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JSlider;

import logic.Ebus;
import mediaPlayer.MediaPlayerEvent;

public class SeekBar extends JSlider{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4366900320310320580L;
	JSlider thiss = null;
	
	SeekBar(){
		thiss = this;
		this.setPreferredSize(new Dimension(1000, 30));
		this.addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseDragged(MouseEvent e) {
				if (thiss.getValue() / 100 < 1) {
					Ebus.post(new MediaPlayerEvent(MediaPlayerEvent.EventType.SETPOSITION, (float) thiss.getValue() / 100));
				}
			}
		});
		
		this.setBackground(new Color(255, 0, 98));
		this.setPaintTrack(false);
	}
}
