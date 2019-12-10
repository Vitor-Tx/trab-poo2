package model.command.impl.botaoR;

import model.command.Command;
import model.observer.Jogador;

public class BotaoAtacarCommand implements Command {

    private Jogador jogador;

    public BotaoAtacarCommand(Jogador jogador) {
        this.jogador = jogador;
    }

    @Override
    public void execute() {
        this.jogador.atacar();
    }

}
