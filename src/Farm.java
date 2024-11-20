import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Farm {
    private Block[][] field;
    private final ReentrantLock lock;
    private boolean movementfinished;

    Farm(int sizeX, int sizeY) {
        field = new Block[3 * sizeX + 2][3 * sizeY + 2];
        lock = new ReentrantLock();
    }

    public Block getBlock(Vector coord) {
        return field[coord.x][coord.y];
    }

    public void setBlock(Vector coord, Block newBlock) {
        field[coord.x][coord.y] = newBlock;
    }

    public void setBlock(Vector coord, Block newBlock, int zone) {
        Random rand = new Random();
        int x = 0;
        int y = 0;
        
        do {
            x =rand.nextInt(field.length);
            y=(zone/((x-2)/3))*3+2;
        } while (!getBlock(new Vector(x, y)).CanBePassed());

        field[x][y] = newBlock;
    }

    public void lock() {
        lock.lock();
    }

    public void unLock() {
        lock.unlock();
    }

    public boolean isOccupied(Vector nextPosition) {
        return getBlock(nextPosition).CanBePassed();
    }

    public int getZoneNumber(Vector position) {
        return ((position.x - 2) / 3) * ((position.y - 2) / 3);
    }

    public void setMovementFinished(boolean m) {
        movementfinished = m;
    }

    public boolean getMovementFinished() {
        return movementfinished;
    }
}