package hust.soict.hedspi.garbage;

import java.io.*;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "test.exe"; // Replace with the same large file
        InputStream inputStream = new FileInputStream(filename);
        byte[] inputBytes = inputStream.readAllBytes();
        inputStream.close();

        long startTime, endTime;
        StringBuffer outputStringBuffer = new StringBuffer();

        startTime = System.currentTimeMillis();
        for (byte b : inputBytes) {
            outputStringBuffer.append((char) b);
        }
        endTime = System.currentTimeMillis();

        System.out.println("Execution time with StringBuffer: " + (endTime - startTime) + "ms");
    }
}
