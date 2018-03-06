package hackerrank.datastructures;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/java-list/problem
 * 
 * @author miriam.mecate
 *
 */
public class OperationsOnList {

	public static void main(String[] args) 
	{        
		Scanner scanner = new Scanner(System.in);
		int listSize = scanner.nextInt();
		List<Integer> listOfNumbers = new LinkedList<>();
		for(int i = 0; i < listSize; i++) {
			listOfNumbers.add(Integer.valueOf(scanner.nextInt()));
		}

		int numberOfOperations = scanner.nextInt();
		for(int i = 0; i < numberOfOperations; i++) {
			String operation = scanner.next();
			if("Insert".equals(operation)) {
				int position = scanner.nextInt();
				int value = scanner.nextInt();
				listOfNumbers.add(position, Integer.valueOf(value));
			}
			else if("Delete".equals(operation)) {
				int position = scanner.nextInt();
				listOfNumbers.remove(position);
			}   
		}

		for(Integer value : listOfNumbers) {
			System.out.print(value + " ");
		}
		scanner.close();
	}

}
