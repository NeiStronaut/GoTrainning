package hackerrank.datastructures;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/java-hashset/problem
 * 
 * @author miriam.mecate
 */
public class NamesOnHashset {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		String [] pair_left = new String[t];
		String [] pair_right = new String[t];

		for (int i = 0; i < t; i++) {
			pair_left[i] = s.next();
			pair_right[i] = s.next();
		}
		//Write your code here
		HashSet<String> personSet = new HashSet<String>();
		for (int i = 0; i < t; i++) {
			String person = pair_left[i] + " " + pair_right[i];
			personSet.add(person);
			System.out.println(personSet.size());
		}
		s.close();
	}
}
