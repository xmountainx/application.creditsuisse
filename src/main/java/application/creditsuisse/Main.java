package application.creditsuisse;


import application.creditsuisse.command.*;
import application.creditsuisse.component.Canvas;
import application.creditsuisse.component.CommandInterpreter;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        // create instance pools
        CommandInterpreter interpreter = new CommandInterpreter();
        Canvas canvas = new Canvas();

        CanvasCommandListener canvasCmd = new CanvasCommandListener();
        LineCommandListener lineCmd = new LineCommandListener();
        RectCommandListener rectCmd = new RectCommandListener();
        FillCommandListener fillCmd = new FillCommandListener();
        CommandListener quitCmd = (params) -> {
            interpreter.setCompleted(true);
        };

        // link up instance
        canvasCmd.setCanvas(canvas);
        lineCmd.setCanvas(canvas);
        rectCmd.setCanvas(canvas);
        fillCmd.setCanvas(canvas);

        // register listener
        interpreter.registerCommandListener("C", canvasCmd);
        interpreter.registerCommandListener("L", lineCmd);
        interpreter.registerCommandListener("R", rectCmd);
        interpreter.registerCommandListener("B", fillCmd);
        interpreter.registerCommandListener("Q", quitCmd);

        // start loop
        interpreter.runREPL();
    }

}

