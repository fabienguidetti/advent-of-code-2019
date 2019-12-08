package fabienguidetti.adventofcode2019.day08;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private int width;
    private List<Integer> layerIntegers = new ArrayList<>();

    public Layer(int width, List<Integer> layerIntegers) {
        this.width = width;
        this.layerIntegers = layerIntegers;
    }

    public int get(int row, int column) {
        return layerIntegers.get(row * width + column);
    }

    public long countDigit(int digit) {
        return layerIntegers.stream().filter(n -> n.equals(digit)).count();
    }
}
