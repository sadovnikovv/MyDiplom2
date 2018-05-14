package com.example.dellinspironn5110.mydiplom;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class SupportConverterEditTextTest {
    private static final Logger logger = Logger.getLogger(SupportConverterEditTextTest.class.getSimpleName());

    @Test
    public void convert() {
        String temp = "a1";
        Double expected = 1.0;
        Double aa;
        aa = SupportConverterEditText.convertToDouble(temp);

        System.out.println("temp: " + temp);
        System.out.println( "aa: " + aa);
        assertEquals(expected, aa);
    }

    @Test
    public void convert2() {
        String temp = "a15";
        Double expected = 15.0;
        Double aa;
        aa = SupportConverterEditText.convertToDouble(temp);
        assertEquals(expected, aa);
    }

    @Test
    public void convert3() {
        String temp = "a12";
        Double expected = 15.0;
        Double aa;
        aa = SupportConverterEditText.convertToDouble(temp);
        assertEquals(expected, aa);
    }

}