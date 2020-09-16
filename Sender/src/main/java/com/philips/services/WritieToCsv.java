package com.philips.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WritieToCsv {
    public static void mapToCsvWriter() throws IOException {
        FileWriter csvWriter = new FileWriter("wordCount.csv");
        FileWriter csvWriter2 = new FileWriter("wordUsedOnDates.csv");
        csvWriter.append("Word,Count\n");
        csvWriter2.append("Word,Dates\n");
        for(Map.Entry<String,Integer> kv:ConsoleReader.wordCount.entrySet()){
            if(ProcessingData.isStopWord(kv.getKey()))
                continue;
            csvWriter.append(kv.getKey());
            csvWriter.append(",");
            csvWriter2.append(kv.getKey());
            csvWriter2.append(",");
            String val = kv.getValue().toString();
            csvWriter.append(val);
            csvWriter.append("\n");
            csvWriter2.append(ConsoleReader.wordWithDate.get(kv.getKey()));
            csvWriter2.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
        csvWriter2.flush();
        csvWriter2.close();
    }
}
