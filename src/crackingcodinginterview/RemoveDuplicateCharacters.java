package crackingcodinginterview;

/**
 * 1.3
 * Design an algorithm and write code to remove the duplicate characters in a string
 * without using any additional buffer. NOTE: One or two additional variables are fine.
 * An extra copy of the array is not.
 * FOLLOW UP
 * Write the test cases for this method.
 * 
 * @author miriam.mecate
 *
 */
public class RemoveDuplicateCharacters {
	
	public static String removeDuplicates(String input)
	{	
		//no duplicates in null or empty strings
		if(input == null || input.isEmpty()) {
			return input;
		}
		
		char[] characters = input.toCharArray();
		int maxLength = characters.length;
		
		//Complexity O(n * m!) T_T
		for(int i = 0; i < maxLength; i++) {			
			for(int j = i+1; j < maxLength; j++)  {
				
				if(characters[j] == characters[i]) {
					for(int k = j; k < maxLength-1; k++)  {
						characters[k] = characters[k+1];
					}
					characters[maxLength-1] = '\0';
					maxLength--;
					j=i; //reset
				}
			}
		}
		
		return String.valueOf(characters);
	}
	
	
	public static void main (String[] args) throws Exception {
		String[] informalTestCases = { "", "a", "abc", "aa", "111", "cccccccc", "avalancha", "aabbccddeeff", "aaaaaaaaaaaa------------"};
		
		for(String tc : informalTestCases) {
			System.out.println(tc);
			System.out.println(removeDuplicates(tc));
		}
	}

}
