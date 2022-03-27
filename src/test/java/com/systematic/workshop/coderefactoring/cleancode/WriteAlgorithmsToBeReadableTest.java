package com.systematic.workshop.coderefactoring.cleancode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.systematic.workshop.coderefactoring.cleancode.WriteAlgorithmsToBeReadable.NUMBER_NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThat;

class WriteAlgorithmsToBeReadableTest {

    private final WriteAlgorithmsToBeReadable writeAlgorithmsToBeReadable = new WriteAlgorithmsToBeReadable();

    @SuppressWarnings("MagicNumber")
    @Test
    void testSquareRoot() {
        Map<Double, Double> testData = new HashMap<>();
        testData.put(1.0, 1.0);
        testData.put(4.0, 2.0);
        testData.put(81.0, 9.0);
        testData.put(144.0, 12.0);

        testData.forEach((inputData, expectedOutputData) -> assertThat(
                writeAlgorithmsToBeReadable.squareRootOfPerfectSquares(inputData))
                .isEqualByComparingTo(expectedOutputData));
    }

    @Test
    void testSearchMethod() {
        int[] searchArray = {1, 4, 5, 6, 7, 8};

        assertThat(writeAlgorithmsToBeReadable.indexOfNumberIn(searchArray, 4)).isEqualTo(1);
        assertThat(writeAlgorithmsToBeReadable.indexOfNumberIn(searchArray, 6)).isEqualTo(3);
        assertThat(writeAlgorithmsToBeReadable.indexOfNumberIn(searchArray, 1)).isZero();
        assertThat(writeAlgorithmsToBeReadable.indexOfNumberIn(searchArray, 9)).isEqualTo(NUMBER_NOT_FOUND);
    }
}
