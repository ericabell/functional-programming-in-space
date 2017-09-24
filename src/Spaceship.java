import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spaceship {
    int numLasers;
    int size;
    boolean hasWarpDrive;
    String name;

    static int nameCounter = 0;
    public static final String[] names = {"Enterprise", "Voyager", "Wuddship", "Ariel", "Pegasus",
            "Defiant", "Valiant", "Victory", "Trafalgar", "Shadow"};

    public Spaceship (int numLasers, int size, boolean hasWarpDrive, String name) {
        this.numLasers = numLasers;
        this.size = size;
        this.hasWarpDrive = hasWarpDrive;
        this.name = name;
    }

    public Spaceship (Random r) {
        if (r == null) {
            r = new Random();
        }
        this.numLasers = r.nextInt(20);
        this.size = r.nextInt(15);
        this.hasWarpDrive = r.nextBoolean();

        this.name = names[nameCounter];
        nameCounter++;
    }

    public void fightSpaceMonster () {
        Random random = new Random();
        int spaceMonsterHealth = random.nextInt(12);
        if (numLasers >= spaceMonsterHealth) {
            System.out.println(name + " wins the fight.");
        } else {
            System.out.println(name + " lost the fight.");
        }
    }

    public String toString () {
        return "Name: " + name + "\nLasers: " + numLasers + "\nSize: " + size + "\nWarpDrive: " + hasWarpDrive;
    }

    //Write these functions using functional programming:
    public static int sumOfEarthGuns (List<Spaceship> ships) {
        return ships.stream()
                .filter(e -> e.hasWarpDrive == true )
                .mapToInt(e -> e.numLasers)
                .sum();
    }

    public static void sendShipsToFightMonsters (List<Spaceship> ships) {

    }

    public static Spaceship findMostGunsWithSize(List<Spaceship> ships, int size) {
        return null;
    }


}