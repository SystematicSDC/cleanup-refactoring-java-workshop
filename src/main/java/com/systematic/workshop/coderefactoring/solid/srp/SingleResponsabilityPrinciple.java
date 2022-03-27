package com.systematic.workshop.coderefactoring.solid.srp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class has a method that does three things:
 * <li> Reads a file from disk</li>
 * <li> Logs some information about the file</li>
 * <li> Sends the contents through a TCP socket.</li>
 * <p>
 * Your task is to split this method into three methods that reflect the 3 "chapters", such that the "top level" method
 * will have only around 3 lines of code.
 * <p>
 * HINTS:
 * <li> Extract method</li>
 * <li> Extract variable</li>
 * <li> Extract parameter</li>
 */
public class SingleResponsabilityPrinciple {
    private static final Logger LOGGER = LoggerFactory.getLogger(SingleResponsabilityPrinciple.class);

    void methodThatDoesEverything() throws IOException {
        final String path = "lalala.txt";
        String rawString = Files.readString(Path.of(path));
        String contents = rawString.split("headerSeparator")[1];
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("The size of the data in number of characters is {}", rawString.split("headerSeparator")[1].length());
        }
        if (contents.contains("CONFIDENTIAL")) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("The data is confidential, we will not log the contents.");
            }
        } else {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("The data is public: {}", rawString.split("headerSeparator")[1]);
            }
        }
        try (
                Socket socket = new Socket(InetAddress.getLocalHost(), 8080);
                DataOutputStream dOut = new DataOutputStream(socket.getOutputStream())
        ) {
            dOut.write(contents.getBytes(StandardCharsets.UTF_8));
        }

    }

}
