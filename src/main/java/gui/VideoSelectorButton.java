package gui;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import bus.MediaPlayerBus;
import mediaPlayer.MediaPlayerEvent;

public class VideoSelectorButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2228393607680444376L;
	private BufferedImage fileSelectImg = null;
	// private Brain brain = null;
	// private EventBus eb = null;

	VideoSelectorButton() throws IOException {
		// brain = b;
		// eb = Ebus.getInstance();
		try {
			fileSelectImg = ImageIO.read(getClass().getClassLoader().getResource("folder.png"));
			this.setIcon(new ImageIcon(fileSelectImg));
		} catch (IllegalArgumentException e1) {
			// e1.printStackTrace();
			this.setText("VS");
		}

		// fileSelectButton.setBorderPainted(false);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// open file chooser
				FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
				dialog.setMode(FileDialog.LOAD);
				dialog.setVisible(true);
				// currentParameters = new ExportParameters(new
				// File(dialog.getDirectory() + dialog.getFile()));
				File inputFile = new File(dialog.getDirectory() + dialog.getFile());
				if (inputFile.isFile()) {
					// creatorPanel.openVideo(inputFile);
					MediaPlayerBus.post(new MediaPlayerEvent(MediaPlayerEvent.EventType.FILESELECTION, inputFile));

					// Alert.consoleLog("MediaInfo \"" +
					// ExportParameters.getInputFilePath() + "\"");
				}
				// gifs.put(Instant.now(), currentGif);
				// Alert.consoleLog(currentFile);
				// Alert.consoleLog(file);
			}
		});
		this.setToolTipText("Select File");
		ControlsPanel.applyPlayerButtonSettings(this);
	}
}
