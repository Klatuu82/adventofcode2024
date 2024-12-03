package com.encoway.qa.adventofcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {
    @Test
    void dayTwoIsIncreasing() {
        List<Integer> firstList = new ArrayList<>(List.of(85, 86, 87, 88, 89));
        assertTrue(Day2.isIncreasing(firstList));
    }
    @Test
    void dayTwoNotIsIncreasingByEqual() {
        List<Integer> firstList = new ArrayList<>(List.of(85, 86, 87, 88, 88));
        assertFalse(Day2.isIncreasing(firstList));
    }
    @Test
    void dayTwoNotIsIncreasing() {
        List<Integer> firstList = new ArrayList<>(List.of(85, 86, 87, 88, 87));
        assertFalse(Day2.isIncreasing(firstList));
    }
    @Test
    void dayTwoIsDecreasing() {
        List<Integer> firstList = new ArrayList<>(List.of(89, 88, 77, 65, 50));
        assertTrue(Day2.isDecreasing(firstList));
    }
    @Test
    void dayTwoIsNotDecreasingByEqual() {
        List<Integer> firstList = new ArrayList<>(List.of(89, 88, 77, 65, 65));
        assertFalse(Day2.isDecreasing(firstList));
    }
    @Test
    void dayTwoIsNotDecreasing() {
        List<Integer> firstList = new ArrayList<>(List.of(89, 88, 77, 65, 67));
        assertFalse(Day2.isDecreasing(firstList));
    }

    @Test
    void dayTwoIsAdjacent() {
        List<Integer> firstList = new ArrayList<>(List.of(89, 88, 87, 85, 83));
        assertTrue(Day2.isAdjacent(firstList));
    }
    @Test
    void dayTwoNotIsAdjacent() {
        List<Integer> firstList = new ArrayList<>(List.of(89, 88, 87, 85, 81));
        assertFalse(Day2.isAdjacent(firstList));
    }
}