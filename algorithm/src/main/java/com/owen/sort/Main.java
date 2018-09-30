package com.owen.sort;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] array = new int[]{3, 9, 4, 1, 2, 5, 8, 6, 7, 0};
        quick(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    /**
     * f(n) = (size - 1) + (size - 2) + ... + 1
     * o(n) = n^2
     */
    public static int[] bubble(int[] array)
    {
        assert array != null && array.length != 0;
        int size = array.length;
        for(int i = 1; i < size; i++){
            for(int j = 0; j < size - i; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] select(int[] array)
    {
        assert array != null && array.length != 0;
        int size = array.length;
        for(int i = 0; i < size - 1; i++)
        {
            int k = i;
            for(int j = i + 1; j < size; j++){
                if(array[j] < array[k]){
                    k = j;
                }
            }
            int temp = array[k];
            array[k] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static int[] insert(int[] array)
    {
        assert array != null && array.length != 0;
        int size = array.length;
        for(int i = 0; i < size - 1; i++)
        {
            for(int j = i + 1; j > 0; j--)
            {
                if(array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                else{
                    break;
                }
            }
        }
        return array;
    }

    public static int[] shell(int[] array)
    {
        assert array != null && array.length != 0;
        int h = 0;
        // get increment
        while(h <= array.length){
            h = 2 * h + 1;
        }
        while(h >= 1){
            for(int i = h; i < array.length; i++){
                int pivot = i;
                while((pivot - h) >= 0 && array[pivot] < array[pivot - h]){
                    int temp = array[pivot];
                    array[pivot] = array[pivot - h];
                    array[pivot - h] = temp;
                    pivot = pivot - h;
                }
            }
            h = (h - 1)/2;
        }
        return array;
    }

    private static void heapify(int[] array, int i, int size)
    {
        if(size == 0){
            return;
        }
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if(left < size && array[max] < array[left]){
            max = left;
        }
        if(right < size && array[max] < array[right]){
            max = right;
        }
        if(max != i){
            int temp = array[max];
            array[max] = array[i];
            array[i] = temp;
            heapify(array, max, size);
        }
    }

    private static void buildHeap(int[] array, int size)
    {
        for(int i = size/2 - 1; i >= 0; i--){
            heapify(array, i, size);
        }
    }

    public static int[] heap(int[] array)
    {
        for(int size = array.length; size > 0; size--){
            buildHeap(array, size);
            int temp = array[0];
            array[0] = array[size - 1];
            array[size - 1] = temp;
        }
        return array;
    }

    public static void quick(int[] array)
    {
        int size = array.length;
        quick(array, 0, size - 1);
    }

    private static void quick(int[] array, int left, int right)
    {
        int i = left, j = right, temp = array[left];
        if(left >= right){ return; }
        while(i != j){
            while(i < j && array[j] >= temp){ j--; }
            if(j > i){ array[i] = array[j]; }

            while(i < j && array[i] <= temp){ i++; }
            if(i < j){ array[j] = array[i]; }
        }
        array[i] = temp;
        quick(array, left, i - 1);
        quick(array, j + 1, right);
    }
}
