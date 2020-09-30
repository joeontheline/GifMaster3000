package gui;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Mainframe extends JFrame {
	private static final long serialVersionUID = -8784172589550922911L;
	private JTabbedPane tabs = null;
//	private Mainframe thiss = this;
	private CreatorPanel creatorPanel = null;

	public Mainframe() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		this.setBackground(Color.GREEN);

		creatorPanel = new CreatorPanel();
		tabs = new JTabbedPane();
		tabs.addTab("Create", creatorPanel);
		tabs.addTab("Manage", new JPanel());

		// frame stuff
		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void componentResized(ComponentEvent e) {
				// creatorPanel.triggerScaledVideoDimsCalc();
				// repaintGui();
				// calcScaledVideoDims();
				// System.out.println("frame resize");
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		this.setTitle("GifMaster3000");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				creatorPanel.getMediaPlayerPanel().getMediaPlayerComponent().release();
				System.exit(0);
			}
		});

		// Runtime.getRuntime().addShutdownHook(new Exiter(ctrl.getGifQueue()));
		this.setContentPane(tabs);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setResizable(false);
		this.setVisible(true);
	}

	// public JFrame getFrame() {
	// return this;
	// }

//	protected void repaintGui() {
//		this.revalidate();
//		this.repaint();
//	}
}
