package geometry;

import javafx.scene.shape.Shape;


public class demo123 extends GeometricObject{

    protected double a;
    protected double b;
    protected Ellipse ellipse;
    protected Rectangle rect;

    public demo123(){
        super("demo123",1,4);
        this.a = 1;
        this.b = 1;
        points[0] = new Point(0,0);
        createFigures();

    }

    public demo123(double a, double b, Point startPoint)
    {
        super("demo123",1,4);
        this.a = a;
        this.b = b;
        points[0] = new Point(startPoint);
        createFigures();

    }

    public demo123(demo123 otherdemo123)
    {
        super("demo123",1,4);
        this.a = otherdemo123.a;
        this.b = otherdemo123.b;
        points[0] = new Point(otherdemo123.points[0]);
        createFigures();
    }

    public void createFigures(){
        Point elipseCenter = new Point(points[0].x+a,points[0].y-b);
        this.ellipse = new Ellipse(elipseCenter,a,b);
        this.rect = new Rectangle(points[0],2*b,2*a);
    }

    @Override
    public boolean isValid(){
        return a>0 && b>0;
    }

    @Override
    public void initialize()
    {
        do {
            points[0].initialize();
            System.out.println("Enter a value for  a:");
            this.a = Help.INPUT.nextDouble();
            System.out.println("Enter a value for  b:");
            this.b = Help.INPUT.nextDouble();
        }
        while(!isValid());
    }

    @Override
    public double calculatePerimeter(){
        return rect.calculatePerimeter();
    }

    @Override
    public double calculateArea(){
        return rect.calculateArea() - elipse.calculateArea();
    }

    @Override
    public String getType(){
        if (a==b){
            return "Quadrat/Circle";
        }
        else{
            return "Rectangle/Elipse";
        }
    }

    @Override
    public Shape createShape(int scale)
    {
        Shape rectangle = rect.createShape(scale);
        Shape elipse = ellipse.createShape(scale);
        return Shape.union(rectangle,elipse);
    }

    @Override
    public boolean contains(double x, double y){
        return rect.contains(x,y) && !ellipse.contains(x,y);
    }


}
