package com.encoway.qa.adventofcode;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;

public class Day2 {
    static List<List<Integer>> inputList;
    public static void run() {
        System.out.println("Day 2");
        extractList(Utils.readDataFromFile("src/main/resources/InputDay2"));
        System.out.println("Result first: " + countSave());
        System.out.println("Result second: " + countSubSave());
    }

    public static int countSave() {
        int count = 0;
        for (List<Integer> innerList : inputList) {
            count += isSave(innerList) ? 1 : 0;
        }
        return count;
    }

    public static int countSubSave() {
        int count = 0;
        for (List<Integer> innerList : inputList) {
            count += isSubListSave(innerList) ? 1 : 0;
        }
        return count;
    }

    public static boolean isSave(List<Integer> list) {
        boolean increasing = isIncreasing(list);
        boolean decreasing = isDecreasing(list);
        boolean adjacent = isAdjacent(list);
        return adjacent && (increasing ^ decreasing);
    }

    public static boolean isSubListSave(List<Integer> list) {
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> subList = new LinkedList<>(list);
            subList.remove(i);
            result = isSave(subList);
            if (result) {
                break;
            }
        }
        return result;
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
        boolean result = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (abs(list.get(i) - list.get(i + 1)) <= 0 || abs(list.get(i) - list.get(i + 1)) > 3) {
                result = false;
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
