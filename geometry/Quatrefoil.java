package geometry;
import javafx.scene.shape.Shape;

public class Quatrefoil extends GeometricObject{

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    private double width;
    private double height;

    public Quatrefoil(){
        super("Quatrefoil",1,4);
        setWidth(1);
        setHeight(1);
        points[0] = new Point(0,0);
    }

    public Quatrefoil(Point startPoint, double width, double height){
        super("Quatrefoil",1,4);
        setWidth(width);
        setHeight(height);
        points[0] = startPoint;
    }

    public Quatrefoil(Quatrefoil otherQuatrefoil){
        super("Quatrefoil",1,4);
        setWidth(otherQuatrefoil.getWidth());
        setHeight(otherQuatrefoil.getHeight());
        points[0] = otherQuatrefoil.points[0];
    }

    @Override
    public boolean isValid(){
        if (!Help.equal(0,getWidth())&&!Help.equal(0,getHeight())){
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public void initialize(){
        do {
            points[0].initialize();
            System.out.println("Width: ");
            setWidth(Help.INPUT.nextDouble());
            System.out.println("Height: ");
            setHeight(Help.INPUT.nextDouble());
        }

        while (!isValid());
    }

    @Override
    public double calculatePerimeter(){
        return (Math.PI*getWidth()+Math.PI*getHeight());
    }

    @Override
    public double calculateArea(){
        return (Math.PI*(getWidth()/2)*(getWidth()/2)+
                Math.PI*(getHeight()/2)*(getHeight()/2)+
                getWidth()*getHeight());
    }

    @Override
    public String getType() {
        if (getWidth()==getHeight()){
            return "regular";
        }
        else{
            return "irregular";
        }
    }

    @Override
    public String toString(){
        return ("("+points[0].x+","+points[0].y+")-{"+getWidth()+","+getHeight()+"}");
    }

    @Override
    public boolean equal(GeometricObject otherGeometricObject){
        if (otherGeometricObject instanceof Quatrefoil){

            if (this.height==((Quatrefoil) otherGeometricObject).getHeight()&&
                    this.width==((Quatrefoil) otherGeometricObject).getWidth()){
                return true;
            }
            else if (this.width==((Quatrefoil) otherGeometricObject).getHeight()&&
                    this.height==((Quatrefoil) otherGeometricObject).getWidth()){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public Shape createRectangleShape(int scale) {
        double scaledX = points[0].x * scale;
        double scaledY = points[0].y * scale;
        double scaledHeight = height * scale;
        double scaledWidth = width * scale;
        return new javafx.scene.shape.Rectangle(scaledX, scaledY, scaledWidth, scaledHeight);
    }

    public Shape createTopCircleShape(int scale) {
        Point topCircleCenter = new Point(this.points[0].x+width/2, this.points[0].y);
        Shape circle = new javafx.scene.shape.Circle(topCircleCenter.x*scale,topCircleCenter.y*scale,width/2*scale);
        return Shape.subtract(circle,createRectangleShape(scale));
    }

    public Shape createBottomCircleShape(int scale) {
        Point bottomCircleCenter = new Point(this.points[0].x+width/2, this.points[0].y+height);
        Shape circle = new javafx.scene.shape.Circle(bottomCircleCenter.x*scale,bottomCircleCenter.y*scale,width/2*scale);
        return Shape.subtract(circle,createRectangleShape(scale));
    }

    public Shape createLeftCircleShape(int scale) {
        Point leftCircleCenter = new Point(this.points[0].x, this.points[0].y+height/2);
        Shape circle = new javafx.scene.shape.Circle(leftCircleCenter.x*scale,leftCircleCenter.y*scale,height/2*scale);
        return Shape.subtract(circle,createRectangleShape(scale));
    }

    public Shape createRightCircleShape(int scale) {
        Point rightCircleCenter = new Point(this.points[0].x+width, this.points[0].y+height/2);
        Shape circle = new javafx.scene.shape.Circle(rightCircleCenter.x*scale,rightCircleCenter.y*scale,height/2*scale);
        return Shape.subtract(circle,createRectangleShape(scale));
    }

    @Override
    public Shape createShape(int scale) {
        Shape stage1 = Shape.union(createRectangleShape(scale),createTopCircleShape(scale));
        Shape stage2 = Shape.union(stage1,createBottomCircleShape(scale));
        Shape stage3 = Shape.union(stage2,createRightCircleShape(scale));
        return Shape.union(stage3,createLeftCircleShape(scale));
    }

    @Override
    public boolean contains(double x, double y){

        Point topCircleCenter = new Point(this.points[0].x+width/2, this.points[0].y);
        Point bottomCircleCenter = new Point(this.points[0].x+width/2, this.points[0].y+height);
        Point leftCircleCenter = new Point(this.points[0].x, this.points[0].y+height/2);
        Point rightCircleCenter = new Point(this.points[0].x+width, this.points[0].y+height/2);

        boolean xInsideRectangle=points[0].x<x && x<(points[0].x+width);
        boolean yInsideRectangle=points[0].y<y && y<(points[0].y+height);
        boolean pointInsideTop = Help.calculateDistance(topCircleCenter,new Point(x,y))<=width/2;
        boolean pointInsideBottom = Help.calculateDistance(bottomCircleCenter,new Point(x,y))<=width/2;
        boolean pointInsideLeft = Help.calculateDistance(leftCircleCenter,new Point(x,y))<=height/2;
        boolean pointInsideRight = Help.calculateDistance(rightCircleCenter,new Point(x,y))<=height/2;

        return (xInsideRectangle&&yInsideRectangle)||pointInsideBottom||pointInsideLeft||pointInsideRight||pointInsideTop;
    }
}
