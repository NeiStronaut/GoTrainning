package hackerrank.datastructures;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/java-dequeue/problem
 * 
 * @author miriam.mecate
 *
 */
public class NeighboursNumbersOnDeque {

	//94531
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>();
		SortedSet<Integer> uniques = new TreeSet<>();

		int n = 100000;
		int m = 99277;
		int[] xxx = {5, 3, 5, 2, 3, 2};

		Map<Integer, Integer> uniqueNumbers = new HashMap<>();
		if(n < m) {
			for (int i = 0; i < m; i++) {
				int num = xxx[i];
				if(deque.size() < m) {
					deque.push(num);
					Integer count = uniqueNumbers.getOrDefault(num, 0);
					uniqueNumbers.put(num, count+1);
					continue;
				}
			}
			System.out.println(uniqueNumbers.size());
		}
		else {
			for (int i = 0; i < n; i++) {
				int num = xxx[i];
				if(deque.size() < m) {
					deque.push(num);
					Integer count = uniqueNumbers.getOrDefault(num, 0);
					uniqueNumbers.put(num, count+1);
					continue;
				}

				//Set<Integer> uniqueNumbers = new HashSet();
				//Iterator it = deque.iterator();
				//while(it.hasNext()) {
				//    uniqueNumbers.add((Integer)it.next());
				//}
				uniques.add(uniqueNumbers.size());

				Integer removed = deque.pollFirst();
				deque.push(num);

				if(!removed.equals(num)) {                        
					Integer count = uniqueNumbers.getOrDefault(num, 0);
					uniqueNumbers.put(num, count+1);
					Integer removedCount = uniqueNumbers.get(removed);
					if(removedCount == 1) {
						uniqueNumbers.remove(removed);
					}
					else {
						uniqueNumbers.put(removed, removedCount-1);
					}
				}
			}

			//Set<Integer> uniqueNumbers = new HashSet();
			//Iterator it = deque.iterator();
			//while(it.hasNext()) {
			//    uniqueNumbers.add((Integer)it.next());
			//}
			uniques.add(uniqueNumbers.size());                
			System.out.println(uniques.last());
		}
	}
}
