package com.owen.math;

/**
 * return the number of continuous zero at the end the result of factorial
 *
 * analysis:
 * 1. each number is able to be like n = n1 * n2;
 * 2. when calculate 4! = 1 * 2 * 3 * 4, we can divide the number like below
 *    4! = 1 * 2 * 3 * (2 * 2)
 * 3. to get a zero at the end of the result, there must be 2 * 5
 * 4. number of 2 is always more than number of 5, say
 *    7! = 1 * 2 * 3 * (2 * 2) * 5 * 6 * 7
 *
 * So we need to calculate how many 5 there is
 */
public class FactorialResultOfContinuousZero
{
    public static void main(String[] args)
    {
        System.out.println(new FactorialResultOfContinuousZero().getNumberOfZero(100));
    }

    private int getNumberOfZero(int n)
    {
        int count = 0;
        for(int i = 5, m; i <= n; i += 5)
        {
            m = i;
            while(m % 5 == 0){
                count++;
                m /= 5;
            }
        }
        return count;
    }
}
