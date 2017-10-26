package application.creditsuisse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class MainTest {

    private String fixture = "C 20 4\nL 1 2 6 2\nL 6 3 6 4\nR 14 1 18 3\nB 10 3 o";
    private String result = "enter command: ----------------------\n" +
                            "|                    |\n" +
                            "|                    |\n" +
                            "|                    |\n" +
                            "|                    |\n" +
                            "----------------------\n" +
                            "\n" +
                            "enter command: ----------------------\n" +
                            "|                    |\n" +
                            "|xxxxxx              |\n" +
                            "|                    |\n" +
                            "|                    |\n" +
                            "----------------------\n" +
                            "\n" +
                            "enter command: ----------------------\n" +
                            "|                    |\n" +
                            "|xxxxxx              |\n" +
                            "|     x              |\n" +
                            "|     x              |\n" +
                            "----------------------\n" +
                            "\n" +
                            "enter command: ----------------------\n" +
                            "|             xxxxx  |\n" +
                            "|xxxxxx       x   x  |\n" +
                            "|     x       xxxxx  |\n" +
                            "|     x              |\n" +
                            "----------------------\n" +
                            "\n" +
                            "enter command: ----------------------\n" +
                            "|oooooooooooooxxxxxoo|\n" +
                            "|xxxxxxooooooox   xoo|\n" +
                            "|     xoooooooxxxxxoo|\n" +
                            "|     xoooooooooooooo|\n" +
                            "----------------------\n" +
                            "\n" +
                            "enter command: ";

    private InputStream in = null;
    private ByteArrayOutputStream out = null;

    private InputStream consoleIn = null;
    private PrintStream consoleOut = null;

    private Main main;

    @Before
    public  void setUp() throws Exception {
        in = new ByteArrayInputStream(fixture.getBytes());
        out = new ByteArrayOutputStream();

        consoleIn = System.in;
        consoleOut = System.out;

        System.setIn(in);
        System.setOut(new PrintStream(out));

        main = new Main();
    }

    @Test
    public void run() throws Exception {
        main.run();

        byte[] buf = out.toByteArray();
        Assert.assertEquals(result, new String(buf));
    }

    @After
    public void tearDown() throws Exception {
        System.setIn(consoleIn);
        System.setOut(consoleOut);

        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            // ignore
        }

        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            // ignore
        }
    }

}