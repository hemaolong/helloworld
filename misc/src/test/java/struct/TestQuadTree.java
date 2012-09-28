package struct;

import org.junit.Test;

import struct.recur.QuadTree;

public class TestQuadTree {

	@Test
	public void testCreateTree() {
		QuadTree _tree = new QuadTree(2, 2, 2);
		outputTree(_tree);
	}

	private void outputTree(QuadTree tree) {
		System.out.println("Tree info");
		System.out.format("  Width: %d, Height: %d, Node Size: %d\n",
				tree.getWidth(), tree.getHeight(), tree.getNodeSize());
		System.out.println("Head node info");
		System.out.format("  Head width: %d, height: %d\n", tree.getWidth(),
				tree.getHeight());
		
	}
}
