package io.github.techtoto.aoc2022.day02;

import io.github.techtoto.aoc2022.AbstractDay;
import io.github.techtoto.aoc2022.FileInteraction;

import java.util.List;

public class Day02 extends AbstractDay {

    public Day02(String inputFile, boolean printOutput1, boolean printOutput2) {
        super(new boolean[]{printOutput1, printOutput2});

        List<String> input;
        int totalScore1 = 0;
        int totalScore2 = 0;

        input = FileInteraction.readFileToList(inputFile);

        for (String play : input) {
            String[] currentPlays = play.split(" ");
            totalScore1 += rockPaperScissors1(currentPlays[0].charAt(0), currentPlays[1].charAt(0));
            totalScore2 += rockPaperScissors2(currentPlays[0].charAt(0), currentPlays[1].charAt(0));
        }

        setSolution(0, totalScore1);
        setSolution(1, totalScore2);
    }

    private int rockPaperScissors1(char shape1, char shape2) {
        if (shape1 == 'A') { // opponent chooses Rock
            if (shape2 == 'X') { // you choose Rock (1) -> draw (3)
                return 4;
            } else if (shape2 == 'Y') { // you choose Paper (2) -> win (6)
                return 8;
            } else if (shape2 == 'Z') { // you choose Scissors (3) -> lose (0)
                return 3;
            }
        } else if (shape1 == 'B') { // opponent chooses Paper
            if (shape2 == 'X') { // you choose Rock (1) -> lose (0)
                return 1;
            } else if (shape2 == 'Y') { // you choose Paper (2) -> draw (3)
                return 5;
            } else if (shape2 == 'Z') { // you choose Scissors (3) -> win (6)
                return 9;
            }
        } else if (shape1 == 'C') { // opponent chooses Scissors
            if (shape2 == 'X') { // you choose Rock (1) -> win (6)
                return 7;
            } else if (shape2 == 'Y') { // you choose Paper (2) -> lose (0)
                return 2;
            } else if (shape2 == 'Z') { // you choose Scissors (3) -> draw (3)
                return 6;
            }
        }
        return 0;
    }

    private int rockPaperScissors2(char shape1, char shape2) {
        if (shape1 == 'A') { // opponent chooses Rock
            if (shape2 == 'X') { // you must lose (0) -> play scissors (3)
                return 3;
            } else if (shape2 == 'Y') { // you must have a draw (3) -> play rock (1)
                return 4;
            } else if (shape2 == 'Z') { // you must win (6) -> play paper (2)
                return 8;
            }
        } else if (shape1 == 'B') { // opponent chooses Paper
            if (shape2 == 'X') { // you must lose (0) -> play rock (1)
                return 1;
            } else if (shape2 == 'Y') { // you must have a draw (3) -> play paper (2)
                return 5;
            } else if (shape2 == 'Z') { // you must win (6) -> play scissors (3)
                return 9;
            }
        } else if (shape1 == 'C') { // opponent chooses Scissors
            if (shape2 == 'X') { // you must lose (0) -> play paper (2)
                return 2;
            } else if (shape2 == 'Y') { // you must have a draw (3) -> play scissors (3)
                return 6;
            } else if (shape2 == 'Z') { // you must win (6) -> play rock (1)
                return 7;
            }
        }
        return 0;
    }

}
