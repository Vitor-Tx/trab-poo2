package model.factory.impl;

import controller.command.Controle;
import controller.command.impl.BotaoL.DownCommand;
import controller.command.impl.BotaoL.LeftCommand;
import controller.command.impl.BotaoL.RightCommand;
import controller.command.impl.BotaoL.UpCommand;
import controller.command.impl.BotaoR.AtacarCommand;
import controller.command.impl.BotaoR.CorrerCommand;
import controller.command.impl.BotaoR.MagiaCommand;
import controller.command.impl.BotaoR.PularCommand;
import model.Personagem.Jogador;

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
