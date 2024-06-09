package Network;

import java.awt.Color;

public class CircularNodeApperance extends NodeAppearance {
	
	private int radius;
	
	public int getRadius() {
		return radius;
	}

	public CircularNodeApperance(Color color, int radius) {
		super(color);
		this.radius = radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof CircularNodeApperance cna && this.getColor() == cna.getColor() && this.radius == cna.radius;
	}

}
