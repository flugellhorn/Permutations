

import java.util.ArrayList;
import java.util.Collections;

public class Permutations {
	
	private static int originallength = 0;
	private static int factorialnum = 0;
	private static int cnt = 0;
	private static ArrayList<String> permuted = new ArrayList<String>();
	
	
	private static void permute(ArrayList<String> wordlist, ArrayList<String> passed){
		String word = "";
		String passedword = "";
		if(wordlist.isEmpty()){
			Collections.reverse(passed);
			permute(passed,wordlist);
		}
		if(!wordlist.isEmpty() && cnt < factorialnum){
			for(String w : wordlist){
				word+= w +",";
			}
			for(String w : passed){
				passedword+= w +",";
			}
			if(!permuted.contains(word + passedword)){
				permuted.add(word + passedword);
			}
			cnt++;
			passed.add(wordlist.get(0));
			wordlist.remove(0);
			permute(wordlist,passed);
		}
	}
	
	private static int factorial(int n){
		if (n == 0)
			return 1;
		else
			return n * factorial(n-1);
	}
	
    private static ArrayList<String> solve(ArrayList<String> data){
        String sentence = data.get(0);
        ArrayList<String> separated = new ArrayList<String>();
        ArrayList<String> passed = new ArrayList<String>();
        String [] words = sentence.split(",");
        for(String word : words){
        	separated.add(word);
        }
        originallength = separated.size();
        factorialnum = factorial(originallength);
        if(separated.size() == 1){
        	permuted.add(separated.get(0));
        }
        else{
        	permute(separated, passed);
        }
        return permuted;
    }
    
    public static void main(String[] args){
    	ArrayList<String> input = new ArrayList<String>();
    	//Add any String of words separated by commas
    	input.add("one,two,three");
    	ArrayList<String> response = solve(input);
    	for(String s : response){
    		System.out.println(s.substring(0, s.length()-1));
    	}
    }
}
