package model.command.impl.botaoR;

import model.command.Command;
import model.observer.Jogador;

public class BotaoCorrerCommand implements Command {

    private Jogador jogador;

    public BotaoCorrerCommand(Jogador joagador) {
        this.jogador = joagador;
    }


    @Override
    public void execute() {
        this.jogador.correr();
    }
}
