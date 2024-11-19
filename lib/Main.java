package org.example;

public class Main {
    private Farm farm;
    public static void main(String[] args) throws InterruptedException {
        Farm farm = new Farm(14, 17);
        farm.createFarm();
        Dog dog1 = new Dog(farm, 2, 2);
        Dog dog2 = new Dog(farm, 11, 2);
        Sheep sheep1 = new Sheep(farm, 2, 2);
        Sheep sheep2 = new Sheep(farm, 3, 3);

        // Juhok és kutyák hozzáadása a farmhoz
        /*farm.addDog(dog1);
        farm.addDog(dog2);
        farm.addSheep(sheep1);
        farm.addSheep(sheep2);*/

        // Kutyák és juhok szálainak indítása
        /*dog1.start();
        dog2.start();
        sheep1.start();
        sheep2.start();*/

        // Végtelen ciklus a farm állapotának folyamatos megjelenítésére
        /*while (true) {
            try {
                // Törli a képernyőt és pozicionálja a kurzort a bal felső sarokba
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // Kiírja a farm állapotát
                System.out.println(farm);

                // Ellenőrzi, hogy valamelyik juh megszökött-e
                if (farm.isAnySheepEscaped()) {
                    System.out.println("Egy juh megszökött! A szimuláció véget ér.");
                    System.exit(0); // Program leállítása
                }

                Thread.sleep(200); // Frissítés 200 ms-onként
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}