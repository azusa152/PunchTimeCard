package punchTimeCardSystem;

import java.io.File;
import java.io.IOException;

public class PunchOut extends FileIO {
	private String fileName="punchOut.txt";	
	public PunchOut(String userId,String currentTime) throws IOException{
		File file = new File(fileName);
		readData(file);
	    writeData(file,userId,currentTime);

		
	}

}
