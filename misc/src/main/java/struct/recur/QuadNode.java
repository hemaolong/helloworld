package struct.recur;

public class QuadNode {
	private QuadNode parent;

	private QuadNode child0;
	private QuadNode child1;
	private QuadNode child2;
	private QuadNode child3;

	private int width;
	private int height;

	public QuadNode(QuadNode parent, int w, int h, int maxSize) {
		this.width = w;
		this.height = h;

		boolean leafNode = (width <= maxSize && height <= maxSize);
		if (!leafNode) {
			createChildNodes(maxSize);
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public QuadNode getParent() {
		return parent;
	}
	
	public int getDegree(){
		int _result = 0;
		if (child0 != null){
			_result++;
		}
		if (child1 != null){
			_result++;
		}
		if (child2 != null){
			_result++;
		}
		if (child3 != null){
			_result++;
		}
		return _result;
	}

	public QuadNode getLeftChild(int index) {
		return child0;
	}
	
	public QuadNode getRightChild(int index) {
		return child2;
	}
	
	public QuadNode getUpChild(int index) {
		return child1;
	}
	
	public QuadNode getDownChild(int index) {
		return child3;
	}

	// //////////
	private void createChildNodes(int maxSize) {
		int _width = width;
		if (width > maxSize){
			_width = _width >> 1;
		}
		int _height = height;
		if (height > maxSize) {
			_height = _height >> 1;
		}
		
		if (width > maxSize) {
			child0 = new QuadNode(this, _width, _height, maxSize);
			child2 = new QuadNode(this, _width, _height, maxSize);
		}
		if (height > maxSize) {
			child1 = new QuadNode(this, _width, _height, maxSize);
			child3 = new QuadNode(this, _width, _height, maxSize);
		}
	}
}
