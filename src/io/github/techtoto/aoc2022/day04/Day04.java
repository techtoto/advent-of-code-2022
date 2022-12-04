package io.github.techtoto.aoc2022.day04;

import io.github.techtoto.aoc2022.AbstractDay;
import io.github.techtoto.aoc2022.FileInteraction;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Day04 extends AbstractDay {

    public Day04(String inputFile, boolean printOutput1, boolean printOutput2) {
        super(new boolean[]{printOutput1, printOutput2});
        List<String> pairs = FileInteraction.readFileToList(inputFile);

        Pattern pattern = Pattern.compile("(\\d+)-(\\d+),(\\d+)-(\\d+)");
        Matcher matcher;

        List<Integer> assignment1, assignment2;

        int fullyOverlapping = 0;
        int overlapping = 0;

        for (String pair : pairs) {
            matcher = pattern.matcher(pair);

            if (matcher.matches()) {
                assignment1 = IntStream.rangeClosed(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)))
                        .boxed().toList();
                assignment2 = IntStream.rangeClosed(Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)))
                        .boxed().toList();

                if (assignment1.containsAll(assignment2) || assignment2.containsAll(assignment1)) {
                    fullyOverlapping++;
                }

                for (Integer n : assignment1) {
                    if (assignment2.contains(n)) {
                        overlapping++;
                        break;
                    }
                }
            }
        }

        setSolution(0, fullyOverlapping);
        setSolution(1, overlapping);

    }

}
