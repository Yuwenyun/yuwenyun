package com.owen.utils.math;

public class CalcEachDigit
{
    public static int squareEachDigit(int n)
    {
        int result = 0, x = 0;
        while(n > 0){
            x = n % 10;
            result += x * x;
            n /= 10;
        }
        return result;
    }
}
