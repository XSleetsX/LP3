package game.elements;

public class FireDamage implements DamageType {

    @Override
    public String getDamageTypeName() {
        return "Fire";
    }

    @Override
    public int calculateDamage(int baseDamage) {
        return baseDamage + 10;  // Añade 10 puntos de daño extra por fuego
    }
}