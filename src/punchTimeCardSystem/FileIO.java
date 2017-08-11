package punchTimeCardSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	protected String[] data=new String[10000];
	private int numberOfData;
	
	protected void readData(File file) throws IOException {
		
		numberOfData=0;
		if(file.exists())
		{
			FileReader fr=new FileReader(file);
		    BufferedReader br=new BufferedReader(fr);
		    
		      while ((data[numberOfData]=br.readLine()) != null) {
		    	numberOfData++;
		        }
		    fr.close();
		}
	}
	
	protected void writeData(File file,String userId,String currentTime) throws IOException{
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(fw);
		if(getNumberOfData()!=0)
		{
			for(int j=0;j<getNumberOfData();j++)
			{
				 bw.write(data[j]);
				 bw.newLine();
			}
		}
		bw.write(userId+" "+currentTime);
		bw.newLine();
		bw.flush();
		fw.flush();
		bw.close();
		fw.close();
		
	}
	public int getNumberOfData(){
		return numberOfData;
	}

}
