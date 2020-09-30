package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import logic.Ebus;
import mediaPlayer.MediaPlayerEvent;

public class PlayPauseButton extends JToggleButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5411225557579116243L;
	private ImageIcon playImg = null;
	private ImageIcon pauseImg = null;
	public PlayPauseButton() throws IOException {

		try {
			playImg = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("play.png")));
			pauseImg = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("pause.png")));
			this.setIcon(playImg);
			this.setSelectedIcon(pauseImg);
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
			this.setText("PP");
		}

		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ebus.post(new MediaPlayerEvent(MediaPlayerEvent.EventType.PLAYPAUSE));
			}
		});

		this.setToolTipText("PlayPause");
		ControlsPanel.applyPlayerButtonSettings(this);
	}
}
