package com.owen;

import java.util.Scanner;

public class Test
{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Test main = new Test();
        while(scanner.hasNextInt()){
            System.out.println(main.reverse(scanner.nextInt()));
        }
    }
    public int reverse(int num){
        if(num == 0){ return 0; }
        boolean negative = num < 0;
        if(negative){ num = 0 - num; }
        int result = 0;
        while(num != 0){
            result *= 10;
            result += num % 10;
            num = num / 10;
        }
        return negative ? 0 - num : num;
    }
}
