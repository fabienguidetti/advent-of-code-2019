package fabienguidetti.adventofcode2019.day08;

import fabienguidetti.adventofcode2019.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Image {
    private static final int COLOR_TRANSPARENT = 2;

    private List<Layer> layers = new ArrayList<>();

    public Image(int width, int height, String content) {
        List<Integer> contentIntegers = Utils.splitIntegers(content, "");
        for (int i=0; i < contentIntegers.size(); i += width * height) {
            List<Integer> layerIntegers = contentIntegers.subList(i, i + width * height);
            layers.add(new Layer(width, layerIntegers));
        }
    }

    public Layer getLayer(int index) {
        return layers.get(index);
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public String renderPixel(int row, int column) {
        for (Layer layer : layers) {
            int color = layer.get(row, column);
            if (color != COLOR_TRANSPARENT) {
                return color == 0 ? " " : "#";
            }
        }
        return " ";
    }
}
