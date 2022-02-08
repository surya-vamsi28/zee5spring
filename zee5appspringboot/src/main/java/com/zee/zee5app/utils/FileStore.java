package com.zee.zee5app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;


import com.zee.zee5app.dto.Episodes;
@Component

public class FileStore {
	public String storeepisode(Episodes episode,String fromadd,String toadd) {
		FileInputStream fileinputstream = null;
		FileOutputStream fileoutputstream = null;
		
		try {
			fileinputstream = new FileInputStream(fromadd);
			File file = new File(fromadd);
			long filesize = file.length();
			byte[] allbytes = new byte[(int) filesize];
			fileinputstream.read(allbytes);
			episode.setTrailer(toadd + file.getName());
			fileoutputstream = new FileOutputStream(toadd + file.getName());
			fileoutputstream.write(allbytes);
			return "Success";
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return "fail";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "fail";
			
		}
		
		
	}
	public String epistore() {
		return null;
		
		
	}
}
