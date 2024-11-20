import java.util.Random;

public class DogFactory {
    public static Dog[] createDogs(int n, Farm farm) {
        Dog[] dogs = new Dog[n];
        for (int i = 0; i < n; i++) {
            dogs[i] = new Dog("" + i);
            farm.setAnimal(dogs[i], getRandomZoneNum());
        }

        return dogs;
    }

    private static int getRandomZoneNum() {
        Random rand = new Random();
        int[] zoneNums = { 0, 1, 2, 3, 5, 6, 7, 8 };
        return zoneNums[rand.nextInt(zoneNums.length)];
    }
}
