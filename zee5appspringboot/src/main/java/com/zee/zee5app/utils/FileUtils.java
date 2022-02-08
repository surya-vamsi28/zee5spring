package com.zee.zee5app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class FileUtils {
	public byte[] readFile(File file) throws IOException {
		
			FileInputStream fileinputstream = new FileInputStream(file);
			byte[] allBytes = new byte[(int) file.length()];
			fileinputstream.read(allBytes);
			return allBytes;
		
		
	}
	
	
	public String writeFile(byte[] allBytes, String filename) {
		FileOutputStream fileoutputstream;
		try {
			fileoutputstream = new FileOutputStream("C:\\movies\\seriesstore\\" + filename);
			fileoutputstream.write(allBytes);
			return"success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
		return "fail";
		}
		
		
		
		
		
	}
	
	
}
