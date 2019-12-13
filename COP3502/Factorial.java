package com.company;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) throws IllegalAccessException { //main function to call recursive methods

        System.out.println("Pick an integer to find its factorial.");
        Scanner scnr = new Scanner(System.in);

        int number = scnr.nextInt();

        System.out.println("Pure recursive result: " + pureRecursive(number));
        System.out.println("Tail recursive result: " + tailRecursive(number));
        System.out.println("Iterative result: " + iterative(number));
    }

    public static Long pureRecursive(int n) throws IllegalAccessException { //main recursive function

        if (n <= 0) {
            throw new IllegalAccessException("The factorial is undefined for non-positive numbers.");
        }
        else if (n == 1) {
            return (long) 1;
        }
        else {
            return n * pureRecursive(n - 1);
        }

    }
    public static Long tailRecursive(int n) throws IllegalAccessException { //kick off method for tail

        return tail(n, 1);
    }

    private static Long tail(int n, long j) throws IllegalAccessException { // tail recursion function

        if (n <= 0) {
            throw new IllegalAccessException("The factorial is undefined for non-positive numbers.");
        }
        else if (n == 1) {
            return (long) j;
        }
        else {
            return tail(n - 1, n * j);
        }

    }
    public static Long iterative(int n) throws IllegalAccessException { //calculating result iteratively
        int i;
        long result = 1;

        if (n <= 0) {
            throw new IllegalAccessException("The factorial is undefined for non-positive numbers.");
        }
        else if (n == 1) {
            return (long) 1;
        }
        else {
            for (i = 1; i <= n; ++i) {
                result = result * i;
            }
            return result;
        }

    }
}
