package Network;

import java.awt.Color;

public class SquareNodeAppearance extends NodeAppearance {
	
	private int width;
	
	public int getWidth() {
		return width;
	}

	public SquareNodeAppearance(Color color, int width) {
		super(color);
		this.width = width;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof SquareNodeAppearance sq && sq.getColor() == this.getColor() && this.width == sq.width;
	}

}
