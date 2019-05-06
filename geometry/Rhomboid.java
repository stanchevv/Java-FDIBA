package geometry;

import javafx.scene.shape.Shape;

public class Rhomboid extends GeometricObject {
	private double a;
	private double b;
	private Quadrangle quadrangle;//dobavqsh tuk elipse
	
	public Rhomboid() {
		super("Rhomboid", 1, 0);// 1dna tochka; 0 strani
		points[0] = new Point(0, 0);
		a = 1;
		b = 1;
		
		calculateFigure();
		
	}
	
	public Rhomboid(Point startPoint, double height, double width) {
		super("Rhomboid", 1, 0);
		points[0] = new Point(startPoint);
		this.a = height;
		this.b = width;
		
		calculateFigure(); //izvikvame funkciqta
		
	}
	
	public Rhomboid(Rhomboid otherRhomboid) {
		super("Rhomboid", 1, 0);
		points[0] = new Point(otherRhomboid.points[0]);
		a = otherRhomboid.a;
		b = otherRhomboid.b;		
		calculateFigure();
	}

	private void calculateFigure() {
		double x=points[0].x; 
		double y=points[0].y; 
		Point p1 = new Point (x + a/2, y);
		Point p2 = new Point (x, points[0].y + b/2);
		Point p3 = new Point (x + a/2,y + b);
		Point p4 = new Point (x + a, y + b/2);
		quadrangle = new Quadrangle(p1, p2, p3, p4);		
	}

	@Override
	public Shape createShape(int scale) {
		return quadrangle.createShape(scale);
	}

	@Override
	public boolean contains(double x, double y) {
		return quadrangle.contains(x, y);
	}

	@Override
	public boolean isValid() {
		return a>0 && b>0;
	}

	@Override
	public void initialize() {
		do {
			System.out.println("Anfangspunkt");
			points[0].initialize();

			System.out.print("Hoehe: ");
			a = Help.INPUT.nextDouble();
			System.out.print("Breite: ");
			b = Help.INPUT.nextDouble();
		} 
		while (!isValid());
		
		calculateFigure();
	}

	@Override
	public double calculatePerimeter() {
		return quadrangle.calculatePerimeter();//lesno
	}

	@Override
	public double calculateArea() {
		return quadrangle.calculateArea();
	}

	@Override
	public String getType() {
		return (a == b) ? "Rhombus" : "Rhomboid";
	}

	@Override
	public String toString() {
		return points[0] + "(" + a + ", " + b + ")";
	}

	@Override
	public boolean equal(GeometricObject otherGeometricObject) {
		if (otherGeometricObject instanceof Rhomboid) {
			
			Rhomboid otherRhomboid = (Rhomboid) otherGeometricObject;
			boolean sameHeight = Help.equal(a, otherRhomboid.a);
			boolean sameWidth = Help.equal(b, otherRhomboid.b);
			boolean sameHeightReversed = Help.equal(a, otherRhomboid.b);
			boolean sameWidthReversed = Help.equal(b, otherRhomboid.a);
			return (sameHeight && sameWidth) || (sameHeightReversed && sameWidthReversed);
		} 
		else {
			return false;
		}
	}
}