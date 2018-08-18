package com.owen.math;

public class FibonacciArray
{
    public static void main(String[] args)
    {
        FibonacciArray array = new FibonacciArray();
        for(int i = 0; i <= 39; i++)
        {
            System.out.println(array.fibonacci(i));
        }
    }

    public int fibonacci(int n)
    {
        int first = 0, second = 1, result = 1;
        if(n < 2){
            return n;
        }
        for(int i = 2; i <= n; i++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
