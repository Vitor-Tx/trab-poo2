package model.command;

import java.util.ArrayList;
import java.util.List;

public class ControleCombos implements  Command{

    List<Command> macro = new ArrayList<>();

    public void addCommand(Command command) {
        macro.add(command);
    }

    @Override
    public void execute(){
        for (Command c: macro)
            c.execute();
    }
}
