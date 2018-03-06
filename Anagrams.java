package crackingcodinginterview;

import java.util.Arrays;

public class Anagrams {
	
	public static boolean areAnagrams(String original, String possibleAnagram)
	{	
		//happy cases
		if(original == null && possibleAnagram == null) {
			return true;
		}
		if(original.trim().isEmpty() && possibleAnagram.trim().isEmpty()) {
			return true;
		}
		if(original.equals(possibleAnagram)) {
			return true;
		}
		
		//sad cases
		if(original.length() != possibleAnagram.length()) {
			return false;
		}
		if(original == null || original.trim().isEmpty() || 
		   possibleAnagram == null || possibleAnagram.trim().isEmpty()) {
			return false;
		}

		//prepare
		char[] sortedOriginal = original.trim().toLowerCase().toCharArray();
		char[] sortedPossibleAnagram = possibleAnagram.trim().toLowerCase().toCharArray();
		Arrays.sort(sortedOriginal);
		Arrays.sort(sortedPossibleAnagram);
		
		//compare
		for(int i=0; i < sortedOriginal.length; i++) {
			if(sortedOriginal[i] != sortedPossibleAnagram[i]) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main (String[] args) throws Exception 
	{
		String word = "amor";
		String[] informalTestCases = { "o", "amo", "amoo", "amor", "roma", "mora", "aroma" };
		
		for(String tc : informalTestCases) {
			System.out.println(word + " >> " + tc + " is " + areAnagrams(word, tc));
		}
	}

}
