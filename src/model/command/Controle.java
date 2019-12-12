package model.command;

import java.util.ArrayList;
import java.util.List;

public class Controle {

    private Command slot_botaoR[] = new Command[5];
    private Command slot_botaoL[] = new Command[5];

    // set slot de commandos

    public void setSlot_botaoL(Command command, int n) {
        this.slot_botaoL[n] = command;
    }

    public void setSlot_botaoR(Command command, int n) {
        this.slot_botaoL[n] = command;
    }

    //execute quando o botão for apertado
    public void pressBotaoL(int n) {
        slot_botaoL[n].execute();
    }
    public void pressBotaoR(int n) {slot_botaoL[n].execute();}

}
