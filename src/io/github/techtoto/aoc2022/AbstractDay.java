package io.github.techtoto.aoc2022;

public abstract class AbstractDay {
    public long[] solutions = new long[2];
    public StringBuilder[] outputs = new StringBuilder[2];
    boolean[] printOutput;

    public AbstractDay(boolean[] printOutput) {
        outputs[0] = new StringBuilder();
        outputs[1] = new StringBuilder();
        this.printOutput = printOutput;
    }

    public long getSolution(int i) {
        return solutions[i];
    }

    public void setSolution(int solutionNr, long solution) {
        solutions[solutionNr] = solution;
    }

    public String getOutput(int i) {
        return outputs[i].toString();
    }

    public void appendOutput(int solutionNr, Object o) {
        outputs[solutionNr].append(o);
    }

    public boolean getPrintOutput(int solutionNr) {
        return printOutput[solutionNr];
    }
}
