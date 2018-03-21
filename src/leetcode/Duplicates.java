package leetcode;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Duplicates {

	public static boolean containsDuplicate(int[] nums) 
	{   
		if(nums.length == 0) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		for(int num : nums) {
			Integer up = Integer.valueOf(num);
			if(set.contains(up)) {
				return false;
			}
			set.add(up);
		}
		return true;
	}


	public static boolean containsNearbyDuplicate(int[] nums, int k) {

		Set<Integer> uniques = new HashSet<>();
		Queue<Integer> subset = new ArrayDeque<>();

		if(nums.length <= 0 || k <= 0) {
			return false;
		}
		for(int i = 0; i <= k && i < nums.length; i++) {
			subset.add(nums[i]);
			if(uniques.contains(nums[i])) {
				return true;
			}
			uniques.add(nums[i]);
		}

		int index = k+1;
		int loops = nums.length - k;
		while(loops > 0 && index < nums.length) {
			uniques.remove(subset.poll());
			subset.add(nums[index]);
			if(uniques.contains(nums[index])) {
				return true;
			}
			uniques.add(nums[index]);
			index++;
		}
		return false;
	}


	static class ValuePair implements Comparable<ValuePair> {
		int value, position;

		ValuePair(int value, int position) {
			this.value = value; 
			this.position = position;
		}
		public int compareTo(ValuePair pair) {
			return (this.value - pair.value);
		}	
	}


	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) 
	{

		if(nums.length <= 1 || k <= 0 || t < 0) {
			return false;
		}

		ValuePair[] pairs = new ValuePair[nums.length];

		for(int i = 0; i < nums.length; i++) {
			pairs[i] = new ValuePair(nums[i], i); 	
		}
		Arrays.sort(pairs);	

		for(int i = 0; i < pairs.length - 1; i++) {
			for(int j = i + 1; j < pairs.length && almost(pairs[i].value, pairs[j].value, t); j++) {
				if(Math.abs(pairs[i].position - pairs[j].position) <= k) {
					return true;            	
				}
			}
		}
		return false;
	}

	public static boolean almost(int iValue, int jValue, int t) {
		if(iValue <= Integer.MIN_VALUE || iValue >= Integer.MAX_VALUE ||
		   jValue <= Integer.MIN_VALUE || jValue >= Integer.MAX_VALUE 
		  ) {
			BigInteger val = BigInteger.valueOf(iValue).subtract(BigInteger.valueOf(jValue)).abs();
			int dif = val.compareTo(BigInteger.valueOf(t));
			if(dif <= 0) {
				return true;
			}
		} 
		else {
			long dif = iValue - jValue;
			long abs = dif < 0l ? dif*-1l : dif;
			if(abs <= t) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {

		System.out.println(containsDuplicate(new int[] {}));
		System.out.println(containsDuplicate(new int[] {1}));
		System.out.println(containsDuplicate(new int[] {1, 2, 3, 4}));
		System.out.println(containsDuplicate(new int[] {1, 1, 2, 3}));
		System.out.println(containsDuplicate(new int[] {1, 2, 2, 3}));
		System.out.println(containsDuplicate(new int[] {1, 2, 3, 3}));
		System.out.println(containsDuplicate(new int[] {1, 1, 1, 1}));

		System.out.println(containsNearbyDuplicate(new int[] {-1, -1}, 1));
		System.out.println(containsNearbyDuplicate(new int[] {}, 0));
		System.out.println(containsNearbyDuplicate(new int[] {1}, 1));
		System.out.println(containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
		System.out.println(containsNearbyDuplicate(new int[]{4, 1, 2, 3, 1, 5}, 3));
		System.out.println(containsNearbyDuplicate(new int[]{1, 2, 1}, 1));

		System.out.println(containsNearbyAlmostDuplicate(new int[] {-1, -1}, 1, 0));
		System.out.println(containsNearbyAlmostDuplicate(new int[] {-1, 2147483647}, 1, 2147483647));
		System.out.println(containsNearbyAlmostDuplicate(new int[] {2147483647, -2147483647}, 1, 2147483647));
		System.out.println(containsNearbyAlmostDuplicate(new int[] {1, 0, 1, 1}, 1, 0));

	}

}
