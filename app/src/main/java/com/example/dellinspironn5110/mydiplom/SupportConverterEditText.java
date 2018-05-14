package com.example.dellinspironn5110.mydiplom;

public class SupportConverterEditText {

    public static Double convertToDouble(String value) {
        String temp = value;
        String[] split;

        if (value == null || value.isEmpty()) {
            return new Double(0.0);
        }

        if (temp.startsWith("a")) {
            split = temp.split("[a]+");
            return Double.parseDouble(split[1]);
        } else return Double.parseDouble(value);
    }

    public static Integer convertToInt(String value) {
        String temp = value;
        String[] split;

        if (value == null || value.isEmpty()) {
            return new Integer(0);
        }

        if (temp.startsWith("a")) {
            split = temp.split("[a]+");
            return Integer.parseInt(split[1]);
        } else return Integer.parseInt(value);
    }

}
