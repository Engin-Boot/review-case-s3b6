package com.philips.services;

import java.io.BufferedReader;
import java.io.IOException;
public class PrintingData {
    private static BufferedReader br = null;
    private static String line = "";
    private static String[] lineData;
    public static void bufferDataIsPrintingToConsole() throws IOException {
        CsvReader.readsCsvThenSendsBufferReader();
        br = CsvReader.br;
        while ((line = br.readLine()) != null) {
            lineData = line.split(",");
            for (String cell : lineData) {
                System.out.print(cell + "  ");
            }
            System.out.println();
        }
        System.out.println("done");

    }
    public static void specificColoumnOfBufferDataPrintedToConsole(String coloumn) throws IOException {
        CsvReader.readsCsvThenSendsBufferReader();
        br = CsvReader.br;
        line=br.readLine();
        lineData = line.split(",");
        int cnt=0;
        for (String col : lineData) {
            if(coloumn.equals(col))
                break;
            cnt++;
        }
        while ((line = br.readLine()) != null) {
            lineData = line.split(",");
            if(lineData.length >cnt)
                System.out.println(lineData[cnt]);
        }
        System.out.println("done");
    }
}
