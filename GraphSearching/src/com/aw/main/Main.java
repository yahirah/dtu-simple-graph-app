package com.aw.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @author Anna Walach
	 */
	public static void main(String[] args) throws IOException {

		String inFileName, outFileName;
		if(args.length != 3) {
			System.out.println("Too few or too much arguments! Will proceed with test data...");
			inFileName = "resources/test.txt";
			outFileName = "results.txt";
		} else {
			inFileName = args[1];
			outFileName = args[2];
		}
		BufferedReader bReader = null;
		try {
			bReader = new BufferedReader(new FileReader(inFileName));
		} catch (FileNotFoundException e) {
			System.out.println("File was not found!");
			System.exit(-1);
		}
		
		InputParser parser = new InputParser(bReader);
		int[][] array = parser.generateArray();
		parser.displayArray();
		
		PathSearcher pSearcher = new DepthFirstPathSearcher(array, parser.getVertNumber());
		String result = pSearcher.searchForPath(parser.getSource(), parser.getTarget());
		OutputParser.printToFile(outFileName, result);
		//System.out.println(result);
		
	
	}

}
