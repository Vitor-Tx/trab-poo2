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

    public static Controle getInvoker(Jogador j) {
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
        return c;
    }


}
