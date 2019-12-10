package model.command.impl.botaoR;

import model.command.Command;
import model.observer.Jogador;

public class BotaoMagiaCommand implements Command {

    private Jogador jogador;

    public BotaoMagiaCommand(Jogador jogador) {
        this.jogador = jogador;
    }

    @Override
    public void execute() {
        this.jogador.magia();
    }
}
