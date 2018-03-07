package hackerrank.datastructures;
import java.util.*;


/**
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 * 
 * @author miriam.mecate
 *
 */
public class BalancedBrackets {
    
    private static final String YES = "YES";
    private static final String NO = "NO";

    private static final String OPENING = "{[(";
    private static final String CLOSING = ")]}";
    private static final String PAIR_A = "{}";
    private static final String PAIR_B = "[]";
    private static final String PAIR_C = "()";
    
    
    static String isBalanced(String s) {
    	Deque<String> stack = new ArrayDeque<String>();
    	
    	if(s.length() % 2 == 1) {
    		return NO;
    	}
    	
    	for(char c : s.toCharArray()) {
    		String bracket = String.valueOf(c);
    		if(OPENING.contains(bracket)) {
                stack.push(bracket);;
    		}
    		else if(CLOSING.contains(bracket)) {
    			if(stack.size() == 0) {
    				return NO;
    			}
                String openingBracket = stack.pop();
                if(!areThesePairs(openingBracket, bracket)) {
                	return NO;
                }
        	}
    		else {
    			return NO;
    		}
    	}
        return YES;    	
    }
    
    public static boolean areThesePairs(String openingBracket, String bracket) {
        return  (PAIR_A.contains(openingBracket) && PAIR_A.contains(bracket)) ||
                (PAIR_B.contains(openingBracket) && PAIR_B.contains(bracket)) ||
                (PAIR_C.contains(openingBracket) && PAIR_C.contains(bracket));
    }

    public static void main(String[] args) {
    	String s1 = "{[()]}"; 
    	String s2 = "{[(])}";
    	String s3 = "{{[[(())]]}}";
        System.out.println(isBalanced(s1));
        System.out.println(isBalanced(s2));
        System.out.println(isBalanced(s3));
        
    	String s4 = "}";
    	String s5 = "{";
    	String s6 = "AB";
    	
        System.out.println(isBalanced(s4));
        System.out.println(isBalanced(s5));
        System.out.println(isBalanced(s6));
    }
}
