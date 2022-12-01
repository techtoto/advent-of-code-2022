package io.github.techtoto.aoc2022.day01;

import io.github.techtoto.aoc2022.AbstractDay;
import io.github.techtoto.aoc2022.FileInteraction;

import java.util.ArrayList;
import java.util.Collections;

public class Day01 extends AbstractDay {
    ArrayList<String> input = new ArrayList<>();
    ArrayList<Integer> calories = new ArrayList<>();

    public Day01(String inputFile, boolean printOutput1, boolean printOutput2) {
        super(new boolean[]{printOutput1, printOutput2});
        input.addAll(FileInteraction.readFileToList(inputFile));

        countCalories();

        Collections.sort(calories);

        int topThreeElves = calories.get(calories.size() - 1) + calories.get(calories.size() - 2) + calories.get(calories.size() - 3);

        setSolution(0, calories.get(calories.size() - 1));
        setSolution(1, topThreeElves);
    }

    private void countCalories() {
        int currentCalories = 0;

        for (String s : input) {
            if (!s.equals("")) {
                currentCalories += Integer.parseInt(s);
            } else {
                calories.add(currentCalories);
                currentCalories = 0;
            }
        }
    }
}
