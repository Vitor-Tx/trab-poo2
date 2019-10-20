package model.strategy.impl;

import model.strategy.Ataque;

public class AtaqueForte implements Ataque {

    @Override
    public int forca() {
        return 10;
    }
}
