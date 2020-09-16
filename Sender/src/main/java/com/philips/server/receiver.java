package com.philips.server;

import com.philips.services.ConsoleReader;
import com.philips.services.WritieToCsv;

import java.io.IOException;

public class receiver {
    public static void main(String[] args) throws IOException {
        ConsoleReader.readsDataFromConsoleThenAddsWordsToMap();
        WritieToCsv.mapToCsvWriter();
    }
}
