package game.entities;

import game.elements.DamageType;

public class Bow extends Weapon {

    public Bow() {
        super(DamageType.FIRE); // Ejemplo: Arco causa daño de fuego
    }

    @Override
    public int calculateDamage() {
        return 30; // Daño fijo para el arco
    }
}