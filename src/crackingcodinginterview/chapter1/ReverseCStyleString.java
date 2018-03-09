package crackingcodinginterview.chapter1;

/**
 * 1.2
 * Write code to reverse a C-Style String. (C-String means that “abcd” is represented as
 * five characters, including the null character.)
 * 
 * @author miriam.mecate
 *
 */
public class ReverseCStyleString {
	
	public static void reverse(String input) throws Exception 
	{	
		//reverse of null is null
		if(input == null || input.isEmpty()) {
			return;
		}
		char[] characters = input.toCharArray();

		//Complexity O(n-1)
		for(int i = characters.length-2; i >= 0; i--) {			
			System.out.print(characters[i]);
		}
		//Assuming last char will always be '\0'
		System.out.print(characters[characters.length-1]);
		System.out.println();
	}
	
	
	public static void main (String[] args) throws Exception 
	{
		String[] informalTestCases = {"a\0", "ab\0", "aba\0", "abcdefgh\0", "!.ñadf\0"};
		
		for(String tc : informalTestCases) {
			System.out.println(tc);
			reverse(tc);
		}
	}

}
