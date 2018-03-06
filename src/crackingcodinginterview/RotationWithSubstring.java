package crackingcodinginterview;

/**
 * 1.8
 * Assume you have a method isSubstring which checks if one word is a substring of
 * another. Given two strings, s1 and s2, write code to check if s2 is a rotation of 
 * s1 using only one call to isSubstring (i.e., “waterbottle” is a rotation of 
 * “erbottlewat”)
 * 
 * @author miriam.mecate
 *
 */
public class RotationWithSubstring {
	
	public static boolean isSubstring(char[] original, char[] toDefine)
	{
		String sOriginal = String.valueOf(original);
		String sToDefine = String.valueOf(toDefine);
		return sOriginal.contains(sToDefine);
	}
	
	
	public static char[] duplicate(char[] original)
	{
		char[] duplicated = new char[(original.length*2)];
		for(int i = 0; i < original.length; i++) {
			int index = original.length + i;
			duplicated[i] = original[i];
			duplicated[index] = original[i];
		}
		return duplicated;
	}
	
	
	public static boolean isRotation(String original, String possibleRotation)
	{	
		//happy cases
		if(original == null && possibleRotation == null) {
			return true;
		}
		if(original.trim().isEmpty() && possibleRotation.trim().isEmpty()) {
			return true;
		}
		if(original.equals(possibleRotation)) {
			return true;
		}
		
		//sad cases
		if(original.length() != possibleRotation.length()) {
			return false;
		}
		if(original == null || original.trim().isEmpty() || 
		   possibleRotation == null || possibleRotation.trim().isEmpty()) {
			return false;
		}

		//prepare
		char[] cOriginal = original.trim().toLowerCase().toCharArray();
		char[] cPossibleRotation = possibleRotation.trim().toLowerCase().toCharArray();
		
		//Sorry, it was not me who figured out the answer.
		//I didn't really had time to think about it when I overhead the solution °~°'
		//So that is why the substring was for? 
		return isSubstring(duplicate(cOriginal), cPossibleRotation);
	}
	
	
	public static void main (String[] args) throws Exception 
	{
		String word = "amor";
		String[] informalTestCases = { "", "or", "roma", "ramora", "mora", "amor", "oram", "ramo", "ramo" };
		
		for(String tc : informalTestCases) {
			System.out.println(word + " >> " + tc + " is " + isRotation(word, tc));
		}
	}

}
