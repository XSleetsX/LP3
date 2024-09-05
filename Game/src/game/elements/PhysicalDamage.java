package game.elements;

public class PhysicalDamage implements DamageType {

    @Override
    public String getDamageTypeName() {
        return "Physical";
    }

    @Override
    public int calculateDamage(int baseDamage) {
        return baseDamage;  // No modifica el daño base
    }
}