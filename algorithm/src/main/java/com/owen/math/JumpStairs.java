package com.owen.math;

/**
 * jump 1 or 2 stairs each step, how many steps are needed for n stairs
 *
 * say need f(n) steps for n stairs.
 * 1. jump 1 stair at first, left n-1 stairs and f(n - 1) steps
 * 2. jump 2 stairs at first, left n-2 stairs and f(n - 2) steps
 * so f(n) = f(n - 1) + f(n - 2)
 *
 */
public class JumpStairs
{
    public static void main(String[] args)
    {

    }
}
