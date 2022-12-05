package io.github.techtoto.aoc2022.day05;

import io.github.techtoto.aoc2022.AbstractDay;
import io.github.techtoto.aoc2022.FileInteraction;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day05 extends AbstractDay {
    private ArrayList<ArrayList<Character>> stacks, stacks2;

    public Day05(String inputFile, boolean printOutput1, boolean printOutput2) {
        super(new boolean[]{printOutput1, printOutput2});

        List<String> input = FileInteraction.readFileToList(inputFile);
        int newLine = input.indexOf("");

        Pattern pattern = Pattern.compile("move\\s(\\d+)\\sfrom\\s(\\d+)\\sto\\s(\\d+)");
        Matcher matcher;

        List<String> stacksList = input.subList(0, newLine - 1);
        List<String> instructions = input.subList(newLine + 1, input.size());

        // elements in a stack are saved from top to bottom
        stacks = new ArrayList<>();
        stacks.add(new ArrayList<>());
        stacks2 = new ArrayList<>();

        int currentIndex;
        int currentStack;

        for (String line : stacksList) {
            currentIndex = 0;
            currentStack = 0;

            while (currentIndex < line.length()) {
                if (currentStack > stacks.size() - 1) {
                    stacks.add(new ArrayList<>());
                }
                char currentCrate = line.substring(currentIndex + 1, currentIndex + 2).charAt(0);
                if (currentCrate != ' ') {
                    stacks.get(currentStack).add(currentCrate);
                }

                currentIndex += 4;
                currentStack++;
            }
        }

        stacks.forEach(stack -> stacks2.add((ArrayList<Character>) stack.clone()));

        for (String instruction : instructions) {
            matcher = pattern.matcher(instruction);

            if (matcher.matches()) {
                crateMover9000(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(1)));
                crateMover9001(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(1)));
            }
        }

        appendOutput(0, "Solution: ");
        for (ArrayList<Character> stack : stacks) {
            appendOutput(0, stack.get(0));
        }

        appendOutput(1, "Solution: ");
        for (ArrayList<Character> stack : stacks2) {
            appendOutput(1, stack.get(0));
        }

    }

    private void crateMover9000(int from, int to, int amount) {
        for (int i = 0; i < amount; i++) {
            stacks.get(to - 1).add(0, stacks.get(from - 1).get(0));
            stacks.get(from - 1).remove(0);
        }
    }

    private void crateMover9001(int from, int to, int amount) {
        stacks2.get(to - 1).addAll(0, stacks2.get(from - 1).subList(0, amount));
        stacks2.get(from - 1).subList(0, amount).clear();
    }

}
