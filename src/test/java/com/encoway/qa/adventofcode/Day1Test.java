package com.encoway.qa.adventofcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    @Test
    void extractList() {
        List<String> data = new ArrayList<>(List.of("1 1", "3 1", "5 2"));
        Day1.extractList(data);
        assertEquals(List.of(1, 3, 5), Day1.firstList);
        assertEquals(List.of(1, 1, 2), Day1.secondList);
        assertEquals(Map.of(1, 2, 2, 1), Day1.secondMap);
    }

    @Test
    void dayOneFirst() {
        List<Integer> firstList = new ArrayList<>(List.of(1, 3, 5));
        List<Integer> secondList = new ArrayList<>(List.of(2, 4, 6));
        Day1.dayOneFirst(firstList, secondList);
        // Expected result is |1-2| + |3-4| + |5-6| = 1 + 1 + 1 = 3
        assertEquals(3, Day1.dayOneFirst(firstList, secondList));
    }

    @Test
    void dayOneSecond() {
        Day1.firstList = new ArrayList<>(List.of(1, 3, 5));
        Day1.secondMap = Map.of(1, 2, 3, 1, 5, 3);
        Day1.dayOneSecond();
        // Expected result is 1*2 + 3*1 + 5*3 = 2 + 3 + 15 = 20
        assertEquals(20, Day1.dayOneSecond());
    }
}