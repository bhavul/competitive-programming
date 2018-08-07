/**
 * Cutting Rod : https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 * 
 * Approach : This is a recursive solution to the problem. 
 * The idea is this : either a particular length's rod will be used, or it won't be used.
 * So the final number to output would be Max (price[smallestLengthPiece]+f(lengthOfRod-smallestLengthPiece, smallestLengthPiece, LargestLengthPiece), f(lengthOfRod, secondSmallestLengthPiece, LargestLengthPiece))
 */
import java.util.*;

public class CuttingRod {

    static ArrayList<Integer> prices = new ArrayList();
	
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of rod : ");
        int lengthOfRod = sc.nextInt();

        System.out.println("Enter prices array : ");
        prices.add(0, 0);
        for(int i=1;i<=lengthOfRod;i++)
        {
            System.out.print("length "+(i)+" :");
            prices.add(i, sc.nextInt());
            System.out.println();
        }
        int maximum_value = maxVal(lengthOfRod,1,lengthOfRod);
        System.out.println(maximum_value);
    }
    
    private static int maxVal(int lengthRod, int start,int stop)
    {
        // System.out.println("Entered maxVal with ("+lengthRod+","+start+","+stop);
        if(lengthRod<=0 || start > lengthRod)
            return 0;
        return Math.max(prices.get(start)+maxVal(lengthRod-start,start, Math.max(stop,lengthRod)), 
                        maxVal(lengthRod, start+1, Math.max(stop,lengthRod)));
    }

}