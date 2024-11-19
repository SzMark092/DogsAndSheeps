package org.example;

import java.util.Random;

public class Dog extends Thread {
    private String name;
    private int x;
    private int y;
    private static final int delay = 200;
    private Farm farm;
    private Random random;
    public Dog(Farm farm, int x, int y) {
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
    public Farm getFarm() {
        return farm;
    }
    public void setPos(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }
    /*public void move() {
        int dx;
        int dy;

        do {
            dx = x + random.nextInt(3) - 1;
            dy = y + random.nextInt(3) - 1;

            if (dx == 0 && dy == 0) continue;
        } while (!farm.isInsideOfArea(dx, dy)
                || !farm.isEmpty(dx, dy)
                || !farm.isCentralNinth(dx, dy));
        farm.dogMoving(this, dx, dy);
        setPos(dx, dy);
    }*/
    /*public void setRandPos() {
        int areaShorterside = farm.getShorterSide();
        int areaLongerside = farm.getLongerSide();

        /*boolean isInCentralNinth = true;
        while (!isInCentralNinth) {
            isInCentralNinth = !farm.isCentralNinth(x, y) && farm.isEmpty(x, y);
        }*/
       /* do {
            x = random.nextInt(areaShorterside - 2) + 1;
            y = random.nextInt(areaLongerside - 2) + 1;
        } while (farm.isCentralNinth(x, y) || !farm.isEmpty(x, y));
    }*/
/*
    @Override
    public void run() {
        try {
            move();
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override
    public String toString() {
        return "4";
    }
}
