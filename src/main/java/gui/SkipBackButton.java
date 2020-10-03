package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import bus.MediaPlayerBus;
import mediaPlayer.MediaPlayerEvent;

public class SkipBackButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9014803228656476903L;
	private BufferedImage backImg = null;
	SkipBackButton() {
		try {
			backImg = ImageIO.read(getClass().getClassLoader().getResource("rewind.png"));
			this.setIcon(new ImageIcon(backImg));
		} catch (IOException | IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			System.out.println("Image loading problem.");
			System.out.println(e1.toString());
			this.setText("back");
		}

		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// send message to skip forward
				MediaPlayerBus.post(new MediaPlayerEvent(MediaPlayerEvent.EventType.SKIPBACK));
			}
		});
		
		this.setToolTipText("SkipBack");
		ControlsPanel.applyPlayerButtonSettings(this);
	}
}
