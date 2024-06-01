package GraphDiagram;

/**
 * @invar | getWidth() > 0 && getHeight() > 0
 */
public final class RectangularNode extends Node {
	
	/**
	 * @invar | width > 0 && height > 0
	 */
	int width;
	int height;
	
	/**
	 * 
	 * @inspects | this
	 */
	public int getWidth() { 
		return this.width;
	}
	
	/**
	 * @inspects | this
	 */
	public int getHeight() { 
		return this.height;
	}
	
	/**
	 * @throws IllegalArgumentException | width < 0 || height < 0
	 * @post | getWidth() == width && getHeight() == height
	 */
	public RectangularNode(int width, int height) {
		if (width < 0 || height < 0) {
			throw new IllegalArgumentException("This departure angle is out of the bounds");
		}
		this.width = width;
		this.height = height;
	}
	
	@Override
	public int AreaOfNode() {
		return width * height;
	}

	@Override
	public boolean isIsomorphicWith(Node other) {
		return other instanceof RectangularNode node && height == node.height && width == node.width;
	}

}
