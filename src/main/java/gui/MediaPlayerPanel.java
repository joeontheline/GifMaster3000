package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import bus.MainFrameBus;
import bus.MediaPlayerBus;
import logic.ConCalcs;
import mediaPlayer.MediaPlayerComponent;
import mediaPlayer.MediaPlayerEvent;
import uk.co.caprica.vlcj.media.MediaRef;
import uk.co.caprica.vlcj.media.TrackType;
import uk.co.caprica.vlcj.player.base.Marquee;
import uk.co.caprica.vlcj.player.base.MarqueePosition;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class MediaPlayerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6581821597167635540L;
	private MediaPlayerComponent mediaPlayerComponent;
	private PopMenu popMenu = null;
	private boolean isPopMenuOpen = false;

	MediaPlayerPanel() {
		this.popMenu = new PopMenu();
		this.setLayout(new BorderLayout());
		// mediaPlayerPane.setLayout();
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.setBackground(new Color(0, 247, 255));

		mediaPlayerComponent = new MediaPlayerComponent();

		mediaPlayerComponent.mediaPlayer().input().enableMouseInputHandling(false);
		mediaPlayerComponent.mediaPlayer().input().enableKeyInputHandling(false);
		// mediaPlayerComponent.setMinimumSize(new Dimension(800, 600));
		mediaPlayerComponent.mediaPlayer().events().addMediaPlayerEventListener(new MediaPlayerEventListener() {

			@Override
			public void volumeChanged(MediaPlayer mediaPlayer, float volume) {
				// TODO Auto-generated method stub

			}

			@Override
			public void videoOutput(MediaPlayer mediaPlayer, int newCount) {
				// TODO Auto-generated method stub

			}

			@Override
			public void titleChanged(MediaPlayer mediaPlayer, int newTitle) {
				// TODO Auto-generated method stub
			}

			@Override
			public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
				// timeDisplay.setTime(Utils.millisToHMS(newTime));
			}

			@Override
			public void stopped(MediaPlayer mediaPlayer) {
				// TODO Auto-generated method stub

			}

			@Override
			public void snapshotTaken(MediaPlayer mediaPlayer, String filename) {
				// TODO Auto-generated method stub

			}

			@Override
			public void seekableChanged(MediaPlayer mediaPlayer, int newSeekable) {
				// TODO Auto-generated method stub

			}

			@Override
			public void scrambledChanged(MediaPlayer mediaPlayer, int newScrambled) {
				// TODO Auto-generated method stub

			}

			@Override
			public void positionChanged(MediaPlayer mediaPlayer, float newPosition) {
//				sb.setValue(Math.round(newPosition * 100));
				MainFrameBus.post(new MainframeEvent(MainframeEvent.EventType.SEEKBARPOSITION, Math.round(newPosition * 100)));
//				mediaPlayerComponent.showMarquee(ConCalcs.millisToHMS(mediaPlayerComponent.mediaPlayer().status().time()));
//				Ebus.post(new MediaPlayerEvent( MediaPlayerEvent.EventType.SHOWMARQUEE, ConCalcs.millisToHMS(mediaPlayerComponent.mediaPlayer().status().time()) ));
			}

			@Override
			public void playing(MediaPlayer mediaPlayer) {
				// TODO Auto-generated method stub

			}

			@Override
			public void paused(MediaPlayer mediaPlayer) {
				// TODO Auto-generated method stub

			}

			@Override
			public void pausableChanged(MediaPlayer mediaPlayer, int newPausable) {
				// TODO Auto-generated method stub

			}

			@Override
			public void opening(MediaPlayer mediaPlayer) {
				// TODO Auto-generated method stub

			}

			@Override
			public void muted(MediaPlayer mediaPlayer, boolean muted) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mediaPlayerReady(MediaPlayer mediaPlayer) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mediaChanged(MediaPlayer mediaPlayer, MediaRef media) {
				// TODO Auto-generated method stub

			}

			@Override
			public void lengthChanged(MediaPlayer mediaPlayer, long newLength) {
				// TODO Auto-generated method stub

			}

			@Override
			public void forward(MediaPlayer mediaPlayer) {
				// TODO Auto-generated method stub

			}

			@Override
			public void finished(MediaPlayer mediaPlayer) {
				// TODO Auto-generated method stub

			}

			@Override
			public void error(MediaPlayer mediaPlayer) {
				// TODO Auto-generated method stub

			}

			@Override
			public void elementaryStreamSelected(MediaPlayer mediaPlayer, TrackType type, int id) {
				// TODO Auto-generated method stub

			}

			@Override
			public void elementaryStreamDeleted(MediaPlayer mediaPlayer, TrackType type, int id) {
				// TODO Auto-generated method stub

			}

			@Override
			public void elementaryStreamAdded(MediaPlayer mediaPlayer, TrackType type, int id) {
				// TODO Auto-generated method stub

			}

			@Override
			public void corked(MediaPlayer mediaPlayer, boolean corked) {
				// TODO Auto-generated method stub

			}

			@Override
			public void chapterChanged(MediaPlayer mediaPlayer, int newChapter) {
				// TODO Auto-generated method stub

			}

			@Override
			public void buffering(MediaPlayer mediaPlayer, float newCache) {
				// TODO Auto-generated method stub

			}

			@Override
			public void backward(MediaPlayer mediaPlayer) {
				// TODO Auto-generated method stub

			}

			@Override
			public void audioDeviceChanged(MediaPlayer mediaPlayer, String audioDevice) {
				// TODO Auto-generated method stub

			}
		});

		mediaPlayerComponent.mediaPlayer().controls().setRepeat(true);
		mediaPlayerComponent.videoSurfaceComponent().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// System.out.println("mouse exited");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// System.out.println("mouse entered");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
//				þessi breytir ekki isPopMenuOpen í false þegar maður velur eitthvað in the popmenu
				if (SwingUtilities.isRightMouseButton(e)) {
					popMenu.setMouseEvent(e);
					popMenu.show(mediaPlayerComponent.videoSurfaceComponent(), e.getPoint().x, e.getPoint().y);
					isPopMenuOpen = popMenu.isVisible();
					MainFrameBus.post(new MainframeEvent(MainframeEvent.EventType.REPAINT));
				} else if (SwingUtilities.isLeftMouseButton(e) && isPopMenuOpen ) {
					MainFrameBus.post(new MainframeEvent(MainframeEvent.EventType.REPAINT));
					isPopMenuOpen = popMenu.isVisible();
					System.out.println("closing pm");
				} else if (SwingUtilities.isLeftMouseButton(e)) {
					MediaPlayerBus.post(new MediaPlayerEvent(MediaPlayerEvent.EventType.PLAYPAUSE));
					isPopMenuOpen = popMenu.isVisible();
				}
			}

		});
		this.add(mediaPlayerComponent);
	}

	public EmbeddedMediaPlayerComponent getMediaPlayerComponent() {
		return mediaPlayerComponent;
	}

	public void showMarquee(String text) {
		Marquee marquee = Marquee.marquee().text(text).size(30).colour(Color.WHITE).timeout(2000)
				.position(MarqueePosition.BOTTOM).opacity(0.8f).enable();
		mediaPlayerComponent.mediaPlayer().marquee().set(marquee);
	}

	public void showCurrentTime() {
		showMarquee(ConCalcs.millisToHMS(mediaPlayerComponent.mediaPlayer().status().time()));
	}
}
