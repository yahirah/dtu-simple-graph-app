package com.aw.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputParser {
	
	static public void printToFile(String fileName, String message) {
		BufferedWriter bWriter = null;
		try {
			bWriter = new BufferedWriter(new FileWriter(fileName));
			bWriter.write(message);
			bWriter.flush();
		} catch (IOException e) {
			System.out.println("Could not write to output file");
			System.exit(-1);
		}
		
		
	}

}
