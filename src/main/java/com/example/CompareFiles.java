package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileWriter;

public class CompareFiles {

    public static List<String> compareCSVFiles(List<String[]> rows1, List<String[]> rows2) {
        int maxSize = Math.max(rows1.size(), rows2.size());
        boolean foundDiff = false;
        List<String> differences = new ArrayList<>();
        String diff;
        for (int i = 0; i < maxSize; i++){ // i= 0, 1, ..., 99
            if (i<rows1.size() && i<rows2.size()){
                String[] row11 = rows1.get(i);
                String[] row22 = rows2.get(i);
                if (!Arrays.equals(row11, row22)) {
                    // System.out.println("Row " + i + " differs:");
                    // System.out.println("File1: " + String.join(", ", rows1.get(i)));
                    // System.out.println("File2: " + String.join(", ", rows2.get(i)));
                    
                    int maxColumns = Math.max(row11.length, row22.length);
                    for(int j = 0; j< maxColumns; j++){ // j= 0, 1, ..., 7
                        String val1 = j<row11.length ? row11[j] : "N/A"; // val1 = 0, 1, ..., 7
                        String val2 = j<row22.length ? row22[j] : "N/A"; // val2 = 0, 1, ..., 7
                        if (!val1.equals(val2)){
                        diff = "⚠️ Row " + (i+1) + ", Column " + (j+1) + 
                            " differs: input.csv='" + val1 + "', output.csv='" + val2 + "'";
                        differences.add(diff);
                        foundDiff = true;
                        }
                    }   
                }
            }else if (i<rows1.size()){
                diff = "⚠️ Row " + (i+1) + " exists only in input.csv: " + String.join(", ", rows1.get(i));
                //System.out.println("➕ " + diff);
                foundDiff = true;
            }
            else if (i<rows2.size()) {
                diff = "Row " + (i+1) + " exists only in output.csv: " + String.join(", ", rows2.get(i));
                //System.out.println("➖ " + diff);
                differences.add(diff);
                foundDiff = true;
            } 
        }
        System.out.println("\n===== FINAL REPORT =====");
        if (!foundDiff) {
        System.out.println("✅ The CSV files are identical!");
        differences.add("✅ The CSV files are identical!");
        }
        else{
            System.out.println("The CSV files have differences:");
            // for(String dif : differences){
            //     System.out.println(dif);
            // }
        }
        return differences;
    }

    public void WriteListToFile(List<String> differences) {
        String outputPath = "differences.txt";
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write("===== DIFFERENCES REPORT =====\n");
            for (String line : differences) {
            writer.write(line); //actually writes row into differences.txt
            writer.write(System.lineSeparator());
            }
        System.out.println("✅ Changes written to " + outputPath);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}