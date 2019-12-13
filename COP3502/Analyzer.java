package com.company;
import java.util.*;

public class Analyzer {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        String[] dataSet = StringData.getData();

        String arrayVal;
        int linearIndex;
        int binaryIndex;

        System.out.print("Search a value: ");
        arrayVal = scnr.next();

        long linStartTime = System.nanoTime();

        linearIndex = linearSearch(dataSet, arrayVal);

        long linEndTime = System.nanoTime();
        long linearTime = linEndTime - linStartTime;


        long biStartTime = System.nanoTime();

        binaryIndex = binarySearch(dataSet, arrayVal);

        long biEndTime = System.nanoTime();
        long binaryTime = biEndTime - biStartTime;

        if ((linearIndex == -1) || (binaryIndex == -1)) {
            System.out.println(arrayVal + " was not found");
            System.out.println();
        }
        else {
            System.out.println("Linear Index: Found " + arrayVal + " at index " + linearIndex + ".");
            System.out.println("Binary Index: Found " + arrayVal + " at index " + binaryIndex + ".");
            System.out.println();
        }
        System.out.println("Linear Time: " + linearTime + " nanoseconds.");
        System.out.println("Binary Time: " + binaryTime + " nanoseconds.");


    }
    public static int linearSearch(String[] dataSet, String element) {

        int i;

        for (i = 0; i < dataSet.length; ++i) {
            if (dataSet[i].equals(element)) {
                return i;
            }
        }
        return -1; //data point isn't found

    }
    public static int binarySearch(String[] dataSet, String element) {

        int bottom = 0;
        int top = dataSet.length - 1;
        int middle;

        while (top >= bottom) {
            middle = (top + bottom) / 2;
            if (dataSet[middle].compareTo(element) < 0) {
                bottom = middle + 1;
            }
            else if (dataSet[middle].compareTo(element) > 0) {
                top = middle - 1;
            }
            else {
                return middle;
            }
        }
        return -1; //data point isn't found

    }
}
