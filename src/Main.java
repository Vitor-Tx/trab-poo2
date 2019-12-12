import view.Jogo;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Jogo j = new Jogo();
        j.iniciar(j);

        //Sala labirinto = LabirintoFactory.criaFase();
        //labirinto.entrar();
    }
}
