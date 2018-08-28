package com.owen.math;

/**
 * how many methods to cover 2*n rectangle with n mini rectangle
 * of size 2*1
 *
 * when n = m, if the first mini rectangle is placed endways(竖着),
 * there are f(m - 1) methods, if placed sidewards(横着),
 * there are f(m - 2) methods,
 *
 * so total f(m) = f(m - 1) + f(m - 2)
 */
public class CoverRectangle
{
    public static void main(String[] args)
    {
        System.out.println(new CoverRectangle().RectCover(4));
    }

    public int RectCover(int target)
    {
        if(target == 1){
            return 1;
        }
        else if(target == 2){
            return 2;
        }
        else{
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}
