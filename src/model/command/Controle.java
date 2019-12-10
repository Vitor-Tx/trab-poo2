package model.command;

import java.util.ArrayList;
import java.util.List;

public class Controle {

    private List<Command> slot_atacar = new ArrayList<Command>();
    private List<Command> slot_correr = new ArrayList<Command>();
    private List<Command> slot_magia = new ArrayList<Command>();
    private List<Command> slot_pular = new ArrayList<Command>();
    private List<Command> slot_baixo = new ArrayList<Command>();
    private List<Command> slot_cima = new ArrayList<Command>();
    private List<Command> slot_direita = new ArrayList<Command>();
    private List<Command> slot_esquerda = new ArrayList<Command>();
    private List<String> logCommand = new ArrayList<String>();

    // set slot de commandos
    public void setAtacarCommand(Command command, int n) {
        slot_atacar.add(n,command);
    }
    public void setCorrerCommand(Command command, int n) {
        slot_correr.add(n,command);
    }
    public void setMagiaCommand(Command command, int n) {
        slot_magia.add(n,command);
    }
    public void setPularCommand(Command command, int n) {
        slot_pular.add(n,command);
    }
    public void setBaixoCommand(Command command, int n) {
        slot_baixo.add(n,command);
    }
    public void setCimaCommand(Command command, int n) {
        slot_cima.add(n,command);
    }
    public void setDireitaCommand(Command command, int n) {
        slot_direita.add(n,command);
    }
    public void setEsquerdaCommand(Command command, int n) {
        slot_esquerda.add(n,command);
    }

    //execute quando o botão for apertado
    public void pressAtacar(int n){
        slot_atacar.get(n).execute();
        logCommand.add("Commando Atacar acionado");
    }
    public void pressCorrer(int n){
        slot_correr.get(n).execute();
        logCommand.add("Commando Correr acionado");
    }
    public void pressMagia(int n){
        slot_magia.get(n).execute();
        logCommand.add("Commando Magia acionado");
    }
    public void pressPular(int n){
        slot_pular.get(n).execute();
        logCommand.add("Commando Pular acionado");
    }
    public void pressBaixo(int n){
        slot_baixo.get(n).execute();
        logCommand.add("Commando MovBaixo acionado");
    }
    public void pressCima(int n){
        slot_cima.get(n).execute();
        logCommand.add("Commando MovCima acionado");
    }
    public void pressDireita(int n){
        slot_direita.get(n).execute();
        logCommand.add("Commando MovDireita acionado");
    }
    public void pressEsquerda(int n) {
        slot_esquerda.get(n).execute();
        logCommand.add("Commando MovEsquerda acionado");
    }

    public String getLogCommand() { return this.logCommand.toString(); }
}
