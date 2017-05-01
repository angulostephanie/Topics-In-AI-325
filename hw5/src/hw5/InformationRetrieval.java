package hw5;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Character;

public class InformationRetrieval {

	public static void main(String[] args) throws IOException {
		InformationRetrieval tester = new InformationRetrieval();
		
		tester.parsePreReqs("descriptions.txt");
		tester.parsePreReqs("test.txt");
		
		tester.parseGuidingQuestions("cogsci.txt");
		tester.parseGuidingQuestions("test.txt");
	}
	
	public void parsePreReqs(String textFile) throws IOException {
		List<List<String>> preReqList = new ArrayList<List<String>>();
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream(textFile)));
		try {
		    String line,preReqLine,betterPreReqLine, preReq;
		    char firstD,secondD,thirdD, space, ch, chNext;
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
			        			String parsedLine = "";
			        			for(int j = 1; j < betterPreReqLine.length(); j++) {
					        		if(Character.isUpperCase(betterPreReqLine.charAt(j)) || Character.isDigit(betterPreReqLine.charAt(j)) || Character.isWhitespace(betterPreReqLine.charAt(j))) {
					        			parsedLine = parsedLine + String.valueOf(betterPreReqLine.charAt(j));
					        		}
					        	}
			        			String extraParsedLine = "";
			        			for(int j = 0; j < parsedLine.length();j++) {
			        				if(j < (parsedLine.length() -8)) {
			        					if((Character.isWhitespace(parsedLine.charAt(j)) && Character.isLetter(parsedLine.charAt(j+1)) 
			        							&& Character.isLetter(parsedLine.charAt(j+2)) && Character.isLetter(parsedLine.charAt(j+3)) 
			        							&& Character.isLetter(parsedLine.charAt(j+4)) && Character.isWhitespace(parsedLine.charAt(j+5)) 
			        							&& Character.isDigit(parsedLine.charAt(j+6)) && Character.isDigit(parsedLine.charAt(j+7)) 
			        							&& Character.isDigit(parsedLine.charAt(j+8)))) {
				        					extraParsedLine = extraParsedLine + String.valueOf(parsedLine.substring(j,j+9));
				        				}  else if((Character.isWhitespace(parsedLine.charAt(j)) && Character.isLetter(parsedLine.charAt(j+1)) 
			        							&& Character.isLetter(parsedLine.charAt(j+2)) && Character.isLetter(parsedLine.charAt(j+3)) 
			        							&& Character.isWhitespace(parsedLine.charAt(j+4)) && Character.isDigit(parsedLine.charAt(j+5)) 
			        							&& Character.isDigit(parsedLine.charAt(j+6)) && Character.isDigit(parsedLine.charAt(j+7)))) {
				        					extraParsedLine = extraParsedLine + String.valueOf(parsedLine.substring(j,j+8));
				        				}
			        				} 
			        			}
			        			if(!extraParsedLine.isEmpty()) {
			        				extraParsedLine = extraParsedLine.substring(1) + " ";
			        				int count = 0;
			        				int k = 0;
			        				int m = 0;
			        				List<String> preReqs = new ArrayList<String>();
			        				for(int j = 0; j < extraParsedLine.length(); j++) {
			        					if(Character.isWhitespace(extraParsedLine.charAt(j))) {
			        						count++;
			        						if(count%2 == 0) {
			        							m = j+1;
			        							preReq = extraParsedLine.substring(k,m);
			        							preReqs.add(preReq);
			        							k = j+1;
			        						}
			        					}
			        				}
			        				preReqList.add(preReqs);
			        			}
			        			break; 
			        		} 	
		        		}
		        	}
		        }
		    
		    }
		} finally {
		    br.close();
		}
		System.out.println(Arrays.toString(preReqList.toArray()));
	}
	
	public void parseGuidingQuestions(String textFile) throws IOException {
		List<String> questions = new ArrayList<String>();
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream(textFile)));
		try {
			String line;
			String question = " ";
			while ((line = br.readLine()) != null) {
				if(line.toLowerCase().contains("guiding question")) {
					for(int i = 0; i <= line.length(); i++) {
						if(i < (line.length() - 10)) {
							if((line.toLowerCase().charAt(i) == 'q' && line.toLowerCase().charAt(i+1) == 'u' 
									&& line.toLowerCase().charAt(i+2) == 'e'&& line.toLowerCase().charAt(i+3) == 's'
									&& line.toLowerCase().charAt(i+4) == 't'&& line.toLowerCase().charAt(i+5) == 'i' 
									&& line.toLowerCase().charAt(i+6) == 'o' && line.toLowerCase().charAt(i+7) == 'n' 
									&& line.toLowerCase().charAt(i+8) == ':')) {
										question = line.substring(i+10);
										break;
							}
							if((line.toLowerCase().charAt(i) == 'q' && line.toLowerCase().charAt(i+1) == 'u' 
									&& line.toLowerCase().charAt(i+2) == 'e'&& line.toLowerCase().charAt(i+3) == 's'
									&& line.toLowerCase().charAt(i+4) == 't'&& line.toLowerCase().charAt(i+5) == 'i' 
									&& line.toLowerCase().charAt(i+6) == 'o' && line.toLowerCase().charAt(i+7) == 'n' 
									&& line.toLowerCase().charAt(i+8) == 's'&& line.toLowerCase().charAt(i+9) == ':')) {
										question = line.substring(i+11);
										break;
							}
						}
					}
					questions.add(question);
					//System.out.println(question);
				}
			}
			System.out.println(Arrays.toString(questions.toArray()));
			
		} finally {
			br.close();
		}
	}
}
