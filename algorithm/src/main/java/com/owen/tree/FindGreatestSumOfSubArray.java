package com.owen.tree;

public class FindGreatestSumOfSubArray
{
    public static void main(String[] args)
    {
        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.print(getMaxSum(array));
    }

    private static int getMaxSum(int[] array)
    {
        int sum = 0, max = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
            sum = sum > array[i] ? sum : array[i];
            if(max <= sum){
                max = sum;
            }
        }
        return max;
    }
}
