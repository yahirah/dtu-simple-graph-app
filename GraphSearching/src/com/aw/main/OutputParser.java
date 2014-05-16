package com.aw.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputParser {
	
	static public void printToFile(String fileName, String message) {
		BufferedWriter bWriter = null;
		try {
			bWriter = new BufferedWriter(new FileWriter("results" + System.currentTimeMillis() + ".txt"));
			bWriter.write(message);
			bWriter.flush();
		} catch (IOException e) {
			System.out.println("Something is not right with this file");
			e.printStackTrace();
		}
		
		
	}

}
