package application.creditsuisse.command;

import application.creditsuisse.Utils;

import java.util.List;

public class RectCommandListener extends LineCommandListener {

    @Override
    public void onEvent(List<String> params) {
        if (params.size() != 4 || params.stream().anyMatch(Utils::isNotNum)) {
            throw new IllegalArgumentException("Invalid parameters for command");
        }

        // point 1
        int x1 = Integer.parseInt(params.get(0));
        int y1 = Integer.parseInt(params.get(1));

        // point 2
        int x2 = Integer.parseInt(params.get(2));
        int y2 = Integer.parseInt(params.get(3));

        drawLine(x1, y1, x2, y1); // Top Border
        drawLine(x1, y1, x1, y2); // Left Border
        drawLine(x2, y1, x2, y2); // Right Border
        drawLine(x1, y2, x2, y2); // Bottom Border

        canvas.print();
    }

}
