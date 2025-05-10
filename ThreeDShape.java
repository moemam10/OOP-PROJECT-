
 abstract class  ThreeDShape extends Shape implements Drawable{
    public abstract double getVolume();

    public ThreeDShape() { 
        super();
    }
    
         public ThreeDShape(String color) { 
        super(color);
    }
    
}
