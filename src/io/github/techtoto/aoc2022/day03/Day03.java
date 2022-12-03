package io.github.techtoto.aoc2022.day03;

import io.github.techtoto.aoc2022.AbstractDay;
import io.github.techtoto.aoc2022.FileInteraction;

import java.util.List;

public class Day03 extends AbstractDay {
    String items = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Day03(String inputFile, boolean printOutput1, boolean printOutput2) {
        super(new boolean[]{printOutput1, printOutput2});
        List<String> rucksacks;
        int prioritySum1 = 0;
        int prioritySum2 = 0;

        rucksacks = FileInteraction.readFileToList(inputFile);

        for (int i = 0; i < rucksacks.size(); i += 3) {
            prioritySum2 += findCommonItem(rucksacks.get(i), rucksacks.get(i + 1), rucksacks.get(i + 2));
            for (int j = 0; j <= 2; j++) {
                prioritySum1 += findDoubleItem(rucksacks.get(i + j).substring(0, rucksacks.get(i + j).length() / 2),
                        rucksacks.get(i + j).substring(rucksacks.get(i + j).length() / 2));
            }
        }

        setSolution(0, prioritySum1);
        setSolution(1, prioritySum2);
    }

    private int findDoubleItem(String comp1, String comp2) {
        for (char comp1Item : comp1.toCharArray()) {
            if (comp2.indexOf(comp1Item) != -1) {
                return items.indexOf(comp1Item) + 1;
            }
        }
        return 0;
    }

    private int findCommonItem(String rucksack1, String rucksack2, String rucksack3) {
        for (char item : items.toCharArray()) {
            if (rucksack1.indexOf(item) != -1 && rucksack2.indexOf(item) != -1 && rucksack3.indexOf(item) != -1) {
                return items.indexOf(item) + 1;
            }
        }
        return 0;
    }
}
