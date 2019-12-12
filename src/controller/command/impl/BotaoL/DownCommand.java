package controller.command.impl.BotaoL;

import controller.command.Command;
import model.Personagem.Jogador;

public class DownCommand implements Command {

    Jogador jogador;

    public DownCommand(Jogador j){
        this.jogador = j;
    }

    @Override
    public void execute(){
        this.jogador.getPosicao().movSul();
    }
}
