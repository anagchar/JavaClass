package GraphDiagram;

/**
 * @invar | getRadius() > 0
 */
public final class CircularNode extends Node {
	
	/**
	 * @invar | radius > 0
	 */
	int radius;
	
	/**
	 * 
	 * @inspects | this
	 */
	public int getRadius() { 
		return this.radius;
	}
	
	/**
	 * @throws IllegalArgumentException | radius < 0
	 * @post | getRadius() == radius
	 */
	public CircularNode(int radius) {
		if (radius < 0) {
			throw new IllegalArgumentException("This departure angle is out of the bounds");
		}
		this.radius = radius;
	}

	@Override
	public int AreaOfNode() {
		return radius * 314/100;
	}

	@Override
	public boolean isIsomorphicWith(Node other) {
		return other instanceof CircularNode node && radius == node.radius;
	}


}
