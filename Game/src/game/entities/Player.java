package game.entities;

import game.elements.CriticalHitCalculator;

public class Player {
    private int health;
    private Weapon equippedWeapon;

    public Player(int health) {
        this.health = health;
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    public void attack(Enemy enemy) {
        int damage = equippedWeapon.calculateDamage();
        CriticalHitCalculator critCalc = new CriticalHitCalculator();

        if (critCalc.isCriticalHit()) {
            damage = critCalc.applyCritical(damage);
            System.out.println("¡Golpe crítico!");
        }

        enemy.takeDamage(damage, equippedWeapon.getDamageType());
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println("El jugador ha muerto.");
        }
    }
}