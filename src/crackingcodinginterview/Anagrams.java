package crackingcodinginterview;

import java.util.Arrays;

/**
 * 1.4
 * Write a method to decide if two strings are anagrams or not
 * 
 * @author miriam.mecate
 *
 */
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
		
		//Complexity of sorting Arrays O(n log2 n)
		Arrays.sort(sortedOriginal);
		Arrays.sort(sortedPossibleAnagram);
		
		//compare
		//Complexity O(n)
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
