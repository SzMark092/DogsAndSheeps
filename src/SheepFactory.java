public class SheepFactory {
     public static Sheep[] createSheeps(int n, Farm farm) {
        Sheep[] sheeps = new Sheep[n];
        for (int i = 0; i < n; i++) {
            sheeps[i] = new Sheep("" + i);
            farm.setAnimal(sheeps[i], 4);
        }

        return sheeps;
    }
}
