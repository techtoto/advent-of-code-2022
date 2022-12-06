package io.github.techtoto.aoc2022.day06;

import io.github.techtoto.aoc2022.AbstractDay;
import io.github.techtoto.aoc2022.FileInteraction;


public class Day06 extends AbstractDay {

    public Day06(String inputFile, boolean printOutput1, boolean printOutput2) {
        super(new boolean[]{printOutput1, printOutput2});

        String input = FileInteraction.readFileToList(inputFile).get(0);

        setSolution(0, firstMarker(input, 4));
        setSolution(1, firstMarker(input, 14));
    }

    public int firstMarker(String s, int charCount) {
        int processedChars = 0;

        processedChars += charCount - 1;
        for (int i = 0; i < s.length() - charCount - 1; i++) {
            String currentFour = s.substring(i, i + charCount);
            processedChars++;
            if (!doubleCharacter(currentFour)) {
                break;
            }
        }

        return processedChars;
    }

    public boolean doubleCharacter(String s) {
        for (char c : s.toCharArray()) {
            if (s.indexOf(c) != s.lastIndexOf(c)) {
                return true;
            }
        }
        return false;
    }
}
