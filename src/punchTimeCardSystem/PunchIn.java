package punchTimeCardSystem;

import java.io.File;
import java.io.IOException;

public class PunchIn extends FileIO {
	private String fileName="punchIn.txt";	
	public PunchIn(String userId,String currentTime) throws IOException{
		File file = new File(fileName);
		readData(file);
	    writeData(file,userId,currentTime);

		
	}

}
