package com.encoway.qa.adventofcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.encoway.qa.adventofcode.Utils.readDataFromFile;

/**
 * DayOne Advent of Code.
 * Find the sum of the differences between the two lists.
 */
public class Day1 {
    static List<Integer> firstList = new ArrayList<>();
    static List<Integer> secondList = new ArrayList<>();
    static Map<Integer, Integer> secondMap = new HashMap<>();

    public static void run() {
        extractList(readDataFromFile("src/main/resources/InputDay1"));
        System.out.println("Result: " + dayOneFirst(firstList, secondList));
        System.out.println("Processed Result: " + dayOneSecond());
    }

    /**
     * Extract the data from the {@link List} and populate the two lists.
     * @param data the data to be extracted
     */
    public static void extractList(List<String> data) {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for (String line : data) {
            String[] numbers = line.split("\\s+");
            firstList.add(Integer.parseInt(numbers[0]));
            secondList.add(Integer.parseInt(numbers[1]));
        }
        Day1.firstList = firstList;
        Day1.secondList = secondList;
        mapList();

    }

    /**
     * Calculates the sum of the absolute differences between corresponding elements
     * in the two provided lists. The lists are sorted before the calculation.
     *
     * @param firstList  the first list of integers
     * @param secondList the second list of integers
     */
    public static int dayOneFirst(List<Integer> firstList, List<Integer> secondList) {
        int result = 0;
        firstList.sort(Integer::compareTo);
        secondList.sort(Integer::compareTo);
        for (int i = 0; i < firstList.size(); i++) {
            result += Math.abs(firstList.get(i) - secondList.get(i));
        }
        return result;
    }

    /**
     * Calculates the sum of the products of the elements in the first list and the
     * number of times the element appears in the second list.
     */
    public static int dayOneSecond() {
        int result = 0;
        for (Integer number : Day1.firstList) {
            int multiplier = Day1.secondMap.getOrDefault(number, 0);
            result += number * multiplier;
        }
        return result;
    }

    /**
     * Maps the elements of the second list to a map with the element as the key and
     * the number of times the element appears in the list as the value.
     */
    private static void mapList () {
        Map<Integer, Integer> result = new HashMap<>();
        Day1.secondList.forEach(number -> {
            if (result.containsKey(number)) {
                result.put(number, result.get(number) + 1);
            } else {
                result.put(number, 1);
            }
        });
        Day1.secondMap = result;
    }

    private Day1() {
    }
}
