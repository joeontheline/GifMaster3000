package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class CreatorPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9163702238482981225L;
	
	private MediaPlayerPanel mediaPlayerPanel = null;
	private ControlsPanel controlsPanel = null;
	private EditorPanel editorPanel = null;

//	private JFrame mainFrame = null;
//	private CreatorPanel thiss = this;
//
//	private Gif currentGif = null;

	
	private static final Dimension editButtonDims = new Dimension(120, 30);

	CreatorPanel() {
		this.controlsPanel = new ControlsPanel();
		this.mediaPlayerPanel = new MediaPlayerPanel();

		this.setLayout(new BorderLayout());
		this.add(mediaPlayerPanel, BorderLayout.CENTER);
		this.add(controlsPanel, BorderLayout.SOUTH);
		this.setBackground(new Color(255, 165, 0));
	}

	// public Dimension getPlayerButtonDims() {
	// return playerButtonDims;
	// }

	public MediaPlayerPanel getMediaPlayerPanel() {
		return mediaPlayerPanel;
	}


}
