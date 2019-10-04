package entities;

public abstract class Personagem {

    private Pular pular;
    private Correr correr;
    private Atacar atacar;

    private Estado estado;
    private Integer saude;

    public Personagem() {
        this.estado = new EstadoNormal(this);
        this.saude = 70;
    }

    public void setEstragetias(Pular pular, Correr correr, Atacar atacar) {
        this.pular = pular;
        this.correr = correr;
        this.atacar = atacar;
    }

    public Pular getPular() {
        return pular;
    }

    public Correr getCorrer() {
        return correr;
    }

    public Atacar getAtacar() {
        return atacar;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getSaude() {
        return saude;
    }

    public void setSaude(Integer saude) {
        this.saude = saude;
    }

    public void receberDano(Integer dano) {
        estado.receberDano(dano);
    }

    public void receberVida(Integer vida) {
        estado.receberVida(vida);
    }
}
