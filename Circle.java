
public class Circle extends Shape implements Drawable {
private double raduis;

    public Circle(String color, double raduis) {
        super(color);
        this.raduis = raduis;
    }

    public Circle(double raduis) {
        this.raduis = raduis;
    }
    

        
    public double getRaduis() {
        return raduis;
    }

    public void setRaduis(double raduis) {
        this.raduis = raduis;
    }

    @Override
    public double getArea() {
        return raduis*raduis*Math.PI;
    }

    @Override
    public double getPerimeter() {
        return raduis *2*Math.PI;
    }

    @Override
    public String howToDraw() {
        return "Draw Circle With this radius = "+getRaduis();
    }

    @Override
    public String toString() {
        return "Circle{" + "raduis=" + raduis + '}';
    }

    @Override
    public String getName() {
return "the shape name is Circle";
    }
    
}
