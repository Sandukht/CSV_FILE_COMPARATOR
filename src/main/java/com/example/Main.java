package com.example;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class Main {

   public static void main(String[] args) {
        OpenFile openFile = new OpenFile("input.csv");
        List<String[]>rows = openFile.readCSV();
        System.out.println("✅ input.csv is read (" + rows.size() + " lines).");

        ChangeFile changeFile = new ChangeFile(rows);
        List<String[]> filtered = changeFile.deleteOddRows();
        changeFile.writeToCSV(filtered, "output.csv");
        System.out.println("✅ output.csv is created (" + filtered.size() + " lines).");

        OpenFile outputFile = new OpenFile("output.csv");
        List<String[]> rows2 = outputFile.readCSV();
        System.out.println("✅ output.csv is read (" + rows2.size() + " lines).");

        CompareFiles compareFiles = new CompareFiles();
        System.out.println("🔍 File Comparison...");
        List<String> differences = compareFiles.compareCSVFiles(rows, rows2);
        compareFiles.WriteListToFile(differences);
    }

}
    

