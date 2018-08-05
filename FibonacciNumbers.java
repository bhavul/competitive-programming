/**
 * Link : https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * 
 * This is the hello world of Dynamic Programming.
 */

import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class FibonacciNumbers {
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		System.out.println("n = "+n);

		ArrayList<Integer> array = new ArrayList();
		array.add(0, 0);
		array.add(1, 1);
		for(int i=2; i<=n;i++)
		{
			array.add(i, array.get(i-1)+array.get(i-2));
		}
		System.out.println(array.get(n));
	}

}