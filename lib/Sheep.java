package org.example;

import java.util.Random;

public class Sheep extends Thread {
    private String name;
    private static final int delay = 200;
    private int x;
    private int y;
    private Random random;
    private Farm farm;
    public Sheep(Farm farm, int x, int y) {
        this.farm = farm;
        this.x = x;
        this.y = y;
        this.random = new Random();
        //setRandPos();
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setPos(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }
    /*public void move(Farm farm) {
        int dx;
        int dy;

        boolean dogLeft = farm.isDog(x - 1, y);
        boolean dogRight = farm.isDog(x + 1, y);
        boolean dogUp = farm.isDog(x, y - 1);
        boolean dogDown = farm.isDog(x, y + 1);

        if (dogLeft) {
            dx = x + 1; // Ha balra van kutya, jobbra indul
        } else if (dogRight) {
            dx = x - 1; // Ha jobbra van kutya, balra indul
        } else {
            // Véletlenszerűen választ vízszintes irányt, ha nincs kutya
            dx = x + random.nextInt(3) - 1; // -1, 0, vagy +1
        }

        // Függőleges irány
        if (dogUp) {
            dy = y + 1; // Ha fent van kutya, lefelé indul
        } else if (dogDown) {
            dy = y - 1; // Ha lent van kutya, felfelé indul
        } else {
            // Véletlenszerűen választ függőleges irányt, ha nincs kutya
            dy = y + random.nextInt(3) - 1; // -1, 0, vagy +1
        }

        // Ellenőrzés, hogy az új pozíció érvényes és szabad
        if (farm.isInsideOfArea(dx, dy) && farm.isEmpty(dx, dy)) {
            farm.sheepMoving(this, dx, dy); // Mozgás végrehajtása
        }*/

        /*do {
            dx = x + random.nextInt(3) - 1;
            dy = y + random.nextInt(3) - 1;

            if (dx == 0 && dy == 0) continue;

            if (farm.isInsideOfArea(dx, dy) && farm.isEmpty(dy, dy)) {
                if (farm.isGate(dx, dy)) {
                    farm.sheepEscaped(this);
                    return;
                }
            }
            break;
        } while (true);*/
   // }
    /*public void setRandPos() {
        int areaShorterside = farm.getShorterSide();
        int areaLongerside = farm.getLongerSide();

        // Központi kilenced pozíciójának beállítása
        x = areaShorterside / 3;
        y = areaLongerside / 3;

        // Ha nem az üres hely, próbálkozz újra
        while (!farm.isEmpty(x, y)) {
            x = random.nextInt(areaShorterside - 2) + 1;
            y = random.nextInt(areaLongerside - 2) + 1;
        }
    }*/
    /*@Override
    public void run() {
        try {
            move(farm);
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override
    public String toString() {
        return "S";
    }
}
