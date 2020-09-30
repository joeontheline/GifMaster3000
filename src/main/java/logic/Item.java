package logic;

import java.io.File;

public class Item {
	int ID;
	private ExportParameters expo = null;
	Item(File f){
		this.expo = new ExportParameters(f);
	}
	
}
