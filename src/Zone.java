import java.util.Random;

public class Zone {
    Vector from;
    Vector to;

    Zone(Vector from, Vector to) {
        this.from = from;
        this.to = to;
    }

    public boolean isInside(Vector v) {
        return v.x > from.x && v.x < to.x && v.y > from.y && v.y < to.y;
    }

    public Vector getCoord() {
        Random rand = new Random();
        return new Vector(
                rand.nextInt(to.x - from.x) + from.x,
                rand.nextInt(to.y - from.y) + from.y);
    }
}
