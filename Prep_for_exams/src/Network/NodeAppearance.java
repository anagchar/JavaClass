package Network;

import java.awt.Color;

/**
 * @immutable
 */
public abstract class NodeAppearance {
	
	private Color color;
	
	public Color getColor() {
		return color;
	}
	
	public NodeAppearance(Color color) {
		this.color = color;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof NodeAppearance na && this.color == na.color;
	}

}
