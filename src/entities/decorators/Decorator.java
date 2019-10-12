package entities.decorators;

import entities.estrategias.Ataque;

public abstract class Decorator extends Ataque {
        private Ataque atkDecorado;
        protected int extra;
        public Decorator(Ataque atkDecorado) {
            this.atkDecorado = atkDecorado;
        }

        public int forca() {
            return atkDecorado.forca() + this.extra;
        }
}
