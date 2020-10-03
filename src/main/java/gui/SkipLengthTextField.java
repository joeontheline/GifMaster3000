package gui;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

import bus.MediaPlayerBus;
import mediaPlayer.MediaPlayerEvent;

public class SkipLengthTextField extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3905456113317093654L;
	private JTextField dis = this;
	SkipLengthTextField() {
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		this.setFont(font1);
		this.setHorizontalAlignment(JTextField.CENTER);
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				MediaPlayerBus.post(new MediaPlayerEvent(MediaPlayerEvent.EventType.SKIPLENGTHCHANGE,
						Integer.valueOf(dis.getText())));
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.setColumns(6);
		this.setToolTipText("Set SkipLength");
		ControlsPanel.applyPlayerButtonSettings(this);
	}
}
