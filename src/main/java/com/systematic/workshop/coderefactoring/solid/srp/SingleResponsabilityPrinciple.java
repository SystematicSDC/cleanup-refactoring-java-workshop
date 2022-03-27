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

    void transportFileThroughTCP(String fileName) throws IOException {
        String fileContents = readFile(fileName).split("headerSeparator")[1];
        logFileInformation(fileContents);
        sendContentsThroughTCP(fileContents);
    }

    private String readFile(String fileName) throws IOException {
        return Files.readString(Path.of(fileName));
    }

    private void logFileInformation(String fileContents) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("The size of the data in number of characters is {}", fileContents.length());
        }
        if (fileContents.contains("CONFIDENTIAL")) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("The data is confidential, we will not log the fileContents.");
            }
        } else {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("The data is public: {}", fileContents);
            }
        }
    }

    private void sendContentsThroughTCP(String contents) throws IOException {
        try (
                Socket socket = new Socket(InetAddress.getLocalHost(), 8080);
                DataOutputStream dOut = new DataOutputStream(socket.getOutputStream())
        ) {
            dOut.write(contents.getBytes(StandardCharsets.UTF_8));
        }
    }

}
