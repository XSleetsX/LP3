package game.entities;

import game.elements.DamageType;

public class Axe extends Weapon {

    public Axe() {
        super(DamageType.ICE); // Ejemplo: Hacha causa daño de hielo
    }

    @Override
    public int calculateDamage() {
        return 70; // Daño fijo para el hacha
    }
}