package com.philips.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessingData {
    public static boolean isNumber(String word){
        String regexNum = "[0-9]*";
        Pattern p = Pattern.compile(regexNum);
        Matcher m = p.matcher(word);
        return m.matches();
    }
    public static boolean isDate(String word){
        return (word.matches("^(0[1-9]|1[012]|[1-9])[- /.](0[1-9]|[12][0-9]|3[01]|[1-9])[- /.](19|20)\\d\\d$"));
    }
    public static String filteringLine(String line){
        return line.replaceAll("[^a-zA-Z0-9/:]"," ");
    }
    public static boolean isStopWord(String word){
        String stopWords = "and,a,the,an,or,is";
        return stopWords.contains(word);
    }
}
