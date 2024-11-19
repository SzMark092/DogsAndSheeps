package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Farm {
    private int longerSide;
    private int shorterSide;
    private Object[][] area;
    private Gate[] gates;
    private ArrayList<Sheep> sheeps;
    private ArrayList<Dog> dogs;
    private Gate gate;
    private Empty empty;
    private Wall wall;
    private Random random = new Random();
    private boolean sheepEscaped;
    private final int numberOfSheeps;
    private final int numberOfDogs;
    public Farm(int shorterSide, int longerSide) {
        this.longerSide = longerSide;
        this.shorterSide = shorterSide;
        this.area = new Object[shorterSide][longerSide];
        this.numberOfSheeps = 10;
        this.numberOfDogs = 5;
        this.wall = new Wall();
        this.empty = new Empty();
        /*this.gate = new Gate();
        this.dogs = new ArrayList<>();
        this.sheeps = new ArrayList<>();*/
        this.gates = new Gate[4];
    }
    public int getLongerSide() {
        return longerSide;
    }

    public int getShorterSide() {
        return shorterSide;
    }
    public void createFarm() throws InterruptedException {
        for (int i = 0; i < shorterSide; i++) {
            for (int j = 0; j < longerSide; j++) {
                area[0][j] = wall.toString();
                area[shorterSide - 1][j] = wall.toString();
                area[i][0] = wall.toString();
                area[i][longerSide-1] = wall.toString();
            }
        }

        for (int i = 1; i < shorterSide - 1; i++) {
            for (int j = 1; j < longerSide - 1; j++) {
                    area[i][j] = empty.toString();
            }
        }

        placeGate();
        //initializeAnimals();

        for (int i = 0; i < shorterSide; i++) {
            for (int j = 0; j < longerSide; j++) {
                System.out.print(area[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean isCentralNinth(int x, int y) {
        int verticalWall1 = longerSide / 3;
        int verticalWall2 = (longerSide / 3) * 2;
        int horizontalWall1 = shorterSide / 3;
        int horizontalWall2 = (shorterSide / 3) * 2;

        return x >= verticalWall1
                && x < verticalWall2
                && y >= horizontalWall1
                && y < horizontalWall2;
    }
    public boolean isEmpty(int x, int y) {
        if (isInsideOfArea(x, y)) {
            return area[x][y] instanceof Empty;
        }
        return false;
    }
    public boolean isDog(int x, int y) {
        if (!isInsideOfArea(x, y)) return false;
        return area[x][y] instanceof Dog;
    }
    public void initializeAnimals() {
        Random rand = new Random();

        // Juhok hozzáadása (10 juh)
        for (int i = 0; i < 10; i++) {
            // Véletlenszerű pozíció a középső kilencedben
            int x, y;
            do {
                x = rand.nextInt(shorterSide / 3) + shorterSide / 3;
                y = rand.nextInt(longerSide / 3) + longerSide / 3;
            } while (!isEmpty(x, y)); // Üres helyre helyezze

            Sheep sheep = new Sheep(this,x, y);
            sheeps.add(sheep);
            area[x][y] = sheep; // Hozzáadás a farmhoz
            sheep.start(); // Szál indítása
        }

        // Kutyák hozzáadása (5 kutya)
        for (int i = 0; i < 5; i++) {
            // Véletlenszerű pozíció a külső nyolc kilencedben
            int x, y;
            do {
                x = rand.nextInt(shorterSide);
                y = rand.nextInt(longerSide);
            } while (isCentralNinth(x, y) || !isEmpty(x, y)); // Középső kilenced kerülése

            Dog dog = new Dog(this,x, y);
            dogs.add(dog);
            area[x][y] = dog; // Hozzáadás a farmhoz
            dog.start(); // Szál indítása
        }
    }
    /*public synchronized void dogMoving(Dog dog, int x, int y) {
        int newX = dog.getX();
        int newY = dog.getY();

        if (isInsideOfArea(newX, newY) && isEmpty(newX, newY)) {
            area[newX][newY] = new Empty();
            area[x][y] = dog;
            dog.setPos(x, y);
        }
    }*/
    /*public synchronized void sheepMoving(Sheep sheep, int x, int y) {
        int newX = sheep.getX();
        int newY = sheep.getY();

        if (isInsideOfArea(x, y) && isEmpty(x, y)) {
            area[newX][newY] = new Empty();
            area[x][y] = sheep;
            sheep.setPos(x, y);
        }
        if (isGate(x, y)) {
            sheepEscaped(sheep);
        }
    }*/
    public boolean isInsideOfArea(int x, int y) {
        return x >= 0 && x < shorterSide && y >= 0 && y < longerSide;
    }
    public boolean isGate(int x, int y) {
        if (!isInsideOfArea(x, y)) return false;
        return area[x][y] instanceof Gate;
    }
    private void placeGate() {
        Random rand = new Random();

        int northGatePosition = rand.nextInt(longerSide - 2) + 1;
        area[0][northGatePosition] = new Gate();
        gates[0] = (Gate) area[0][northGatePosition];

        int southGatePosition = rand.nextInt(longerSide - 2) + 1;
        area[shorterSide - 1][southGatePosition] = new Gate();
        gates[1] = (Gate) area[shorterSide - 1][southGatePosition];

        int westGatePosition = rand.nextInt(shorterSide - 2) + 1;
        area[westGatePosition][0] = new Gate();
        gates[2] = (Gate) area[westGatePosition][0];

        int eastGatePosition = rand.nextInt(shorterSide - 2) + 1;
        area[eastGatePosition][longerSide - 1] = new Gate();
        gates[3] = (Gate) area[eastGatePosition][longerSide - 1];
    }
    /*public boolean isAnySheepEscaped() {
        return sheepEscaped;
    }
    public boolean sheepEscaped(Sheep sheep) {
        int x = sheep.getX();
        int y = sheep.getY();

        if (isGate(x, y)) {
            return true;
        }
        return false;
    }
    /*public void startAnimalThreads() throws InterruptedException {
        var sheepThreads = new ArrayList<Thread>();
        var dogThreads = new ArrayList<Thread>();
        // Elindítjuk a juhok szálait
        for (var s : sheepThreads) {
            s.start();
        }

        // Elindítjuk a kutyák szálait
        for (var d : dogThreads) {
            d.start();
        }
        for (var t : sheepThreads) {
            t.join();
        }
        for (var t : dogThreads) {
            t.join();
        }
    }*/
   /* public void addSheep(Sheep sheep) {
        sheeps.add(sheep);
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }*/
}
