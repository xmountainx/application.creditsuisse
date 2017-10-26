package application.creditsuisse.command;

import application.creditsuisse.mock.CanvasMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class FillCommandListenerTest {

    private CanvasMock canvas = new CanvasMock();
    private FillCommandListener listener = new FillCommandListener();

    private String expect = "vvvvvvvvv\n" +
                            "vvvvvvvvv\n" +
                            "vvvvvvvvv\n" +
                            "vvvvvvvvv\n" +
                            "vvvvvvvvv\n" +
                            "vvvvvvvvv\n" +
                            "vvvvvvvvv\n" +
                            "vvvvvvvvv\n" +
                            "vvvvvvvvv\n";

    @Before
    public void setUp() throws Exception {
        canvas.initialSize(9, 9);
        listener.setCanvas(canvas);
    }

    @Test
    public void onEvent() throws Exception {
        listener.onEvent(Arrays.asList("5", "5", "v"));

        Assert.assertEquals(canvas.getBuffer(), expect);
    }

    @Test(expected = IllegalStateException.class)
    public void onEventNegativeNum() throws Exception {
        listener.onEvent(Arrays.asList("-10", "5", "v"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void onEventAlphabetic() throws Exception {
        listener.onEvent(Arrays.asList("a", "5", "v"));
    }

}