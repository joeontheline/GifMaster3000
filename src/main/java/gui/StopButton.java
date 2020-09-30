package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import logic.Ebus;
import mediaPlayer.MediaPlayerEvent;

public class StopButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1571637286353272333L;
	private ImageIcon closeImg = null;
	public StopButton() {
		try {
			closeImg = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("stop.png")));
			this.setIcon(closeImg);
		} catch (Exception e1) {
			System.out.println("Image loading problem.");
			System.out.println(e1.toString());
			this.setText("Close");
		}
		
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ebus.post(new MediaPlayerEvent(MediaPlayerEvent.EventType.STOP));
//				File f = ExportParameters.getInputFile();
//				mpc.mediaPlayer().controls().stop();
////				mpc.release();
//				inputFileDeletePrompt(f);
			}
		});
		
		ControlsPanel.applyPlayerButtonSettings(this);
	}
}
