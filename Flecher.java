/**
 * CS312 Assignment 5.
 * 
 * On my honor, < NAME >, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play calculate the readability of text using the Flesch Reading Ease Test.
 *
 */

// imports 
import java.util.StringTokenizer;
import java.util.Scanner;

// main class 
public class Flech {

	// main method 
    public static void main(String[] args) {
        
    	// variables
    	String sentence;
    	int detectedSentences;
    	int detectedWords;
    	int detectedSyllables;
    	double socore;
    	
    	// initializing the scanner 
        Scanner keyboard = new Scanner(System.in);
        
        // printing data to screen 
        System.out.println("Insert your text bellow : ");
        sentence = keyboard.nextLine();
        
        // setting the data to a variable 
        detectedSentences = detectSentences(sentence);
        detectedWords = detectWords(sentence);
        detectedSyllables = detectSyllables(sentence);
        socore = readabilityIndex(detectedWords, detectedSentences, detectedSyllables);
        
        // printing the data to the screen 
        output(detectedWords,detectedSentences, detectedSyllables, socore);
        
        // closing the keyboard 
        keyboard.close();
    }
     
	
	// method used to detect sentences in a paragraph 
	public static int detectSentences(String inputSentence) {
		
		// this is to keep count of sentences 
		int count = 0;
    	
		// char of items to detect
		char[] detect = {'.', '!', '?', ':', ';'};
		
		// looping in the sentence lenght 
    	for(int t = 0;t<inputSentence.length();t++)
    	{
    		// looking to detect the items 
    		for( char i : detect) {
    			
    			// detecting if the items match 
    			if(inputSentence.charAt(t) == i) {
    				
    				// increasing count 
    				count++;
    			}
    		}
    		
    	}
    	
    	// detecting if there is no count 
    	if(count == 0)
    	{
    		// increasing count 
    		count = 1;
    	}
		
    	// Returning the count
		return count;
	}

	// method used to detect words in a paragraph
	public static int detectWords(String inputSentence) {
		
		// initializing the StringTokenizer method  
		StringTokenizer tokens = new StringTokenizer(inputSentence);
		
		// setting a variable 
		int count = 0;
		
		// setting count to a value
		count = tokens.countTokens();
		 System.out.println("this is the words " + tokens.countTokens() );
		 
		// returning count
		return count;
	}
	
	// method used to detect syllables in a paragraph
	public static int detectSyllables(String inputSentence) {
		
		// variable 
		int count = 0;
		
		// making all the letters lower case so it can be matched 
		inputSentence = inputSentence.toLowerCase();
		
		// char of items to detect
		char[] letters = {'a', 'e', 'i', 'o', 'u'};
		
		// for loop to go through the sentence 
    	for(int t = 0;t<inputSentence.length();t++)
    	{
    		// looping to see if letters match 
    		for(char i : letters) {
    			
    			// detecting if there is a match  
    			if(inputSentence.charAt(t) == i) {
    				
    				// increasing count
    				count ++;
    				
    				// checking if we are in the last number 
    				if(t<inputSentence.length()-1 ) {
    					
    					// looping to see if letters match 
    		    		for(char x : letters) {
    		    			
	    					// checking if there is a match ahead
	    					if(inputSentence.charAt(t+1) == x) {
	    						
	    						// decreasing count 
	    						count--;
	    					}
    		    		}
    					
    				}
    				
    			}
    			
    		}
    		
    		
    	}
		
    	// Returning the count
		return count;
	}
	
	// method used to detect (the something score according to the paragraph )
	public static double readabilityIndex(int words, int sentence, int sylables) {
		
		// creating a index 
		double Index = 0;
		
		// Calculating the data for index 
		Index = 206.835 - 1.015*((double)words/sentence)-84.6*((double)sylables/words);
		
		// rounding index 
		Index = (double)Math.round(Index*10d)/10d;
		
		// Returning the index 
		return Index;
	}
    
	// method used to print the data 
	public static void output(int words, int sentence, int sylables, double theThingScore) {
		
		// printing the data to the user 
		System.out.println("");
		System.out.println("Number of sentences: " + sentence);
    	System.out.println("Number of words: " + words);
    	System.out.println("Number of Syllables: " + sylables);
    	System.out.println("Flesch score: " + theThingScore);
		
	}
	
}






















