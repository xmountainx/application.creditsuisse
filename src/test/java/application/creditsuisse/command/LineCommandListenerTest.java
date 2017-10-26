package application.creditsuisse.command;

import application.creditsuisse.mock.CanvasMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LineCommandListenerTest {

    private CanvasMock canvas = new CanvasMock();
    private LineCommandListener listener = new LineCommandListener();

    private String expect = "                    \n" +
                            "                    \n" +
                            "    xxxxxxxxxxx     \n" +
                            "                    \n" +
                            "                    \n";

    @Before
    public void setUp() throws Exception {
        canvas.initialSize(20, 5);
        listener.setCanvas(canvas);
    }

    @Test
    public void onEvent() throws Exception {
        listener.onEvent(Arrays.asList("5", "3", "15", "3"));

        Assert.assertEquals(canvas.getBuffer(), expect);
    }

    @Test(expected = IllegalStateException.class)
    public void onEventNegativeNum() throws Exception {
        listener.onEvent(Arrays.asList("-5", "3", "15", "3"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void onEventAlphabetic() throws Exception {
        listener.onEvent(Arrays.asList("A", "3", "15", "3"));
    }

}