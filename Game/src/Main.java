import java.util.Scanner;
import game.entities.Player;
import game.entities.Sword;
import game.entities.Weapon;
import game.entities.Bow;
import game.entities.Axe;
import game.entities.Enemy;
import game.logic.CombatManager;
import game.elements.DamageType;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        Player player = new Player(100);
        
        Enemy fireResistantEnemy = new Enemy(50, DamageType.FIRE) {};
        Enemy iceResistantEnemy = new Enemy(50, DamageType.ICE) {};

        while (running) {
            System.out.println("Seleccione un tipo de arma:");
            System.out.println("1. Sword (Espada)");
            System.out.println("2. Bow (Arco)");
            System.out.println("3. Axe (Hacha)");
            System.out.println("4. Salir");
            
            int choice = scanner.nextInt();
            Weapon weapon = null;

            switch (choice) {
                case 1:
                    weapon = new Sword();
                    break;
                case 2:
                    weapon = new Bow();
                    break;
                case 3:
                    weapon = new Axe();
                    break;
                case 4:
                    running = false;
                    continue;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione un número del 1 al 4.");
                    continue;
            }

            if (weapon != null) {
                player.equipWeapon(weapon);
                System.out.println("Arma seleccionada: " + weapon.getClass().getSimpleName());
                System.out.println("Tipo de daño: " + weapon.getDamageType());
                System.out.println("Daño: " + weapon.calculateDamage());

                // Iniciar combate
                CombatManager combatManager = new CombatManager();
                combatManager.startCombat(player, fireResistantEnemy); // Puedes cambiar el enemigo aquí

                if (player.getHealth() <= 0) {
                    System.out.println("Juego terminado, el jugador ha muerto.");
                    running = false;
                }
            }
        }
        
        scanner.close();
        System.out.println("¡Hasta luego!");
    }
}