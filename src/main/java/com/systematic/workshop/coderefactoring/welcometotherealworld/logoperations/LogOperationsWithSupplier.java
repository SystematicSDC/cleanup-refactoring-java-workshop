package com.systematic.workshop.coderefactoring.welcometotherealworld.logoperations;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * You need to clean up this code, making sure that all tests in LogOperationsTest work fine.
 * <p>
 * Challenge 1:
 * - reduce the number of explicit (written in code) calls on logger.isDebugEnabled() from 4 to a maximum of 2
 * - reduce the number of explicit (written in code) calls on logger.debug() from 4 to a maximum of 2
 * <p>
 * If you finish Challenge 1, do Challenge 2 -> try to find a way for sum and squareRoot to have a single line of code.
 * <p>
 * In order to keep testing simple, don't use logger.debug() calls that use anything else than a single String parameter.
 * <p>
 * HINTS:
 * - extracting methods
 * - extracting parameters
 * - removing code duplication
 * - single responsability principle
 * - for Challenge 2: Java 8 Supplier
 */
public class LogOperationsWithSupplier {
    Logger logger = LoggerFactory.getLogger(LogOperationsWithSupplier.class);

    long sum(long no1, long no2) {
        return surroundWithLogAndExecute("sum", () -> no1 + no2);
    }

    double squareRoot(double no) {
        return surroundWithLogAndExecute("sqrt", () -> Math.sqrt(no));
    }

    private <T> T surroundWithLogAndExecute(String operation, Supplier<T> supplier) {
        boolean debugEnabled = logger.isDebugEnabled();
        if (debugEnabled) {
            logger.debug("Started operation " + operation + ".");
        }
        T result = supplier.get();
        if (debugEnabled) {
            logger.debug("Finished operation " + operation + ".");
        }
        return result;
    }
}
