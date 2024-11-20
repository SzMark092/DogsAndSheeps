import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Farm {
    private Block[][] field;
    private final ReentrantLock lock;
    private boolean movementfinished;
    public Zones zones;
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

    public void setAnimal(Moveable newAnimal, int zone) {
        newAnimal.coordinates=this.zones.getZone(zone).getCoord();
        field[newAnimal.coordinates.x][newAnimal.coordinates.y] = newAnimal;
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