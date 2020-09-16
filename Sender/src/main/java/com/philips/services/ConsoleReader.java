package com.philips.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConsoleReader {
    public static Map<String, Integer> wordCount = new LinkedHashMap<String, Integer>();
    public static Map<String, String> wordWithDate = new LinkedHashMap<String, String>();
    public static void readsDataFromConsoleThenAddsWordsToMap(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String colNames = br.readLine();
            String line=br.readLine();
            String date="";
            while (!line.equals("done")) {
                if(line.equals("")){
                    line=br.readLine();
                    continue;
                }
                line=ProcessingData.filteringLine(line);
                String[] words=line.split(" ");
                int flag=0;
                for(String word:words) {
                    if(flag==0){
                        if(ProcessingData.isDate(word)){
                            flag++;
                            date=word;
                            continue;
                        }
                        else
                        {
                            flag=2;
                        }
                    }
                    if(flag==1){
                        flag++;
                        continue;
                    }
                    if(ProcessingData.isNumber(word))
                        continue;
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                        wordWithDate.put(word,wordWithDate.get(word)+" " +date);
                    }
                    else {
                        wordCount.put(word, 1);
                        wordWithDate.put(word, date);
                    }
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
