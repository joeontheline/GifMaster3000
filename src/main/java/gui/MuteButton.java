package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import bus.MediaPlayerBus;
import mediaPlayer.MediaPlayerEvent;

public class MuteButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8062867863409595920L;
	private ImageIcon muteImg = null;
	MuteButton() {
		try {
			muteImg = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("volume_on.png")));
		} catch (Exception e1) {
			System.out.println("Image loading problem.");
			System.out.println(e1.toString());
			this.setText("Mute");
		}
		this.setToolTipText("Mute");
		this.setIcon(muteImg);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MediaPlayerBus.post(new MediaPlayerEvent(MediaPlayerEvent.EventType.MUTE));
			}
		});
		
		ControlsPanel.applyPlayerButtonSettings(this);
	}

}
