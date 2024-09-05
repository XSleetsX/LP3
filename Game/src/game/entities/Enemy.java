package game.entities;

import game.elements.DamageType;

public abstract class Enemy {
    protected int health;
    protected DamageType resistance;

    public Enemy(int health, DamageType resistance) {
        this.health = health;
        this.resistance = resistance;
    }

    public void takeDamage(int damage, DamageType type) {
        if (type == resistance) {
            damage /= 2; // Mitiga daño por resistencia
        }
        this.health -= damage;

        if (health <= 0) {
            System.out.println("El enemigo ha sido derrotado.");
        }
    }

    public int getHealth() {
        return health;
    }
}