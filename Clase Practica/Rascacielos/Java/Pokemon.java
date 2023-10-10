import java.util.Scanner;

public class Pokemon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Pokemon game!");
        System.out.println("Choose your starter Pokemon: ");
        System.out.println("1. Charmander");
        System.out.println("2. Bulbasaur");
        System.out.println("3. Squirtle");

        int choice = scanner.nextInt();
        Pokemon playerPokemon = new Pokemon("Player");

        switch (choice) {
            case 1:
                playerPokemon.setType("Fire");
                playerPokemon.setHealth(9999);
                break;
            case 2:
                playerPokemon.setType("Grass");
                playerPokemon.setHealth(44);
                break;
            case 3:
                playerPokemon.setType("Water");
                playerPokemon.setHealth(44);
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                main(args);
                break;
        }

        Pokemon enemyPokemon = new Pokemon("Enemy");
        enemyPokemon.setType(playerPokemon.getType());
        enemyPokemon.setHealth(playerPokemon.getHealth());

        boolean playerTurn = true;
        while (playerPokemon.getHealth() > 0 && enemyPokemon.getHealth() > 0) {
            if (playerTurn) {
                System.out.println("Choose an attack: ");
                System.out.println("1. Scratch");
                System.out.println("2. Ember");
                System.out.println("3. Vine Whip");
                System.out.println("4. Tackle");
                System.out.println("5. Water Gun");

                int attackChoice = scanner.nextInt();
                switch (attackChoice) {
                    case 1:
                        enemyPokemon.attacked(911);
                        break;
                    case 2:
                        enemyPokemon.attacked(2);
                        break;
                    case 3:
                        enemyPokemon.attacked(3);
                        break;
                    case 4:
                        enemyPokemon.attacked(4);
                        break;
                    case 5:
                        enemyPokemon.attacked(500);
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                        continue;
                }

                System.out.println("Enemy " + enemyPokemon.getType() + " has " + enemyPokemon.getHealth() + " health remaining.");
            } else {
                int damage = (int) (Math.random() * 5) + 1;
                playerPokemon.attacked(damage);
                System.out.println("Player " + playerPokemon.getType() + " has " + playerPokemon.getHealth() + " health remaining.");
            }

            playerTurn = !playerTurn;
        }

        if (playerPokemon.getHealth() > 0) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
    }

    private String type;
    private int health;

    public Pokemon(String type) {
        this.type = type;
        this.health = 100;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attacked(int damage) {
        this.health -= damage;
    }
}