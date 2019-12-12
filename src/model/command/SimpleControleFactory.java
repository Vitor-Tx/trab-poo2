package model.command;

import model.command.impl.BotaoL.DownCommand;
import model.command.impl.BotaoL.LeftCommand;
import model.command.impl.BotaoL.RightCommand;
import model.command.impl.BotaoL.UpCommand;
import model.command.impl.BotaoR.AtacarCommand;
import model.command.impl.BotaoR.CorrerCommand;
import model.command.impl.BotaoR.MagiaCommand;
import model.command.impl.BotaoR.PularCommand;
import model.observer.Jogador;

public class SimpleControleFactory {

    public static Controle getInvoker() {
        Controle c = new Controle();
        return c;
    }

    public static Jogador ExecuteCommands(Jogador j, int op) {
        Controle c = new Controle();
        LeftCommand left = new LeftCommand(j);
        RightCommand right = new RightCommand(j);
        UpCommand up = new UpCommand(j);
        DownCommand down = new DownCommand(j);

        AtacarCommand atacar = new AtacarCommand(j);
        MagiaCommand magia = new MagiaCommand(j);
        CorrerCommand correr = new CorrerCommand(j);
        PularCommand pular = new PularCommand(j);

        c.setSlot_botaoL(left,0);
        c.setSlot_botaoL(right,1);
        c.setSlot_botaoL(up,2);
        c.setSlot_botaoL(down,3);

        c.setSlot_botaoR(atacar,0);
        c.setSlot_botaoR(magia,1);
        c.setSlot_botaoR(correr,2);
        c.setSlot_botaoR(pular,3);

        if (op == 0) {
            c.pressBotaoL(0);
            return j;
        } else if (op == 1) {
            c.pressBotaoL(1);
            return j;
        } else if (op == 2) {
            c.pressBotaoL(2);
            return j;
        } else if (op == 3) {
            c.pressBotaoL(3);
            return j;
        } else if (op == 4) {
            c.pressBotaoR(0);
            return j;
        } else if (op == 5) {
            c.pressBotaoR(1);
            return j;
        } else if (op == 6) {
            c.pressBotaoR(2);
            return j;
        } else if (op == 7) {
            c.pressBotaoR(3);
            return j;
        }

        return null;
    }
}
