package hackerrank.datastructures;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/java-arraylist/problem
 * 
 * @author miriam.mecate
 *
 */
public class XYOperationsOnArrayList {

	public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        
        int numberOfLines = scanner.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        //O(nxm)
        for(int i = 0; i < numberOfLines; i++) {
            int numberOfElements = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < numberOfElements; j++) {
                list.add(Integer.valueOf(scanner.nextInt()));
            }
            lists.add(list);
        }
        
        int numberOfQueries = scanner.nextInt();
        //O(q)
        for(int i = 0; i < numberOfQueries; i++) {
            int xLine = scanner.nextInt();
            int yElement = scanner.nextInt();
            
            //System.out.println(">> " + lists.size() + ":" + xLine + "/" + yElement);
            if(xLine <= lists.size()) {
                List<Integer> list = lists.get(xLine-1);
            
                //System.out.println(">> " + lists.size() + ":" + xLine + "/" list.size() + ":" + yElement);
                if(yElement <= list.size()) {
                    Integer element = list.get(yElement-1);
                    System.out.println(element);
                }
                else {
                    System.out.println("ERROR!");
                }
            }
            else {
                System.out.println("ERROR!");
            }
        }
        
        scanner.close();
    }
}
