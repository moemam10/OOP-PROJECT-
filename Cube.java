
public class Cube extends ThreeDShape implements Drawable {

    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Cube() {
    }

    public Cube(double side) {
        this.side = side;
    }

    public Cube(String c, double s) {
        super(c);
        this.side = s;

    }
   public Cube(String c) {
        super(c);
       

    }
   public String  color (String c) {
       return c;
       

    }
    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }

    @Override
    public double getPerimeter() {
        return 12 * side;
    }

    @Override
    public String howToDraw() {
        return "Draw Circle With this side = "+getSide();
    }

    @Override
    public String toString() {
        return "Cube{" + "side=" + side + "color = " +'}';
    }

    @Override
    public String getName() {
    return "The Shape name is Cube";
    }
    
}
