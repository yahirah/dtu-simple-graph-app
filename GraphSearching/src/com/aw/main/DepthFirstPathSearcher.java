package com.aw.main;

import java.util.Stack;
import java.util.TreeMap;

public class DepthFirstPathSearcher implements PathSearcher{
	
	
	
	Stack<Integer> stack = new Stack<>();
	private int[][] edges;
	private Integer verticesNumber;
	private int[] visited;
	private String solution = new String();

	public DepthFirstPathSearcher(int[][] array, Integer vertNumber) {
		edges = array;
		verticesNumber = vertNumber;
		visited = new int[vertNumber];
	}
	/*
	@Override
	public String searchForPath(Integer source, Integer target) {
		stack.push(source);
		while(stack.size() >= 1) {
			int i = stack.pop();
			if (i == target) {
				return "Found!";
			} else {
				for (int j = 0; j < verticesNumber; j++) {
					if(edges[i][j] == 1 && visited[j] == 0)
						stack.push(j);
				}
				visited[i] = 1;
			}
			
		}
		
		return "Not found :(";
	} */
	
	@Override
	public String searchForPath(Integer source, Integer target) {
		if (searchRecursively(source, target) == true) {
			System.out.println(source + ".");
			return solution += "\n Found the path.";
		} else {
			return solution = "Path not found";
		}
	}

	public boolean searchRecursively(Integer element, Integer target) {
		if(element == target) {
			System.out.println("Start : ");
			solution = "Start : ";
			return true;
		}
		visited[element] = 1;
		for(int j = 0; j < verticesNumber; j++) {
			if(edges[element][j] == 1 && visited[j] == 0) {
				if(searchRecursively(j, target) == true) {
					System.out.print(j + ", ");
					solution += j + ", ";
					return true;
				}
			}
			
		}
		return false;
	}
	@Override
	public String displayLastResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
