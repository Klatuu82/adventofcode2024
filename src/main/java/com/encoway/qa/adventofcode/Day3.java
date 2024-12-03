package com.encoway.qa.adventofcode;

import java.util.LinkedList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    static List<String> inputList;
    public static void run() {
        System.out.println("Day 3");
        inputList = Utils.readDataFromFile("src/main/resources/InputDay3");
        System.out.println("Result Sum: " + calculate(inputList));
    }

    public static int calculate(List<String> inputList) {
        int sum = 0;
        for (String input : inputList) {
            // Regex-Muster für die Zahlen innerhalb der Klammern
            Pattern pattern = Pattern.compile("\\(\\d{1,3},\\d{1,3}\\)");
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String match = matcher.group(0);
                // Entferne Klammern und splitte nach Komma
                String[] numbers = match.substring(1, match.length() - 1).split(",");
                int num1 = Integer.parseInt(numbers[0]);
                int num2 = Integer.parseInt(numbers[1]);
                sum += num1 * num2;
            }
        }
        return sum;
    }
}