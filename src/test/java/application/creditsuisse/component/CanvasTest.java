package application.creditsuisse.component;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanvasTest {

    private Canvas canvas;

    @Before
    public void setUp() throws Exception {
        canvas = new Canvas();
        canvas.initialSize( 20, 4);
    }

    @Test
    public void drawPoint() throws Exception {
        canvas.drawPoint(10, 2, 'o');
    }

    @Test
    public void getPointColor() throws Exception {
        canvas.drawPoint(15, 3, 'o');

        char color = canvas.getPointColor(15,3);
        Assert.assertEquals('o', color);
    }

    @Test
    public void isPointExists() throws Exception {

        Assert.assertTrue(canvas.isPointExists(3 ,3));
        Assert.assertTrue(canvas.isPointExists(10,2));

        Assert.assertTrue(canvas.isPointExists(1 ,1));
        Assert.assertTrue(canvas.isPointExists(20,4));
        Assert.assertTrue(canvas.isPointExists(1 ,4));
        Assert.assertTrue(canvas.isPointExists(20,1));

        Assert.assertFalse(canvas.isPointExists(0,0));
        Assert.assertFalse(canvas.isPointExists(21,1));
        Assert.assertFalse(canvas.isPointExists(10,0));
        Assert.assertFalse(canvas.isPointExists(10,8));
    }

    @Test
    public void print() throws Exception {
        canvas.print();
    }

}