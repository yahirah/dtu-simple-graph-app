package com.aw.main;

import java.io.BufferedReader;
import java.io.IOException;
public class InputParser {
	
	private BufferedReader bReader;
	private Integer vertNumber;
	int[][] edges = null;

	public InputParser(BufferedReader breader) {
		bReader = breader;
	}

	public int[][] generateArray() throws IOException {
		if(bReader == null) {
			System.out.println("There is no file assigned to this parser");
			return new int[1][1];
		}
		String line = bReader.readLine();
		vertNumber = Integer.parseInt(line);
		
		edges = new int[vertNumber][vertNumber]; //initialize to zero
		
		while((line = bReader.readLine()) != null) {
			int spaceIndex = line.indexOf(" ");
			
			String firstVertex = line.substring(0, spaceIndex);
			String secondVertex = line.substring(spaceIndex+1);			
			setEdge(firstVertex, secondVertex);
			
		}
		
		removeAnyLoops();
		return edges;
		
	}

	private void removeAnyLoops() {
		for(int i = 0; i < vertNumber; i++) {
			edges[i][i] = 0;
		}
	}

	private void setEdge(String firstVertex, String secondVertex) {
		edges[Integer.parseInt(firstVertex)][Integer.parseInt(secondVertex)] = 1;
		edges[Integer.parseInt(secondVertex)][Integer.parseInt(firstVertex)] = 1;

		
	}
	
	public void displayArray() {
		if(edges == null) {
			System.out.println("There is no array asissgned to this parser. Please, use 'generateArray()' function");
			return;
		}
		for(int i = 0; i < vertNumber; i++) {
			for(int j = 0; j < vertNumber; j++) {
				System.out.print(edges[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

	public Integer getVertNumber() {
		return vertNumber;
	}

}
