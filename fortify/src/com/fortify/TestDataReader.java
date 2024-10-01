package com.fortify;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestDataReader {

    public static List<int[][]> readTests(String filename) throws Exception {
        List<String> lines = readFile(filename);
        List<int[][]> result = new ArrayList<int[][]>();
        for (String line : lines) {
            result.add(readTest(line));
        }
        return result;
    }
    private static int[][] readTest(String s) {
        System.out.println("processing test: " + s);
        String[] rows = s.trim().split("\\]");
        int[][] result = new int[9][];
        for (int i = 0; i < rows.length; i++) {
            String[] rowVals = rows[i].trim().replaceAll("\\[", "").replaceAll("\\]", "").split(",");
            int[] rowValsInt = new int[rowVals.length];
            for (int j = 0; j < rowVals.length; j++) {
                rowValsInt[j] = Integer.parseInt(rowVals[j].trim());
            }
            result[i] = rowValsInt;
        }
        return result;
    }

    
    private static List<String> readFile(String filename) throws Exception {
        List<String> lines = new ArrayList<String>();

        ClassLoader classLoader = TestDataReader.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            lines.add(line);
        }
        in.close();
        return lines;
    }

    
}
