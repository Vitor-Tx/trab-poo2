package model.decorator;

import model.strategy.Ataque;

public abstract class Decorator implements Ataque {
        private Ataque atkDecorado;
        protected int extra;
        public Decorator(Ataque atkDecorado) {
            this.atkDecorado = atkDecorado;
        }

        @Override
        public int forca() {
            return atkDecorado.forca() + this.extra;
        }
}
