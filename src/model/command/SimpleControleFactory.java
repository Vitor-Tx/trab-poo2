package model.command;

public class SimpleControleFactory {

    private static SimpleControleFactory instancia = null;

    private SimpleControleFactory() {super(); }

    public static synchronized SimpleControleFactory getInvoker(){
        if (instancia == null)
            instancia = new SimpleControleFactory();
        return instancia;
    }

    public void Controlador(int op, int n) {
        Controle controle = new Controle();

        switch (op) {
            case 1:
                controle.pressAtacar(n);
                break;
            case 2:
                controle.pressCorrer(n);

        }

    }
}
