package colors_oop;

import java.util.Objects;

public class Color {

	public final int red, blue, green;
	
	public Color(int red, int blue, int green) {
		this.red = red;
		this.blue = blue;
		this.green = green;
	}
	
	public int getHue() {
		return 0;
	}
	
	public int getSaturation() {
		return 0;
	}
	
	public int getValue() {
		return 0;
	}
	
	@Override
	public boolean equals(Object other) {
		Color c = (Color) other;
		return red == c.red && green == c.green & blue == c.blue;
//		return red == ((Color)other).red && green == ((Color)other).green && blue == ((Color)other).blue;
		//return other instanceof Color c && red == c.red && green == c.green & blue == c.blue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(red, green, blue);
	}
}
