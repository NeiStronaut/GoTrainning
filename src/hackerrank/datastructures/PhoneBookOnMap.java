package hackerrank.datastructures;
import java.util.*;


/**
 * https://www.hackerrank.com/challenges/phone-book/problem
 * 
 * @author miriam.mecate
 *
 */
public class PhoneBookOnMap {
	
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		Map<String, Integer> phonebook = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			phonebook.put(name, phone);
			in.nextLine();
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
			Integer phone=phonebook.get(s);
			String result = "Not found";
			if(phone != null) 
				result = s+"="+phone;
			System.out.println(result);
		}
		in.close();
	}
}
