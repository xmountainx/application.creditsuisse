package application.creditsuisse.command;

import java.util.List;

public interface CommandListener {

   public void onEvent(List<String> params);

}