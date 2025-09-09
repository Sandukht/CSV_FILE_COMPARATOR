package com.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException; // ✅ important

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class OpenFile {

    private String filePath;

    public OpenFile(String filePath) {
        this.filePath = filePath;
    }

   public List<String[]> readCSV(){
    List<String[]> rows = new ArrayList<>();
    try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
        String[] line;
        while ((line = reader.readNext()) != null) {
            rows.add(line);
        }
    } catch (IOException | CsvValidationException e) {
        e.printStackTrace();
        }
    return rows;
    }
    public void  printRows(List<String[]> rows) {
        for (String[] row : rows) {
                System.out.println("------------- 'input.csv' rows -------------");
                System.out.println(Arrays.toString(row));
            }
    }

}

