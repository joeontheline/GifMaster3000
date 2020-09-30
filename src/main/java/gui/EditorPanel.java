package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class EditorPanel extends JPanel {
	BoxLayout editingLayout = null;
	EditorPanel(){
		editingLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(editingLayout);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.setBackground(new Color(255, 0, 98));
		this.setMaximumSize(new Dimension(120, 1000));
	}
	
	private void addToEditingPane(Component com) {
		this.add(com);
		this.add(Box.createVerticalStrut(2));
	}
}
