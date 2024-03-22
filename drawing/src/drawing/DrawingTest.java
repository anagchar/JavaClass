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

abstract class Shape { // Shape is the supperclass of Circle and Polygon
	
}

class Circle extends Shape { // Circle is a subclass of Shape
	final Point center;
	final int radius;

	Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
}

class Polygon extends Shape { // Polygon is a subclass of Shape
	final Point[] vertices;

	Polygon(Point[] vertices) {
		this.vertices = vertices.clone();
	}
}

class Drawing {
	Shape[] shapes;
	
	String toSVG() {
		String result = "<svg xmlns='http://w3c.org/2000/SVG'>";
		for (Shape shape : shapes) { // enhanced for loop
			if (shape instanceof Circle circle) {
				// Circle circle = (Circle) shape; //typecast: accepted by the static type check; checked by the runtime; throws ClassCastException if false
				result += "<circle x='" + circle.center.x + "' y='" + circle.center.y + "' r='" + circle.radius + "'/>";
			} else {
				Polygon polygon = (Polygon) shape; //typecast: accepted by the static type check; checked by the runtime; throws ClassCastException if false
				result += "<polygon points='";
				for (Point p : polygon.vertices) {
					result += " " + p.x + " " + p.y;
				result += "'/>";
				}
				assert shape instanceof Polygon;
			}
			}
		return result + "</svg>";
		}
	}

class DrawingTest {

	@Test
	void test() {
		Drawing myDrawing = new Drawing();
		myDrawing.shapes = new Shape[] { new Circle(new Point(10, 20), 30),
				new Polygon(new Point[] { new Point(0, 0), new Point(10, 0), new Point(0, 10) }) };
		
		assertEquals("<svg xmlns='http://w3c.org/2000/SVG'><circle x='10' y='20' r='30'/><polygon points=' 0 0 10 0 0 10'/></svg>", myDrawing.toSVG());
		
		Shape myShape1 = new Circle(new Point(10, 20), 30);
		Shape myShape2 = new Polygon(new Point[] { new Point(0, 0), new Point(10, 0), new Point(0, 10) });
	}
	

}
