package com.dima.effective.item9;

import java.io.*;


/**
 * try-finally in legacy code before java 6
 */
@Deprecated
public class TryFinallyJavaLegacy {

    // try-finally - No longer the best way to close resources
    public static String firstLineOfFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        try {
            return bufferedReader.readLine();
        }
        finally {
            bufferedReader.close();
        }
    }

    // try-finally is ugly when used with more than one resource!
    public static void copy(String src, String dst) throws IOException {
        InputStream inputStream = new FileInputStream(src);
        try {
            OutputStream outputStream = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[124];
                int n;
                while ((n = inputStream.read(buf)) >= 0) {
                    outputStream.write(buf, 0, n);
                }
            }
            finally {
                outputStream.close();
            }
        }
        finally {
            inputStream.close();
        }
    }
}
