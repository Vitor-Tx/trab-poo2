package model.composite.impl;

import model.composite.Sala;
import model.observer.Inimigo;

public class SalaComposta extends Sala {
    public Sala sala1;
    public Sala sala2;
    public Inimigo inimigo;

    public void setSalas(Sala sala1, Sala sala2){
        this.sala1 = sala1;
        this.sala2 = sala2;
        this.inimigo = new Inimigo(0, 0);
    }

    public SalaComposta(Sala caminho1, Sala caminho2, Inimigo inimigo){
        this.sala1 = caminho1;
        this.sala2 = caminho2;
        this.inimigo = inimigo;
    }

    @Override
    public Sala entrar() {
        double r = Math.random() * 2;

        System.out.println("Você entrou numa sala com duas entradas, em qual delas você vai entrar?\n");

        if(r < 1){
            System.out.println("Você entrou na primeira entrada!\n");
            sala1.entrar();
        }

        else{
            System.out.println("Você entrou na segunda entrada!\n");
            sala2.entrar();
        }

        return this;
    }
}
