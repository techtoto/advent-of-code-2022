package io.github.techtoto.aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileInteraction {
    public static List<String> readFileToList(String inFile) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("src/io/github/techtoto/aoc2022/" + inFile));
        } catch (IOException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }
        return lines;
    }
}
