package com.aw.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		String fileName = "resources/test.txt";
		BufferedReader breader = null;
		try {
			breader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputParser parser = new InputParser(breader);
		int[][] array = parser.generateArray();
		parser.displayArray();
		
		PathSearcher pSearcher = new DepthFirstPathSearcher(array, parser.getVertNumber());
		
		
	
	}

}
