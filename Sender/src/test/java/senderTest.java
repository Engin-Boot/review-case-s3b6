import com.philips.services.ProcessingData;

import static org.junit.Assert.*;
public class senderTest {
    public static void main(String[] args){
        assertTrue(ProcessingData.isNumber("4"));
        assertFalse(ProcessingData.isNumber("a"));
        assertFalse(ProcessingData.isNumber("@"));

        assertTrue(ProcessingData.isDate("4/31/2020"));
        assertFalse(ProcessingData.isDate("13/31/2020"));
        assertTrue(ProcessingData.isDate("11.11.2020"));
        assertFalse(ProcessingData.isDate("a.b.c"));

        assertTrue(ProcessingData.isStopWord("the"));
        assertFalse(ProcessingData.isNumber("name"));
        assertFalse(ProcessingData.isNumber("name"));
    }
}
