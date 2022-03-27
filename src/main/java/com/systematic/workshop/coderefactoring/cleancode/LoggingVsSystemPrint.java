package com.systematic.workshop.coderefactoring.cleancode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * This class is meant to help you play around with a logger instead of just using System.out or System.err.
 * <p>
 * The first two methods, that (try to) delete a file, are examples of how-to, and how-not-to do it.
 * <p>
 * Your assigment is to play around with the API of the Logger class in order to put in some meaningful log messages for
 * the other methods.
 */
public class LoggingVsSystemPrint {
    Logger logger = LoggerFactory.getLogger(LoggingVsSystemPrint.class);

    void deleteSomeFile(String path) {
        try {
            // at least try to use prinln instead of print!
            System.out.print("Trying to delete"); // what?
            Files.delete(Paths.get(path));
            System.out.print("Deleted.");
        } catch (IOException e) {
            // Absolute worst, avoid at all costs! this is usually basically lost, since real-world apps don't typically
            // monitor System.err directly (because of security reasons, for example)
            e.printStackTrace();
        }
    }

    void deleteAFileMoreNicely(String path) {
        try {
            // If relevant, try to handle exceptions differently - introduce a different LEVEL (error, warn, info etc)
            // and with different messages.
            logger.info("Deleting file from {}", path);
            Files.delete(Paths.get(path));
            logger.info("Successfully deleted file from path {}", path);
        } catch (NoSuchFileException | DirectoryNotEmptyException fileSystemException) {
            logger.warn("Can't delete file; take a look at a file explorer first!", fileSystemException);
        } catch (SecurityException securityException) {
            // In case of a "security breack" you can choose to hide the reason for the exception (otherwise you might do
            // half of a hacker's job for them).
            logger.warn("NO.");
        } catch (Exception otherException) {
            logger.error("Unexpected error when trying to delete file from path {}", path, otherException);
        }
    }

    // Better logging here please
    String joinMe(Collection<String> strings) {
        String log = (strings == null || strings.isEmpty()) ? "NULL"
                : strings.toString();
        System.err.println(log);
        if (strings != null && strings.isEmpty()) {
            final String delimiter = ",";
            System.out.println(delimiter);
            String join = String.join(delimiter, strings);
            return join;
        } else {
            return "";
        }
    }

    // Better logging here please
    BigInteger handleMePls() {
        String s = "s";
        try {
            return new BigInteger(s);
        } catch (NumberFormatException e) {
            System.err.println("can't parse" + s);
            throw new IllegalArgumentException("regex: [+-]?\\b[0-9]+\\b");
        }
    }

}
