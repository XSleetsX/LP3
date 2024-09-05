package game.entities;

import game.elements.DamageType;

public abstract class Weapon {
    private DamageType damageType;

    public Weapon(DamageType damageType) {
        this.damageType = damageType;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public abstract int calculateDamage();
}