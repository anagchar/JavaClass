package colors_oop;

import java.util.Objects;

public class TransparentColor extends Color {
	
	public final int transparency;
	
	public TransparentColor(int red, int green, int blue, int transparency) {
		super(red, green, blue);
		this.transparency = transparency;
	}
	
	public int getTransparency() { return transparency; }
	
	@Override
	public boolean equals(Object other) {
		return super.equals(other) && other instanceof TransparentColor c && transparency == c.transparency;
	}
	
//	@Override
//	public boolean equals(Object other) {
//		return super.equals(other) && transparency == ((TransparentColor)other).transparency;
//	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), transparency);
	}

}
