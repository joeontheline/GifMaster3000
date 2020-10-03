package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import bus.MediaPlayerBus;
import mediaPlayer.MediaPlayerEvent;

public class SlowerButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8798396498928347062L;
	private ImageIcon minusImg = null;
	public SlowerButton() {
		try {
			minusImg = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("minus2.png")));
			this.setIcon(minusImg);
		} catch (Exception e1) {
			System.out.println("Image loading problem.");
			System.out.println(e1.toString());
			this.setText("Slower");
		}
		
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MediaPlayerBus.post(new MediaPlayerEvent(MediaPlayerEvent.EventType.SLOWER));
			}
		});
		
		ControlsPanel.applyPlayerButtonSettings(this);
	}
}
