package fabienguidetti.adventofcode2019.day07;

import fabienguidetti.adventofcode2019.computer.Program;

import org.apache.commons.collections4.iterators.PermutationIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amplifiers {
    private static final int AMPLIFIERS_COUNT = 5;

    private final String programText;

    public Amplifiers(String programText) {
        this.programText = programText;
    }

    public int maxSignal() {
        List<Integer> phases = Arrays.asList(0, 1, 2, 3, 4);
        PermutationIterator phasesPermutations = new PermutationIterator(phases);

        int maxSignal = Integer.MIN_VALUE;
        while (phasesPermutations.hasNext()) {
            int signal = getSignal(phasesPermutations.next());
            if (signal > maxSignal) {
                maxSignal = signal;
            }
        }
        return maxSignal;
    }

    public int maxSignalWithFeedback() {
        List<Integer> phases = Arrays.asList(5, 6, 7, 8, 9);
        PermutationIterator phasesPermutations = new PermutationIterator(phases);

        int maxSignal = Integer.MIN_VALUE;
        while (phasesPermutations.hasNext()) {
            int signal = getSignalWithFeedback(phasesPermutations.next());
            if (signal > maxSignal) {
                maxSignal = signal;
            }
        }
        return maxSignal;
    }

    private int getSignal(List<Integer> phases) {
        int signal = 0;
        for (int i=0; i < AMPLIFIERS_COUNT; i++) {
            Program amplifier = new Program(programText);
            amplifier.input(phases.get(i), signal);
            amplifier.execute();
            signal = amplifier.getOutput();
        }
        return signal;
    }

    private int getSignalWithFeedback(List<Integer> phases) {
        int signal = 0;
        List<Program> amplifiers = new ArrayList<>();
        boolean hasOutput = true;
        for (int i=0; i < AMPLIFIERS_COUNT; i++) {
            Program amplifier = new Program(programText);
            amplifier.input(phases.get(i));
            amplifiers.add(amplifier);
        }
        while (hasOutput) {
            for (int i = 0; i < AMPLIFIERS_COUNT; i++) {
                Program amplifier = amplifiers.get(i);
                amplifier.input(signal);
                hasOutput = amplifier.executeUntilOutput();
                if (hasOutput) {
                    signal = amplifier.getOutput();
                }
            }
        }
        return signal;
    }
}
