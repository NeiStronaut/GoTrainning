package crackingcodinginterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 * 
 * yx 0 1 2 
 * 0  A B C
 * 1  D E F
 * 2  G H I
 * 
 * 90° to the right:
 * 
 * yx 0 1 2 
 * 0  G D A
 * 1  H E B
 * 2  I F C
 * 
 * @author miriam.mecate
 *
 */
public class RotateMatrix {

	public static void rotate90Right(int[][] matrix)
	{
		int dim = matrix.length;
		int mid = matrix.length / 2;
		int odd = 0;
		if( matrix.length % 2 > 0 ) {
			mid += 1;
			odd = 1;
		}
		
		//Increments from the middle to the boundaries
		for(int i = 0; mid + i < dim + odd; i++) {
			//rotation
			int y = mid - i - 1;
			for(int x = mid - i - 1; x < dim - 1; x++) {
				int A = matrix[y][x];
				int B = matrix[x][dim - y - 1];
				int C = matrix[dim - y - 1][dim - x - 1];
				int D = matrix[dim - x - 1][y];
				
				matrix[y][x] = D;
				matrix[x][dim - y - 1] = A;
				matrix[dim - y - 1][dim - x - 1] = B;
				matrix[dim - x - 1][y] = C;
			}
		}
		
	}
	
	
	public static void printMatrix(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
		int[][] test1 = {{1}};
		int[][] test2 = {{1, 1}, {2, 2}};
		int[][] test3 = {{1, 10, 100}, {2, 20, 200}, {3, 30, 300}};
		int[][] test4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {1, 2, 3, 4}, {5, 6, 7, 8}};
		
		List<int[][]> informalTestCases = new ArrayList<>();
		informalTestCases.add(test1);
		informalTestCases.add(test2);
		informalTestCases.add(test3);
		informalTestCases.add(test4);

		//Rotating four times: 90*4 = 360°
		int rotations = 4;
		
		for(int[][] test : informalTestCases) {
			System.out.println("-------------------------");
			System.out.println("Initial TestMatrix ");
			System.out.println("-------------------------");
			printMatrix(test);
			
			//Rotating four times: 90*4 = 360°
			for(int i = 1; i <= rotations; i++) {
				rotate90Right(test);
				System.out.println();
				System.out.println((90*i) + "° TestMatrix: ");
				printMatrix(test);
			}
			System.out.println();
		}
	}

}
