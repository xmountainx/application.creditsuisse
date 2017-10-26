package application.creditsuisse.component;

import application.creditsuisse.command.CommandListener;

import java.io.InputStream;
import java.util.*;

public class CommandInterpreter {

    private boolean completed = false;
    private InputStream in = System.in;
    private Map<String, CommandListener> listenerRegistry = new HashMap<>();

    public void runREPL() {
        try (Scanner scanner = new Scanner(in)) {

            while (!completed) {
                System.out.print("enter command: ");

                if (!scanner.hasNextLine()) {
                    // no more line can read, exit
                    break ;
                }

                String nextLine = scanner.nextLine();

                // check input
                if (nextLine == null || nextLine.isEmpty()) {
                    System.out.println("Please enter command");
                    continue;
                }

                // parse command
                List<String> list = Arrays.asList(nextLine.split("\\s+"));

                String type = list.get(0);
                List<String> params = list.subList(1, list.size());

                if (listenerRegistry.containsKey(type)) {
                    CommandListener listener = listenerRegistry.get(type);
                    try {
                        listener.onEvent(params);
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                } else {
                    // throw new UnsupportedOperationException("Command " + type + " is not supported");
                    System.out.println("Command " + type + " is not supported");
                }

            }

        }
    }

    public void registerCommandListener(String type, CommandListener listener) {
        listenerRegistry.put(type, listener);
    }

    // getter and setter
    public void setIn(InputStream in) {
        this.in = in;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
