package game.entities;

import game.elements.DamageType;

public class Sword extends Weapon {

    public Sword() {
        super(DamageType.PHYSICAL); 
    }

    @Override
    public int calculateDamage() {
        return 50; 
    }
}