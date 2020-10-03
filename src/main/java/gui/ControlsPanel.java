package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ControlsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8116385714448999990L;
	private static final Dimension playerButtonDims = new Dimension(70, 30);
	
	ControlsPanel(){
		try {
			addToControlsPanel(new VideoSelectorButton());
			addToControlsPanel(new PlayPauseButton());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addToControlsPanel(new SkipBackButton());
		addToControlsPanel(new SkipLengthTextField());
		addToControlsPanel(new SkipForwardButton());
		addToControlsPanel(new MuteButton());
		addToControlsPanel(new SlowerButton());
		addToControlsPanel(new FasterButton());
		addToControlsPanel(new StopButton());
		addToControlsPanel(new SeekBar());
		
		BoxLayout controlsLayout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(controlsLayout);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.setBackground(new Color(252, 186, 3));
	}
	
	private void addToControlsPanel(Component com) {
		this.add(com);
		this.add(Box.createHorizontalStrut((2)));
	}
	
	public static JComponent applyPlayerButtonSettings(JComponent jc) {
		if (!(jc instanceof gui.SkipLengthTextField))
			jc.setOpaque(false);
		else {
			jc.setBackground(new Color(255, 0, 98));
			jc.setForeground(Color.WHITE);
		}
		jc.setBorder(null);
		jc.setMaximumSize(playerButtonDims);
		jc.setMinimumSize(playerButtonDims);
		jc.setPreferredSize(playerButtonDims);
		return jc;
	}
}
