package com.philips.client;

import com.philips.services.PrintingData;

import java.io.IOException;

public class sender {
	public static void main(String[] args){
        try {
            PrintingData.bufferDataIsPrintingToConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
