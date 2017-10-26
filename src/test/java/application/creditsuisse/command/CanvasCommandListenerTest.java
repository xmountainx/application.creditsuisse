package application.creditsuisse.command;

import application.creditsuisse.component.Canvas;
import application.creditsuisse.mock.CanvasMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CanvasCommandListenerTest {

    private CanvasMock canvas = new CanvasMock();
    private CanvasCommandListener listener = new CanvasCommandListener();

    private String expect = "        \n" +
                            "        \n" +
                            "        \n" +
                            "        \n" +
                            "        \n";

    @Before
    public void setUp() throws Exception {
        listener.setCanvas(canvas);
    }

    @Test
    public void onEvent() throws Exception {
        listener.onEvent(Arrays.asList("8", "5"));

        Assert.assertEquals(canvas.getBuffer(), expect);
    }

    @Test(expected = IllegalStateException.class)
    public void onEventNegativeNum() throws Exception {
        listener.onEvent(Arrays.asList("-8", "5"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void onEventAlphabetic() throws Exception {
        listener.onEvent(Arrays.asList("a", "5"));
    }

}