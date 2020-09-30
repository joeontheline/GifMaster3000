package logic;

import java.io.File;

public class ExportParameters {
	private File inputFile = null;
	private String startTimeString = null;
	private long startTimeLong = 0;
	private String endTimeString = null;
	private long endTimeLong = 0;
	private Boolean reverse = false;
	private AudioMode audio = AudioMode.NOAUDIO;
	// private OutputFormat outputformat = OutputFormat.WEBM;
	public static enum OutputFormat {
		MP4, WEBM
	}

	public enum AudioMode {
		WITHAUDIO, NOAUDIO
	}

	public enum Pass {
		PASS1, PASS2, NA
	}

	public ExportParameters(File fileIn) {
		this.inputFile = fileIn;
	}

	public File getInputFile() {
		return inputFile;
	}
}