package application.creditsuisse.component;

import application.creditsuisse.command.CommandListener;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class CommandInterpreterTest {

    private CommandInterpreter interpreter;

    private CountDownLatch lock = new CountDownLatch(1);
    private InputStream in = null;

    private String fixture = "T testing\n";
    private String recevicedText;

    @Before
    public void setUp() throws Exception {
        interpreter = new CommandInterpreter();

        in = new ByteArrayInputStream(fixture.getBytes());
        interpreter.setIn(in);
    }

    @Test
    public void registerCommandListener() throws Exception {
        interpreter.registerCommandListener("T", (args) -> {
            lock.countDown();
            recevicedText = args.get(0);
        });

        interpreter.runREPL();

        lock.await(1000, TimeUnit.MILLISECONDS);
        Assert.assertEquals("testing", recevicedText);
    }

    @After
    public void tearDown() throws Exception {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                // ignore, close sliently
            }
        }
    }

}