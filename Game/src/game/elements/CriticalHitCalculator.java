package game.elements;

import java.util.Random;

public class CriticalHitCalculator {
    private Random random = new Random();

    public boolean isCriticalHit() {
        return random.nextDouble() < 0.2; // 20% de probabilidad de crítico
    }

    public int applyCritical(int damage) {
        return (int) (damage * 1.5); // Daño crítico aumenta en 50%
    }
}