import model.composite.Sala;
import model.factory.impl.LabirintoFactory;
import model.observer.impl.NPC;
import view.Jogo;
import view.JogoNPC;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        int op = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a opção de jogo a ser iniciada:\n-1: Jogo normal, você controla o personagem;\n-2: Jogo de NPCs, onde cada NPC usa uma thread;\n\n");
        op = in.nextInt();
        while(op != 1 && op != 2){
            System.out.println("Opção inválida, tente novamente: \n");
            op = in.nextInt();
        }

        if(op == 1){

            Jogo j = new Jogo();
            j.iniciar(j);

        }

        else{
            //Jogador j1, j2, j3;

            //j1 = AdvancedJogadorfactory.getInstance().criaJogador();
            //j2 = SimpleJogadorfactory.getInstance().criaJogador();
            //j3 = AdvancedJogadorfactory.getInstance().criaJogador();

            Sala labirinto = LabirintoFactory.criaFase();
            NPC npc1, npc2, npc3;
            npc1 = new NPC("Darok James");
            npc2 = new NPC("Obima Watson");
            npc3 = new NPC("Tramp Legstrong");

            JogoNPC jg1, jg2, jg3;
            jg1 = new JogoNPC(npc1, labirinto);
            jg2 = new JogoNPC(npc2, labirinto);
            jg3 = new JogoNPC(npc3, labirinto);

            Thread t1 = new Thread(jg1);
            Thread t2 = new Thread(jg2);
            Thread t3 = new Thread(jg3);

            t1.start();
            t2.start();
            t3.start();

            labirinto.entrar(npc1);

        }




    }
}
