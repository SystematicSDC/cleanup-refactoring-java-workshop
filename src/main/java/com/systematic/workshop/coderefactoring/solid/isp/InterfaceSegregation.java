package com.systematic.workshop.coderefactoring.solid.isp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.Collections.singleton;

/**
 * File Manager which segregated API for reading and writing.
 * <p>
 * While the File manager can survive on its own, we recommend exposing the minimum required methods to the callers,
 * so that it's easier to separate in the future (we call this decoupling). It could also be used as a trivial
 * security mechanism.
 * <p>
 * https://en.wikipedia.org/wiki/Interface_segregation_principle
 */
public class InterfaceSegregation {

    interface FileReader {
        Object read(File file) throws IOException;
    }

    interface FileWriter {
        void writeTo(File file, Object o) throws IOException;
    }

    class MyFileManager implements FileReader, FileWriter {

        @Override
        public Object read(File file) throws IOException {
            return Files.readString(file.toPath());
        }

        @Override
        public void writeTo(File file, Object o) throws IOException {
            Files.write(file.toPath(), singleton(o.toString()));
        }
    }

    class MyFileManagerExample {
        // Both operations are available, but it exposes too much complexity to the caller.
        void canDoEverything() throws IOException {
            File file = Files.createFile(Path.of("lalala.txt")).toFile();
            MyFileManager fileManager = new MyFileManager();
            fileManager.read(file);
            fileManager.writeTo(file, new Object());
        }

        void readFile() throws IOException {
            File file = Files.createFile(Path.of("lalala.txt")).toFile();
            FileReader fileReader = new MyFileManager();
            fileReader.read(file);
//            fileReader.writeTo(file, new Object()); // This is not possible, API is limited only to reading.
        }

        void writeFile() throws IOException {
            File file = Files.createFile(Path.of("lalala.txt")).toFile();
            FileWriter fileWriter = new MyFileManager();
//            fileReader.read(file);; // This is not possible, API is limited only to writing.
            fileWriter.writeTo(file, new Object());
        }
    }

}
