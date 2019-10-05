package entities.estrategias.impl;

import entities.estrategias.Ataque;

public class AtaqueForte implements Ataque {

    @Override
    public int forca() {
        return 10;
    }
}
