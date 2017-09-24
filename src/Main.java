import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Spaceship> ships = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            ships.add(new Spaceship(r));
        }

        for (Spaceship ship : ships) {
            System.out.println(ship);
        }

        System.out.println("Ship with most guns of size >=5");
        Spaceship best = Spaceship.findMostGunsWithSize(ships, 5);
        System.out.println(best);

        System.out.println("Ships with most guns of size >=12");
        Spaceship best12 = Spaceship.findMostGunsWithSize(ships, 12);
        System.out.println(best12);

        System.out.println("Fighting monsters");
        Spaceship.sendShipsToFightMonsters(ships);

        System.out.println("Sum of firepower defending the Earth is:");
        System.out.println(Spaceship.sumOfEarthGuns(ships));
    }
}
