package com.example;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ChangeFile {
    private List<String[]> rows;
    public ChangeFile(List<String[]> rows) {
    this.rows = rows; 
    }

    public List<String[]> deleteOddRows() {
        List<String[]> filtered = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            if (i % 2 == 0) { // keep only even indices
                filtered.add(rows.get(i));
            }
        }
        return filtered;
    }
    
    public void writeToCSV(List<String[]> newRows, String outputPath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputPath))) {
            for (String [] row : newRows) {
            writer.writeNext(row); // ✅ actually writes row into output.csv
            }
            //System.out.println("✅ Changes written to " + outputPath);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void  printRows(List<String[]> rows) {
        for (String[] row : rows) {
                //System.out.println("------------- 'output.csv' rows -------------");
                System.out.println(Arrays.toString(row));
            }
    }

}

