package functionalprogramming;
import java.io.*;
import java.util.*;

public class LambdasHackerRank {

	interface PerformOperation {
		boolean check(int a);
	}

	static class MyMath {

		public static boolean checker(PerformOperation p, int num) {
			return p.check(num);
		}

		// Write your code here
		public PerformOperation isOdd() {
			return (int num) -> num % 2 != 0;
		}

		public PerformOperation isPrime() {
			return (int num) -> {
				if(num <= 1) return false;
				else if(num == 2 || num == 3) return true;
				else if(num%2 == 0 || num%3 == 0) return false;
				for(int i=5; i*i <= num; i += 6) {
					if(num%i == 0 || num%(i+2) == 0) {
						return false;
					}
				}
				return true;
			};
		}

		
		public PerformOperation isPalindrome() {
			return (int num) -> {
				StringBuilder sb = new StringBuilder(Integer.toString(num));
				return num == Integer.parseInt(sb.reverse().toString());
			};
		}
	}


	public static void main(String[] args) throws IOException 
	{
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T--> 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.isOdd();
				ret = MyMath.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = ob.isPrime();
				ret = MyMath.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ob.isPalindrome();
				ret = MyMath.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
			}
			System.out.println(ans);
		}
	}

}
