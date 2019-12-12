package model.factory.impl;

import model.composite.Sala;
import model.composite.impl.Abismo;
import model.composite.impl.Saida;
import model.composite.impl.SalaComposta;
import model.Personagem.Inimigo;

public class LabirintoFactory {

    public static Sala criaFase(){
        Sala sala1 = criaSala();
        Sala sala2 = criaSala();
        Sala sala3;
        SalaComposta labirinto = new SalaComposta(sala1, sala2, new Inimigo(0,0));
        for(int i = 0; i<10; i++){
            double r = Math.random() * 3;
            sala1 = criaSala();
            sala2 = criaSala();
            sala3 = new SalaComposta(sala1, sala2, new Inimigo(0,0));

            if(r < 0.5)
                labirinto = new SalaComposta(sala1, labirinto, new Inimigo(0, 0));

            else if(r < 1)
                labirinto = new SalaComposta(labirinto, sala1, new Inimigo(0,0));

            else if(r < 1.5)
                labirinto = new SalaComposta(sala2, labirinto, new Inimigo(0,0));

            else if(r < 2)
                labirinto = new SalaComposta(labirinto, sala2, new Inimigo(0, 0));

            else if (r < 2.5)
                labirinto = new SalaComposta(labirinto, sala3, new Inimigo(0,0));

            else
                labirinto = new SalaComposta(sala3, labirinto, new Inimigo(0,0));

        }

        return labirinto;
    }

    private static Sala criaSala(){
        double r = Math.random() * 2;

        if(r < 1)
            return new Abismo();
        else return new Saida();
    }

}
