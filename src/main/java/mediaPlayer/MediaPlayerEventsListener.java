package mediaPlayer;

import java.awt.Color;

import com.google.common.eventbus.Subscribe;

import logic.ConCalcs;
import logic.Ebus;
import uk.co.caprica.vlcj.player.base.Marquee;
import uk.co.caprica.vlcj.player.base.MarqueePosition;

public class MediaPlayerEventsListener {
	private MediaPlayerComponent mediaPlayerComponent = null;
	private int skipLength;
	
	private MediaPlayerEvent lastMediaControlsEvent;

	MediaPlayerEventsListener(MediaPlayerComponent mpc) {
		this.mediaPlayerComponent = mpc;
		Ebus.register(this);
	}

	@Subscribe
	public void listenInteger(String event) {
		System.out.println("Bus event message: " + event);
	}

	@Subscribe
	public void listenMediaControlsEvent(MediaPlayerEvent event) {
		lastMediaControlsEvent = event;
		switch (event.getType()) {
			case "FILESELECTION" :
//				System.out.println("MediaControlsEvent \tType:" + event.getType());
				mediaPlayerComponent.mediaPlayer().media().play(event.getInputFile().getPath());
				break;
			case "PLAYPAUSE" :
//				System.out.println("MediaControlsEvent \tType:" + event.getType());
				if(mediaPlayerComponent.mediaPlayer().status().isPlaying())
					mediaPlayerComponent.mediaPlayer().controls().pause();
				else mediaPlayerComponent.mediaPlayer().controls().play();
				break;
			case "SKIPLENGTHCHANGE" :
//				System.out.println("MediaControlsEvent \tType:" + event.getType());
				this.skipLength = event.getSkipLength();
				break;
			case "SKIPBACK" :
//				System.out.println("MediaControlsEvent \tType:" + event.getType());
				mediaPlayerComponent.mediaPlayer().controls().skipTime(-(this.skipLength));
				Ebus.post(new MediaPlayerEvent( MediaPlayerEvent.EventType.SHOWMARQUEE, ConCalcs.millisToHMS(mediaPlayerComponent.mediaPlayer().status().time())) );
				break;
			case "SKIPFORWARD" :
//				System.out.println("MediaControlsEvent \tType:" + event.getType());
				mediaPlayerComponent.mediaPlayer().controls().skipTime(this.skipLength);
				Ebus.post(new MediaPlayerEvent( MediaPlayerEvent.EventType.SHOWMARQUEE, ConCalcs.millisToHMS(mediaPlayerComponent.mediaPlayer().status().time())) );
				break;
			case "MUTE" :
//				System.out.println("MediaControlsEvent \tType:" + event.getType());
				mediaPlayerComponent.mediaPlayer().audio().mute();
				break;
			case "SLOWER" :
//				System.out.println("MediaControlsEvent \tType:" + event.getType());
//				set the playback rate with the Float.sum() of the current rate +/- change value
				mediaPlayerComponent.mediaPlayer().controls().setRate(Float.sum(mediaPlayerComponent.mediaPlayer().status().rate(), -0.2f));
//				mediaPlayerComponent.showMarquee(String.valueOf(mediaPlayerComponent.mediaPlayer().status().rate()));
				Ebus.post(new MediaPlayerEvent( MediaPlayerEvent.EventType.SHOWMARQUEE, String.valueOf(mediaPlayerComponent.mediaPlayer().status().rate())) );
				break;
			case "FASTER" :
//				System.out.println("MediaControlsEvent \tType:" + event.getType());
//				set the playback rate with the Float.sum() of the current rate +/- change value
				mediaPlayerComponent.mediaPlayer().controls().setRate(Float.sum(mediaPlayerComponent.mediaPlayer().status().rate(), 0.2f));
//				mediaPlayerComponent.showMarquee(String.valueOf(mediaPlayerComponent.mediaPlayer().status().rate()));
				Ebus.post(new MediaPlayerEvent( MediaPlayerEvent.EventType.SHOWMARQUEE, String.valueOf(mediaPlayerComponent.mediaPlayer().status().rate())) );
				break;
			case "STOP" :
//				System.out.println("MediaControlsEvent \tType:" + event.getType());
				mediaPlayerComponent.mediaPlayer().controls().stop();
				break;
			case "SETPOSITION" :
//				System.out.println("MediaControlsEvent \tType:" + event.getType());
				mediaPlayerComponent.mediaPlayer().controls().setPosition(event.getSeekBarPosition());
				Ebus.post(new MediaPlayerEvent( MediaPlayerEvent.EventType.SHOWMARQUEE, ConCalcs.millisToHMS(mediaPlayerComponent.mediaPlayer().status().time())) );
				break;
			case "SHOWMARQUEE" :
//				System.out.println("MediaControlsEvent \tType:" + event.getType());
				Marquee marquee = Marquee.marquee().text(event.getMarqueeText()).size(30).colour(Color.WHITE).timeout(3000)
						.position(MarqueePosition.BOTTOM).opacity(0.8f).enable();
				mediaPlayerComponent.mediaPlayer().marquee().set(marquee);
				break;
				
			default :
				break;
		}
		
	}
}
