package drawing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class Point {
	final int x;
	final int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Shape extends Object { // Shape is the direct superclass of Circle and Polygon
	
}

final class Circle extends Shape { // Circle is a subclass of Shape
	final Point center;
	final int radius;

	Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
}

final class Polygon extends Shape { // Polygon is a subclass of Shape
	final Point[] vertices;

	Polygon(Point[] vertices) {
		this.vertices = vertices.clone();
	}
}

class Oval extends Shape {
	Point focus1;
	Point focus2;
}

class Drawing {
    Shape[] shapes;
    
    String toSVG() {
        String result = "<svg xmlns='http://www.w3.org/2000/svg'>";
        for (Shape shape : shapes) {
            switch(shape) {
                case Circle circle -> {
                    result += "<circle cx='" + circle.center.x + "' cy='" + circle.center.y + "' r='" + circle.radius + "'/>";
                }
                case Polygon polygon -> {
                    result += "<polygon points='";
                    for (Point p : polygon.vertices) {
                        result += " " + p.x + "," + p.y;
                    }
                    result += "'/>";
                }
                default -> throw new AssertionError();
            }
        }
        return result + "</svg>";
    }
}

class DrawingTest {

	@Test
	void test() {
		Drawing myDrawing = new Drawing();
		myDrawing.shapes = new Shape[] { 
				new Circle(new Point(10, 20), 30),
				new Polygon(new Point[] { new Point(0, 0), new Point(10, 0), new Point(0, 10) }),
				new Oval()}; // This will throw an exception because we are trying to add Oval without typecasting it to Circle or Polygon
		
		assertEquals("<svg xmlns='http://w3c.org/2000/SVG'><circle x='10' y='20' r='30'/><polygon points=' 0 0 10 0 0 10'/></svg>", myDrawing.toSVG());
		
		Shape myShape1 = new Circle(new Point(10, 20), 30);
		Shape myShape2 = new Polygon(new Point[] { new Point(0, 0), new Point(10, 0), new Point(0, 10) });
	}
	

}
