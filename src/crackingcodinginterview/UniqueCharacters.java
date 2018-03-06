package crackingcodinginterview;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.1
 * Implement an algorithm to determine if a string has all unique characters. What if 
 * you can not use additional data structures?
 * 
 * @author miriam.mecate
 *
 */
public class UniqueCharacters {
	
	public static boolean hasAllUniqueCharacters(String input) throws Exception 
	{
		Set<Character> nonRepeated = new HashSet<>();
		
		if(input == null) {
			throw new Exception("Do not know what to do with a null input");
		}
		//Complexity O(n)
		for(char character : input.toCharArray()) {
			if(nonRepeated.contains(character)) {
				return false;
			}
			//TODO Complexity O(Log2 n) as it is a hash?
			nonRepeated.add(character);
		}
		return true;
	}
	
	
	public static boolean hasAllUniqueCharactersNoCollection(String input) throws Exception 
	{
		StringBuilder nonRepeated = new StringBuilder();
		
		if(input == null) {
			throw new Exception("Do not know what to do with a null input");
		}

		//Complexity O(n)
		for(char character : input.toCharArray()) {
			if(nonRepeated.indexOf(String.valueOf(character)) != -1) {
				return false;
			}
			nonRepeated.append(character);
		}
		return true;
	}
	
	
	public static boolean hasAllUniqueCharactersNoNothing(String input) throws Exception 
	{		
		if(input == null) {
			throw new Exception("Do not know what to do with a null input");
		}
		char[] characters = input.toCharArray();

		//Complexity O(n!)
		for(int i = 0; i < characters.length; i++) {			
			for(int j = i+1; j < characters.length; j++)  {
				if(characters[i] == characters[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static void main (String[] args) throws Exception 
	{
		String[] informalTestCases = {"a", "aa", "aba", "acaba", "lamb", "abcdefgh", "!.ñadfadf", "!.ñadf"};
		
		for(String tc : informalTestCases) {
			System.out.println(tc);
			System.out.println(hasAllUniqueCharacters(tc));
			System.out.println(hasAllUniqueCharactersNoCollection(tc));
			System.out.println(hasAllUniqueCharactersNoNothing(tc));
		}		
		
	}

}