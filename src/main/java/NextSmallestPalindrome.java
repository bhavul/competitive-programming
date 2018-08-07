/**
 * Link : https://www.geeksforgeeks.org/given-a-number-find-next-smallest-palindrome-larger-than-this-number/
 *
 * WARNING : This is not yet complete and proper. Please don't try to use it.
 */

import java.math.BigInteger;
import java.util.*;

public class NextSmallestPalindrome {
    
    private static List getNumberConvertedToList(BigInteger number) 
    {
        List list = new ArrayList<Integer>();
        BigInteger newNumber = number;
        while(!newNumber.equals(BigInteger.ZERO))
        {
            list.add(Integer.parseInt(newNumber.mod(BigInteger.valueOf(10)).toString()));
            newNumber = newNumber.divide(BigInteger.valueOf(10));
        }
        Collections.reverse(list);
        System.out.println(list);
        return list;
    }

	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        BigInteger number = sc.nextBigInteger();

        int i,j;

        // handling 999 and already palindrome case.
        number = number.add(BigInteger.ONE);
        List<Integer> numberAsList = getNumberConvertedToList(number);
        boolean isPalindromeAlready = isPalindrome(numberAsList);
        System.out.println("isPalindrome - "+isPalindromeAlready);
        if(isPalindromeAlready)
        {
            System.out.println(number);
        }
        else
        {
            // setting the two pointers
            int lengthofNumber = numberAsList.size();
            if(numberAsList.size()%2 == 0)
            {
                i = lengthofNumber/2 -1;
                j = lengthofNumber/2;
            }
            else
            {
                i = (lengthofNumber-1)/2;
                j = i;
            }
            System.out.println("starting i="+i+", j="+j);

            //actual logic
            while(j!=numberAsList.size())
            {
                if(numberAsList.get(i).equals(numberAsList.get(j)))
                {
                    i--;
                    j++;
                }
                else if(numberAsList.get(j) < numberAsList.get(i))
                {
                    // change all j's to reflect all previous numbers
                    while(j!=numberAsList.size())
                    {
                        numberAsList.set(j, numberAsList.get(i));
                        j++;
                        i--;
                    }
                    break;
                }
                else if(numberAsList.get(j) > numberAsList.get(i))
                {
                    numberAsList.set(i,numberAsList.get(j));
                    j++;
                    i--;
                    while(j!=numberAsList.size())
                    {
                        numberAsList.set(j, numberAsList.get(i));
                        j++;
                        i--;
                    }
                    break;
                }
            }
            System.out.println(numberAsList);
        }
	}

    private static boolean isPalindrome(List numberAsList)
    {
        List reverseList = new ArrayList(numberAsList);
        Collections.reverse(reverseList);
        return numberAsList.equals(reverseList);
    }

}