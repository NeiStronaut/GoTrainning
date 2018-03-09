package hackerrank.datastructures;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/java-dequeue/problem
 * 
 * @author miriam.mecate
 *
 */
public class NeighboursNumbersOnDeque {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<>();
		Map<Integer, Integer> uniques = new HashMap<>();
		int max = 0;

		int n = in.nextInt();
		int m = in.nextInt();

		for (int i = 0; i < n; i++) {
			Integer num = in.nextInt();
			if(deque.size() <= m) {
				deque.add(num);
				uniques.put(num, uniques.getOrDefault(num, 0)+1);
			}
			if(deque.size() == m) {
				if(uniques.size() > max) {
					max = uniques.size();
				}
				Integer remove = deque.remove();
				Integer value = uniques.get(remove);
				if(value > 1) {
					uniques.put(remove, value-1);
				}
				else {
					uniques.remove(remove);
				}
			}
		}
		System.out.println(max);
		in.close();
	}
}
