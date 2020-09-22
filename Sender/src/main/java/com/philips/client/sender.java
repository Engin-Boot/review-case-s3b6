package com.philips.client;

import com.philips.services.PrintingData;

import java.io.IOException;

public class sender {
	public static void main(String[] args){
	    if(args.length==0)
        try {
            PrintingData.bufferDataIsPrintingToConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
        else{
            try {
                PrintingData.specificColoumnOfBufferDataPrintedToConsole(args[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
