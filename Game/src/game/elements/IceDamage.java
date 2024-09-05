package game.elements;

public class IceDamage implements Damege {

    @Override
    public String getDamageTypeName() {
        return "Ice";
    }

    @Override
    public int calculateDamage(int baseDamage) {
        return baseDamage + 5; 
    }
}