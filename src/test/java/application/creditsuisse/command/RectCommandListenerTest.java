package application.creditsuisse.command;

import application.creditsuisse.mock.CanvasMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RectCommandListenerTest {

    private CanvasMock canvas = new CanvasMock();
    private RectCommandListener listener = new RectCommandListener();

    private String expect = "                    \n" +
                            " xxxxxxxxxxxxxxxxx  \n" +
                            " x               x  \n" +
                            " xxxxxxxxxxxxxxxxx  \n" +
                            "                    \n";

    @Before
    public void setUp() throws Exception {
        canvas.initialSize(20, 5);
        listener.setCanvas(canvas);
    }

    @Test
    public void onEvent() throws Exception {
        listener.onEvent(Arrays.asList("2", "2", "18", "4"));

        Assert.assertEquals(canvas.getBuffer(), expect);
    }

    @Test(expected = IllegalStateException.class)
    public void onEventNegativeNum() throws Exception {
        listener.onEvent(Arrays.asList("-2", "2", "18", "4"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void onEventAlphabetic() throws Exception {
        listener.onEvent(Arrays.asList("2", "2", "v", "4"));
    }

}