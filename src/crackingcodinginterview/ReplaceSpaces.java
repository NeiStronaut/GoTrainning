package crackingcodinginterview;

/**
 * 1.5
 * Write a method to replace all spaces in a string with ‘%20’
 * 
 * @author miriam.mecate
 *
 */
public class ReplaceSpaces {
	
	public static String replaceWhiteSpaces(String input)
	{	
		//no white spaces in null or empty strings
		if(input == null || input.isEmpty()) {
			return input;
		}
		
		char[] characters = input.toCharArray();
		
		//cuenta espacios O(n)
		int spaces = 0;
		for(int i = 0; i < characters.length; i++) {				
			if(characters[i] == ' ') {
				spaces++;
			}
		}
		
		//O(2 *n) becomes O(n)
		char[] newCharacters = new char[(characters.length - spaces + (spaces * 3))];
		int j = 0;
		for(int i = 0; i < characters.length; i++) {
			if(characters[i] == ' ') {
				newCharacters[j] = '%';
				newCharacters[j+1] = '2';
				newCharacters[j+2] = '0';
				j += 3;
			}
			else {
				newCharacters[j] = characters[i];
				j++;
			}
		}
		
		return String.valueOf(newCharacters);
	}
	
	
	public static void main (String[] args) throws Exception {
		String[] informalTestCases = { "", "a ", " ", "a> <a", " <space", " <space> ", "space> ", "nospace", "m u l t i p l e", " 1 1 1 "};
		
		for(String tc : informalTestCases) {
			System.out.println(tc);
			System.out.println(replaceWhiteSpaces(tc));
		}
	}

}
