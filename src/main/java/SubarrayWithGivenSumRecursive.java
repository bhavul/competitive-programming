/**
 * Created by bhavul.g on 13/08/18.
 *
 * REMEMBER : You're working with sub-array, not a sub-sequence. So, worst case you can always do stuff in O(n2)
 *----------------
 * The O(n2) approach is simple and naive. For every ith starting point of array, and j from i to length, check the sum.
 * ---------------
 * The O(n) approach is like this :
 * - I take two pointers, i and j
 * - I keep adding array[j] and incrementing j till my sum becomes equal to or greater than k
 * - If it becomes equal, I just print values of i and j and the values array[i],array[i+1]....array[j]
 * - If it becomes greater than k, then I increment i and and remove array[i] from the sum seen till now.
 *
 * The conditions to be always satisfied would be : i<=j AND i < array.length AND j < array.length
 * The maximum that can happen is, j going till the end, and then i going till the end.
 * => Worst case - O(2n) = O(n)
 *
 */
public class SubarrayWithGivenSumRecursive
{


    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, 4, 5};
        int k = 11;
        findSubarrayWithGivenSumNSquare(array,k);
        findSubarrayWithGivenSumN(array,k);
    }

    private static void findSubarrayWithGivenSumN(int[] array, int k)
    {
        int i=0,j=0;
        int sum_till_now = 0;
        boolean found = false;
        for(;j<array.length && i<array.length && i<=j;)
        {
            System.out.println("i="+i+", j="+j+", sum:"+sum_till_now);
            if(sum_till_now == k)
            {
                System.out.println("Found!");
                found = true;
                break;
            }
            else if(sum_till_now > k)
            {
                sum_till_now -= array[i];
                i++;
            }
            else
            {
                sum_till_now += array[j];
                if(sum_till_now < k)
                {
                    j++;
                }
            }

        }
        if(found)
        {
            for(int l=i;l<=j;l++)
            {
                System.out.println(array[l]);
            }
        }
        else
        {
            System.out.println("couldn't find");
        }
    }

    private static void findSubarrayWithGivenSumNSquare(int[] array, int k)
    {
        int start=-1,end=-1;
        for(int i=0;i<array.length;i++)
        {
            System.out.println("i="+i);
            int sum = 0;
            for(int j=i;j<array.length;j++)
            {
                System.out.println("j="+j);
                sum += array[j];
                if(sum == k)
                {
                    start=i;
                    end=j;
                    break;
                }
            }
            if(start!=-1)
            {
                break;
            }
        }
        for(int i=start;i<=end;i++)
        {
            System.out.print(array[i]+" ");
        }
    }
}
