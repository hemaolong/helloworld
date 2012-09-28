package struct.recur;
import struct.AbsTree;;

public class QuadTree implements AbsTree{
	private int width;
	private int height;
	private int nodeSize;

	// Node list
	private QuadNode head;

	public QuadTree(int w, int h, int nodeSize) {
		if (w > 0 && h > 0 && nodeSize > 0) {
			this.width = w;
			this.height = h;
			this.nodeSize = nodeSize;

			this.head = new QuadNode(null, w, h, nodeSize);
		}
	}
	
	

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getNodeSize() {
		return nodeSize;
	}

	public int getNodeCount() {
		if (head == null) {
			return 0;
		}
		return 0;
	}
}
