package tutorial1;

public class Vector {
	private int x;
	private int y;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector v1 = new Vector(3, 4);
		int magnitude = v1.magnitude();
        System.out.println("Magnitude of the vector: " + magnitude);
        int av = v1.average();
        System.out.println("The average size is " + av);
        Vector v2 = new Vector(1,2);
        Vector sum = v1.add(v2);
        System.out.println("Sum of the vector: " + sum);
        Vector trans = v2.shift(v1);
        System.out.println("The new variable: " + trans);
	}
	
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int magnitude() {
		int squaredMagnitude = x*x + y*y;
		return sqrt(squaredMagnitude);
    }
	
	private int sqrt(int x) {
		int i = 0;
        while (i * i < x) {
            i++;
        }
        return i; 
	}
	public int average() {
		return (x+y)/2;
	}
	public Vector add(Vector other) {
        int newX = this.x + other.x;
        int newY = this.y + other.y;
        return new Vector(newX, newY);
    }
	@Override
	public String toString() {
	    return "(" + x + ", " + y + ")";
	}
	public Vector shift(Vector other) {
		int newX = this.x;
		int newY = this.y;
		return new Vector(newX, newY);
	}
	
}
