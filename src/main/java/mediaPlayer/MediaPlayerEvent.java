package mediaPlayer;
import java.io.File;

public class MediaPlayerEvent {

	private File inputFile = null;
	private String type = null;
	private String marqueeText = null;
	private int skipLength;
	private float seekBarPosition;
	public static enum EventType {
		FILESELECTION, PLAYPAUSE, STOP, SKIPBACK, SKIPFORWARD, 
		SLOWER, FASTER, SKIPLENGTHCHANGE, MUTE, SETPOSITION, SHOWMARQUEE
	}

	public MediaPlayerEvent(EventType type, File f) {
		this.inputFile = f;
		this.type = type.toString();
	}

	public MediaPlayerEvent(EventType type, int p) {
		this.skipLength = p;
		this.type = type.toString();
	}

	public MediaPlayerEvent(EventType type, float f) {
		this.seekBarPosition = f;
		this.type = type.toString();
	}

	public MediaPlayerEvent(EventType type) {
		this.type = type.toString();
	}
	
	public MediaPlayerEvent(EventType type, String marqueeText) {
		this.type = type.toString();
		this.marqueeText = marqueeText;
	}

	public File getInputFile() {
		return inputFile;
	}

	public String getType() {
		return type;
	}

	public int getSkipLength() {
		return skipLength;
	}

	public float getSeekBarPosition() {
		return seekBarPosition;
	}

	public String getMarqueeText() {
		return marqueeText;
	}
}
