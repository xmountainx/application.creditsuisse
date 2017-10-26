package application.creditsuisse.command;

import application.creditsuisse.component.Canvas;
import application.creditsuisse.Utils;

import java.util.List;

public class CanvasCommandListener implements CommandListener {

    private Canvas canvas;

    @Override
    public void onEvent(List<String> params) {
        if (params.size() != 2 || params.stream().anyMatch(Utils::isNotNum)) {
            throw new IllegalArgumentException("Invalid parameters for command");
        }

        int colCount = Integer.parseInt(params.get(0));
        int rowCount = Integer.parseInt(params.get(1));

        canvas.initialSize(colCount, rowCount);
        canvas.print();
    }

    // setter
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

}