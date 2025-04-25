package hust.soict.hedspi.garbage;

import java.io.*;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "test.exe"; // Replace with a large text/binary file
        InputStream inputStream = new FileInputStream(filename);
        byte[] inputBytes = inputStream.readAllBytes();
        inputStream.close();

        long startTime, endTime;
        String output = "";

        startTime = System.currentTimeMillis();
        for (byte b : inputBytes) {
            output += (char) b;
        }
        endTime = System.currentTimeMillis();

        System.out.println("Execution time with '+': " + (endTime - startTime) + "ms");
    }
}