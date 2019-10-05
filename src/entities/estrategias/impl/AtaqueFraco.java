package entities.estrategias.impl;

import entities.estrategias.Ataque;

public class AtaqueFraco implements Ataque {

    @Override
    public int forca() {
        return 2;
    }
}
