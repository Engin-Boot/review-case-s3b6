package com.philips.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class CsvReader {
    public static BufferedReader br = null;
    public static void readsCsvThenSendsBufferReader(){
        //ResourceBundle rb = ResourceBundle.getBundle("philips");
        //String file = rb.getString("CsvFileLocation");
        String file = "C:\\\\Users\\\\320091455\\\\BootCamp\\\\CaseStudy\\\\review-case-s3b6\\\\sample-review\\\\review-report.csv";
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
