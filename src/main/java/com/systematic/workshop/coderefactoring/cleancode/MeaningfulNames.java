package com.systematic.workshop.coderefactoring.cleancode;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Your task here is to rename the methods, parameters and even variables implemented here, as well as the names of
 * the corresponding tests in MeaningfulNamesTest, so that they are more easily recognizable, and that they actually
 * represent what they do. Of course, the tests must still pass!
 */
public class MeaningfulNames {

    BigDecimal average(BigDecimal no1, BigDecimal no2) {
        BigDecimal sum = no1.add(no2);
        return sum.divide(BigDecimal.valueOf(2), 4, RoundingMode.HALF_UP);
    }

    strictfp double hypothenuseSize(double sideOneSize, double sideTwoSize) {
        return sqrt(pow(sideOneSize, 2) + pow(sideTwoSize, 2));
    }

    boolean deleteFile(String s) throws IOException {
        return Files.deleteIfExists(Paths.get(s));
    }


}
