package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import bus.MediaPlayerBus;
import mediaPlayer.MediaPlayerEvent;

public class FasterButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1840934569852506532L;
	private ImageIcon plusImg = null;
	public FasterButton() {
		try {
			plusImg = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("plus2.png")));
			this.setIcon(plusImg);
		} catch (Exception e1) {
			System.out.println("Image loading problem.");
			System.out.println(e1.toString());
			this.setText("Fast");
		}
		
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MediaPlayerBus.post(new MediaPlayerEvent(MediaPlayerEvent.EventType.FASTER));
			}
		});
		
		ControlsPanel.applyPlayerButtonSettings(this);
	}
}
