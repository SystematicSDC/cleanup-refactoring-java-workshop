package com.systematic.workshop.coderefactoring.cleancode;

/**
 * This class has two very common algorithms. One is written as well as we could, the other is much worse and it's hard
 * to understand what it does.
 * <p>
 * Your goal is to:
 * <li>identify what both methods do</li>
 * <li>clean up the code from the ugly method, so that it's clear what it does and so that the algorithm implementation is more obvious</li>
 * <p>
 * Sometimes, it can be easier to figure out what a code does by looking at its corresponding tests. See WriteCodeAsAStoryTest.
 * <p>
 * Remember to run the test after any changes, or write extra test cases, to verify that the implementation still works after you have cleaned it up.
 */
public class WriteAlgorithmsToBeReadable {

    static final int NUMBER_NOT_FOUND = -1;

    // Babylonian method: https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Babylonian_method
    // sqrt(n+1) = (sqrt(n) + (originalNumber/sqrt(n)) / 2 => increase iterations of n until we reach desired accuracy
    double squareRootOfPerfectSquares(double originalNumber) {
        double newSquareRoot = originalNumber / 2;
        double oldSquareRoot;
        do {
            oldSquareRoot = newSquareRoot;
            newSquareRoot = (oldSquareRoot + (originalNumber / oldSquareRoot)) / 2; //
        } while (oldSquareRoot - newSquareRoot != 0);
        return newSquareRoot;
    }


    int indexOfNumberIn(int[] sortedArrayOfPositiveInts, int numberToFind) {
        return binarySearch(sortedArrayOfPositiveInts, numberToFind, 0, sortedArrayOfPositiveInts.length - 1);
    }

    private int binarySearch(int[] sortedArrayOfPositiveInts,
                             int numberToFind,
                             int leftBound,
                             int rightBound) {
        int middleOfArray = leftBound + ((rightBound - leftBound) / 2);

        if (rightBound < leftBound) {
            return NUMBER_NOT_FOUND;
        }

        int valueAtMiddleOfArray = sortedArrayOfPositiveInts[middleOfArray];
        if (numberToFind == valueAtMiddleOfArray) {
            return middleOfArray;
        } else if (numberToFind < valueAtMiddleOfArray) {
            int newRightBound = middleOfArray - 1;
            return binarySearch(
                    sortedArrayOfPositiveInts, numberToFind, leftBound, newRightBound);
        } else {
            int newLeftBound = middleOfArray + 1;
            return binarySearch(
                    sortedArrayOfPositiveInts, numberToFind, newLeftBound, rightBound);
        }
    }
}
