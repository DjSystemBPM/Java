package com.java.stream.filter.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiltroSinLambda {

	 public static void main(String[] args) {

	        List<String> lines = Arrays.asList("spring", "node", "alfredo");
	        List<String> result = getFilterOutput(lines, "alfredo");
	        for (String temp : result) {
	            System.out.println(temp);    //output : spring, node
	        }

	    }

	    private static List<String> getFilterOutput(List<String> lines, String filter) {
	        List<String> result = new ArrayList<>();
	        for (String line : lines) {
	            if (!"alfredo".equals(line)) { // we dont like mkyong
	                result.add(line);
	            }
	        }
	        return result;
	    }
}
