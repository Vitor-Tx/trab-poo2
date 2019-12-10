package model.factory;

import model.factory.impl.AdvancedJogadorfactory;
import model.factory.impl.SimpleJogadorfactory;
import model.observer.Jogador;

public abstract class FactoryJogador {

    public abstract Jogador criaJogador();
}
