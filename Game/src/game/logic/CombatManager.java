package game.logic;

import game.entities.Player;
import game.entities.Enemy;

public class CombatManager {
    public void startCombat(Player player, Enemy enemy) {
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            player.attack(enemy);
            if (enemy.getHealth() > 0) {
                System.out.println("El enemigo contraataca.");
                player.takeDamage(20); //Ejemplo
            }
        }
    }
}