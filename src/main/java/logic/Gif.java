package logic;

import java.io.File;

public class Gif {
	private ExportParameters exportParameters = null;
	
	public Gif(File inputFile) {
		exportParameters = new ExportParameters(inputFile);
	}

	public File getInputFile() {
		return exportParameters.getInputFile();
	}
}
