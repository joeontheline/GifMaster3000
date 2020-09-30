package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import logic.Ebus;
import mediaPlayer.MediaPlayerEvent;

public class SkipForwardButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1461083673969123064L;
	private BufferedImage forwardImg = null;
	SkipForwardButton() {
		ControlsPanel.applyPlayerButtonSettings(this);
		try {
			forwardImg = ImageIO.read(getClass().getClassLoader().getResource("forward.png"));
			this.setIcon(new ImageIcon(forwardImg));
		} catch (IOException | IllegalArgumentException e1) {
			System.out.println("Image loading problem.");
			System.out.println(e1.toString());
			this.setText("Forward");
		}

		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ebus.post(new MediaPlayerEvent(MediaPlayerEvent.EventType.SKIPFORWARD));
			}
		});
		
		this.setToolTipText("SkipForward");
	}
}
