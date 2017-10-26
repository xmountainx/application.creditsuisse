package application.creditsuisse.command;

import application.creditsuisse.component.Canvas;
import application.creditsuisse.Utils;

import java.util.List;

public class FillCommandListener implements CommandListener {

    private Canvas canvas;

    @Override
    public void onEvent(List<String> params) {
        if (params.size() != 3 || Utils.isNotNum(params.get(0)) || Utils.isNotNum(params.get(1)) || params.get(2).length() != 1) {
            throw new IllegalArgumentException("Invalid parameters for command");
        }

        int x = Integer.parseInt(params.get(0));
        int y = Integer.parseInt(params.get(1));
        char originColor = canvas.getPointColor(x, y);
        char toColor = params.get(2).charAt(0);

        fillArea(x, y, originColor, toColor);

        canvas.print();;
    }

    private void fillArea(int x, int y, char originColor, char toColor) {
        if (!canvas.isPointExists(x, y)) {
            // the point not exists
            return ;
        }

        if (originColor != canvas.getPointColor(x, y)) {
            // the color is not match, stop
            return ;
        }

        canvas.drawPoint(x, y, toColor);

        // recursive for peripheral points
        fillArea(x, y - 1, originColor, toColor);
        fillArea(x, y + 1, originColor, toColor);
        fillArea(x - 1, y, originColor, toColor);
        fillArea(x + 1, y, originColor, toColor);
    }

    // setter
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
