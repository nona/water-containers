package io.model;

public class WaterContainer {

    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private long volume;

    public WaterContainer(Point p1, Point p2) {
        super();
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = new Point(p2.getX(), 0);
        this.p4 = new Point(p1.getX(), 0);
        int base1 = Math.abs(p2.getX() - p1.getX());
        int base2 = Math.min(p1.getY(), p2.getY());
        this.volume = (long) base1 * base2;
    }

    /**
     *
     * @return the volume of the rectangle with max area in the trapezoid defined by the 4 container points.
     */
    public long getVolume() {
        return this.volume;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WaterContainer coordinates: [");
        builder.append(p1);
        builder.append(", ");
        builder.append(p2);
        builder.append(", ");
        builder.append(p3);
        builder.append(", ");
        builder.append(p4);
        builder.append("], volume = ");
        builder.append(getVolume());
        return builder.toString();
    }

}
