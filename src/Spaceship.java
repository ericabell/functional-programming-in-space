import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Spaceship implements Comparator<Spaceship> {
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
        ships.stream()
                .forEach(Spaceship::fightSpaceMonster);
    }

    public static Spaceship findMostGunsWithSize(List<Spaceship> ships, int size) {
        List<Spaceship> shipsOfGivenSize = ships.stream()
                .filter(e -> e.size == size)
                .collect(Collectors.toList());

        shipsOfGivenSize.sort( (s1, s2) -> s1.numLasers > s2.numLasers);

    }

    @Override
    public int compare(Spaceship o1, Spaceship o2) {
        if( o1.numLasers > o2.numLasers ) {
            return 1;
        } else if( o1.numLasers == o2.numLasers) {
            return 0;
        } else {
            return -1;
        }
    }
}