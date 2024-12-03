package com.encoway.qa.adventofcode;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;

public class Day2 {
    static List<List<Integer>> inputList;
    public static void run() {
        System.out.println("Day 2");
        extractList(Utils.readDataFromFile("src/main/resources/InputDay2"));
        System.out.println("Result: " + isSave());
    }


    public static int isSave() {
        int count = 0;
        for (List<Integer> innerList : inputList) {
            count += isMonotonic(innerList) ? 1 : 0;
        }
        return count;
    }

    public static boolean isMonotonic(List<Integer> list) {
        boolean increasing = isIncreasing(list);
        boolean decreasing = isDecreasing(list);
        boolean adjacent = !isAdjacent(list);
        return !adjacent && (!increasing || !decreasing);
    }

    public static boolean isIncreasing(List<Integer> list){
        boolean result = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean isDecreasing(List<Integer> list){
        boolean result = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) <= list.get(i + 1)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean isAdjacent(List<Integer> list){
        boolean result = false;
        for (int i = 0; i < list.size() - 1; i++) {
            if (abs(list.get(i) - list.get(i + 1)) <= 3 || abs(list.get(i) - list.get(i + 1)) > 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static void extractList(List<String> input) {
        List<List<Integer>> wrapperList = new LinkedList<>();
        for (String line : input) {
            String[] numbers = line.split("\\s+");
            List<Integer> innerList = new LinkedList<>();
            for (String number : numbers) {
                innerList.add(Integer.parseInt(number));
            }
            wrapperList.add(innerList);
        }
        inputList = wrapperList;
    }
}
