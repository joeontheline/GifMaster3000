package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopMenu extends JPopupMenu {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4233282609229632592L;
	private MouseEvent click = null;
	private JPopupMenu dis = this;

	PopMenu() {
		JMenuItem pointAMenuItem = new JMenuItem("Set point A");
		JMenuItem pointBMenuItem = new JMenuItem("Set point B");
		JMenuItem resetPointsMenuItem = new JMenuItem("Reset points");

		pointAMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click != null) {
					System.out.println(click.getPoint());
					// ExportParameters.setPointA(creatorGui.scalePoint(click.getPoint()));
					// creatorGui.getAspinner().updateSpinner(creatorGui.scalePoint(click.getPoint()));
					dis.setVisible(false);
				}
			}
		});

		pointBMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click != null) {
					System.out.println(click.getPoint());
					// ExportParameters.setPointB(creatorGui.scalePoint(click.getPoint()));
					// creatorGui.getBspinner().updateSpinner(creatorGui.scalePoint(click.getPoint()));
					dis.setVisible(false);
				}
			}
		});

		resetPointsMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(click.getPoint());
				// creatorGui.getAspinner().resetSpinner();
				// creatorGui.getBspinner().resetSpinner();
				// ExportParameters.resetPointA();
				// ExportParameters.resetPointB();
				// ExportParameters.resetCropDimensions();
			}
		});

		this.add(pointAMenuItem);
		this.add(pointBMenuItem);
		this.add(resetPointsMenuItem);
	}

	public void setMouseEvent(MouseEvent e) {
		this.click = e;
	}
}
