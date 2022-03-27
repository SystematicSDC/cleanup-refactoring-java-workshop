package com.systematic.workshop.coderefactoring.welcometotherealworld.logoperations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * You need to clean up this code, making sure that all tests in LogOperationsTest work fine.
 * <p>
 * Challenge 1:
 * <li> reduce the number of explicit (written in code) calls on logger.isDebugEnabled() from 4 to max 2 </li>
 * <li> reduce the number of explicit (written in code) calls on logger.debug() from 4 to max 2 </li>
 * <p>
 * If you finish Challenge 1, do Challenge 2 -> try to find a way for sum and squareRoot to have a single line of code.
 * <p>
 * In order to keep testing simple, don't use logger.debug() calls that use anything else than a single String parameter.
 * <p>
 * HINTS:
 * <li> extracting methods</li>
 * <li> extracting parameters</li>
 * <li> removing code duplication</li>
 * <li> single responsability principle</li>
 * <li> for Challenge 2: Java 8 Supplier</li>
 */
public class LogOperationsWithSimpleMethods {
    Logger logger = LoggerFactory.getLogger(LogOperationsWithSimpleMethods.class);

    long sum(long no1, long no2) {
        logBefore("sum");
        long sum = no1 + no2;
        logAfter("sum");
        return sum;
    }

    double squareRoot(double no) {
        logBefore("sqrt");
        double squareRoot = Math.sqrt(no);
        logAfter("sqrt");
        return squareRoot;
    }

    private void logBefore(String operation) {
        if (logger.isDebugEnabled()) {
            logger.debug("Started operation " + operation + ".");
        }
    }

    void logAfter(String operation) {
        if (logger.isDebugEnabled()) {
            logger.debug("Finished operation " + operation + ".");
        }
    }
}
