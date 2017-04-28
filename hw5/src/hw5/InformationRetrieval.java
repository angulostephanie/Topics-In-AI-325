package hw5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.Character;

public class InformationRetrieval {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream("descriptions.txt")));
		try {
			ArrayList<ArrayList> preReqs = new ArrayList<ArrayList>();
			ArrayList<String> parsedLines = new ArrayList<String>();
		    String line,preReqLine,betterPreReqLine;
		    char firstD,secondD,thirdD, space, ch, chNext;
		    int sum = 0;
		    while ((line = br.readLine()) != null) {
		        if(line.toLowerCase().contains("prerequisite")) {
		        	preReqLine = line;
		        	for(int i = 0; i <= preReqLine.length(); i++) {
		        		if(i < (preReqLine.length()-5)) {
		        			ch = preReqLine.charAt(i); 
		        			chNext = preReqLine.charAt(i+1);
		        			space = preReqLine.charAt(i+2);
		        			firstD = preReqLine.charAt(i+3);
			        		secondD = preReqLine.charAt(i+4);
			        		thirdD = preReqLine.charAt(i+5);
			        		
			        		if(Character.isUpperCase(ch) && Character.isUpperCase(chNext) && Character.isWhitespace(space) 
			        				&& Character.isDigit(firstD) && Character.isDigit(secondD) && Character.isDigit(thirdD)) {
			        			betterPreReqLine = preReqLine;
			        			//System.out.println(betterPreReqLine);
			        			String parsedLine = "";
			        			for(int j = 1; j < betterPreReqLine.length(); j++) {
					        		if(Character.isUpperCase(betterPreReqLine.charAt(j)) || Character.isDigit(betterPreReqLine.charAt(j)) || Character.isWhitespace(betterPreReqLine.charAt(j))) {
					        			parsedLine = parsedLine + String.valueOf(betterPreReqLine.charAt(j));
					        		}
					        	}
			        			String extraParsedLine = "";
			        			for(int j = 0; j < parsedLine.length();j++) {
			        				if(j < (parsedLine.length() -8)) {
			        					if((Character.isLetter(parsedLine.charAt(j)) && Character.isLetter(parsedLine.charAt(j+1)) 
			        							&& Character.isLetter(parsedLine.charAt(j+2)) && Character.isLetter(parsedLine.charAt(j+3)) 
				        						&& Character.isWhitespace(parsedLine.charAt(j+4)) && Character.isDigit(parsedLine.charAt(j+5))
				        						&& Character.isDigit(parsedLine.charAt(j+6)) && Character.isDigit(parsedLine.charAt(j+7)))) {
				        					extraParsedLine = extraParsedLine + String.valueOf(parsedLine.substring(j,j+9));
				        				}  else if((Character.isLetter(parsedLine.charAt(j)) && Character.isLetter(parsedLine.charAt(j+1)) 
				        						&& Character.isLetter(parsedLine.charAt(j+2)) && Character.isWhitespace(parsedLine.charAt(j+3)) 
				        						&& Character.isDigit(parsedLine.charAt(j+4)) && Character.isDigit(parsedLine.charAt(j+5)) 
				        						&& Character.isDigit(parsedLine.charAt(j+6)))) {
				        					extraParsedLine = extraParsedLine + String.valueOf(parsedLine.substring(j,j+8));
				        				}
			        				} 
			        			}
			        			System.out.println(extraParsedLine);
			        			//System.out.println(parsedLine);			        			
			        			sum+= 1; //548
			        			break; //needed so it does not repeat lines
			        		} 	
			        		
		        		}
		        		
		        	}
		        	
		        	
		        }
		    	
		    }
		    System.out.println(sum);
		} finally {
		    br.close();
		}


	}

}
