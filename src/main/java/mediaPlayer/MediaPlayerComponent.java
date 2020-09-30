package mediaPlayer;

import java.awt.Color;

import uk.co.caprica.vlcj.player.base.Marquee;
import uk.co.caprica.vlcj.player.base.MarqueePosition;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class MediaPlayerComponent extends EmbeddedMediaPlayerComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = -233730918473378351L;

	public MediaPlayerComponent() {
		MediaPlayerEventsListener mel = new MediaPlayerEventsListener(this);
	}
	
//	public void showMarquee(String text) {
//		Marquee marquee = Marquee.marquee().text(text).size(30).colour(Color.WHITE).timeout(3000)
//				.position(MarqueePosition.BOTTOM).opacity(0.8f).enable();
//		this.mediaPlayer().marquee().set(marquee);
//	}
}
