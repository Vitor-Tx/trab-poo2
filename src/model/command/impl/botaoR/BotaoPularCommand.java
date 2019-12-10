package model.command.impl.botaoR;

import model.command.Command;
import model.observer.Jogador;

public class BotaoPularCommand implements Command {

    private Jogador jogador;

    public BotaoPularCommand(Jogador jogador) {
        this.jogador = jogador;
    }

    @Override
    public void execute() {
        this.jogador.pular();
    }
}
