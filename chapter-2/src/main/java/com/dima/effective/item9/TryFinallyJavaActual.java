package com.dima.effective.item9;

import java.io.*;


/**
 * try-finally in legacy code after java 7
 */
public class TryFinallyJavaActual {

    // try-with-resources - the best way to closeresources!
    public static String firstLineOfFile(String path) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            return bufferedReader.readLine();
        }
    }

    // try-with-resources on multiple resources - short and sweet
    public static void copy(String src, String dst) throws IOException {
        try (InputStream inputStream = new FileInputStream(src);
             OutputStream outputStream = new FileOutputStream(dst)) {
            byte[] buf = new byte[124];
            int n;
            while ((n = inputStream.read(buf)) >= 0) {
                outputStream.write(buf, 0, n);
            }
        }
    }
}
