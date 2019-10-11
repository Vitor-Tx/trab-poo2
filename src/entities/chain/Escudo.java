package entities.chain;

/*
    Classe para os Escudos, que adota o padrão corrente de responsabilidade.
    - O atributo defesa é a defesa específica do estudo(haverão diversos tipos de escudo, com defesas diferentes)
    - O atributo carga é a carga desse tipo de escudo que o personagem atual possui. Se for 0, o personagem
    precisa adquirir outro escudo desse tipo para recarregá-lo nessa lista. A carga pode ser diferente da defesa,
    e, se for maior, deve ser retirado no máximo um valor equivalente à defesa do escudo. Se for menor, deve ser
    retirado o valor total atual da carga(se for menor ou igual ao dano) do dano.
    - O atributo de defesa nunca é alterado. Ele é o valor máximo que o escudo pode remover do dano do ataque.
    O que pode ser diminuído é a carga.
 */
public abstract class Escudo {
    private Escudo sucessor;
    protected int defesa;
    protected int carga;

    public Escudo(int carga) {
        this.carga = carga;
    }

    public void setSucessor(Escudo sucessor) {
        this.sucessor = sucessor;
    }

    public Escudo getSucessor() {
        return this.sucessor;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public abstract void adcCarga(Escudo escudo);

    public int defender(int dano) {
        if (dano == 0) return dano;
        if (this.carga == 0) {
            if (getSucessor() != null)
                return getSucessor().defender(dano);
            else return dano;
        }
        if (dano > this.defesa) { // se o dano for maior que a defesa do escudo
            if (this.carga < this.defesa) { // se a carga atual do escudo for menor que a defesa
                dano -= this.carga; // reduz o dano pela carga atual, e neutraliza o dano
                this.carga = 0;
            } else { // se a carga atual do escudo for maior ou igual à defesa
                dano -= this.defesa; // reduz o dano pela defesa
                this.carga -= this.defesa;
            }
        } else { // se o dano for menor ou igual à defesa do escudo
            if (this.carga > dano) { // se a carga atual  do escudo for maior que o dano
                this.carga -= dano; // reduz a carga pelo valor do dano, e neutraliza o dano
                dano = 0;
            } else { // se a carga atual  do escudo for menor ou igual ao dano
                dano -= this.carga; // reduz o dano pela carga atual e a carga acaba
                this.carga = 0;
            }
        }
        if (dano != 0 && getSucessor() != null)
            return getSucessor().defender(dano); // passa para o próximo escudo, se houver
        else return dano;
    }

}
