
import java.util.Date;

public abstract class Shape implements Drawable {

    private Date dateCreated;
    private String color;

    public Date getDateCreated() {
        return dateCreated;
    }

   
    public abstract double getArea();
    public abstract String getName();
    public abstract double getPerimeter();

    public Shape() {
        this.color = "Blue";
        this.dateCreated = new Date();
    }

    public Shape(String color) {
        this.color = color;
        this.dateCreated = new Date();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
