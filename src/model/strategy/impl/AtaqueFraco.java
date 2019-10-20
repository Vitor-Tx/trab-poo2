package model.strategy.impl;

import model.strategy.Ataque;

public class AtaqueFraco implements Ataque {

    @Override
    public int forca() {
        return 2;
    }
}
