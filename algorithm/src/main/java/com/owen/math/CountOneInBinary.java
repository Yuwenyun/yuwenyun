package com.owen.math;

/**
 * count 1 in binary of integer
 */
public class CountOneInBinary
{
    public static void main(String[] args)
    {
        System.out.println(new CountOneInBinary().NumberOf1(7));
    }

    public int NumberOf1(int n)
    {
        int count = 0;
        while(n > 0)
        {
            if ((n & 1) == 1)
            {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
