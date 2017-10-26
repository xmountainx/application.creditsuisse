package application.creditsuisse.component;


public class Canvas {

    private static final char BLANK = ' ';

    private char[][] buffer;
    private int rowCount;
    private int colCount;

    private void safeCheck(int x, int y) {
        if (buffer == null) {
            throw new IllegalStateException("The canvas is not initialized");
        }

        if (!isPointExists(x, y)) {
            throw new IllegalStateException("Point (" + x + ", " + y + ") is not valid for canvas");
        }
    }


    public void initialSize(int colCount, int rowCount) {
        if (rowCount < 0 || colCount < 0) {
            throw new IllegalStateException("The size of canvas cannot smaller than 0");
        }

        this.rowCount = rowCount;
        this.colCount = colCount;
        this.buffer = new char[rowCount][colCount];

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                buffer[row][col] = BLANK;
            }
        }
    }

    public void drawPoint(int x, int y, char color) {
        safeCheck(x, y);

        buffer[y - 1][x - 1] = color;
    }

    public char getPointColor(int x, int y) {
        safeCheck(x, y);

        return buffer[y - 1][x - 1];
    }

    public boolean isPointExists(int x, int y) {
        boolean ret = true;

        if (y <= 0 || y > buffer.length) {
            ret = false;
        } else if (x <= 0 || x > buffer[y - 1].length) {
            ret = false;
        }

        return ret;
    }

    public void print() {
        // print border line
        for (int i = 0; i< colCount + 2; i++) {
            System.out.print('-');
        }
        System.out.println();

        // print content
        for (int row = 0; row < rowCount; row++) {
            System.out.print('|');

            for (int col = 0; col < colCount; col++) {
                System.out.print(buffer[row][col]);
            }

            System.out.println('|');
        }

        // print border line
        for (int i = 0; i< colCount + 2; i++) {
            System.out.print('-');
        }
        System.out.println("\n");
    }

}