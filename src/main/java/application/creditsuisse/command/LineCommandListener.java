package application.creditsuisse.command;

import application.creditsuisse.component.Canvas;
import application.creditsuisse.Utils;

import java.util.List;

public class LineCommandListener implements CommandListener {

    protected Canvas canvas;

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

        if (x1 != x2 && y1 != y2) {
            throw new UnsupportedOperationException("Currently only horizontal or vertical lines are supported");
        }

        drawLine(x1, y1, x2, y2);
        canvas.print();
    }

    protected void drawLine(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
                canvas.drawPoint(x1, i, 'x');
            }
        } else if (y1 == y2) {
            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                canvas.drawPoint(i, y1, 'x');
            }
        }
    }

    // setter
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

}
