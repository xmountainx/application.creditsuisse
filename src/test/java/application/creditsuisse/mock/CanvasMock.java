package application.creditsuisse.mock;

import application.creditsuisse.component.Canvas;

public class CanvasMock extends Canvas {

    private char[][] buffer;

    @Override
    public void initialSize(int colCount, int rowCount) {
        super.initialSize(colCount, rowCount);

        this.buffer = new char[rowCount][colCount];

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                buffer[row][col] = ' ';
            }
        }
    }

    @Override
    public void drawPoint(int x, int y, char color) {
        super.drawPoint(x, y, color);

        buffer[y - 1][x - 1] = color;
    }

    @Override
    public char getPointColor(int x, int y) {
        super.getPointColor(x, y);

        return buffer[y - 1][x - 1];
    }

    public String getBuffer() {
        StringBuilder builder = new StringBuilder();

        for (char[] row : buffer) {
            builder.append(new String(row) + "\n");
        }

        return builder.toString();
    }
}
