package punchTimeCardSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ManagePunchOut extends FileIO{
	private String fileName="punchOut.txt";
	public ManagePunchOut() throws IOException{

		File file = new File(fileName);
		readData(file);
		
	}
	public String[] getData(){
		return data;
	}
	
	

}

