package struct;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import struct.recur.BinaryTree;
import struct.recur.BinaryTree.BinaryTreeNode;

public class TestBinaryTree {

	private Object[] traverse(BinaryTreeNode head, boolean recursive,
			BinaryTree.TraverseType type) {
		List<Object> _result = new ArrayList<Object>();
		if (recursive) {
			switch (type) {
			case PRE_ORDER: {
				BinaryTree.traverse_recurPreOrder(head, _result);
				break;
			}
			case IN_ORDER: {
				BinaryTree.traverse_recurInOrder(head, _result);
				break;
			}
			case POST_ORDER: {
				BinaryTree.traverse_recurPostOrder(head, _result);
				break;
			}
			}
		} else {
			switch (type) {
			case PRE_ORDER: {
				BinaryTree.traversePreOrder(head, _result);
				break;
			}
			case IN_ORDER: {
				BinaryTree.traverseInOrder(head, _result);
				break;
			}
			case POST_ORDER: {
				break;
			}
			}
		}
		return _result.toArray();
	}

	private void testTraverse(String preOrder, String inOrder) {
		List<Object> _preList = new ArrayList<Object>();
		for (char _tmp : preOrder.toCharArray()) {
			_preList.add(_tmp);
		}

		List<Object> _inList = new ArrayList<Object>();
		for (char _tmp : inOrder.toCharArray()) {
			_inList.add(_tmp);
		}
		BinaryTreeNode _headNode = BinaryTree.createTree_recur(_preList,
				_inList);

		assertArrayEquals("RecurPreOrder", _preList.toArray(),
				traverse(_headNode, true, BinaryTree.TraverseType.PRE_ORDER));
		assertArrayEquals("RecurInOrder", _inList.toArray(),
				traverse(_headNode, true, BinaryTree.TraverseType.IN_ORDER));
		/*assertArrayEquals("PostOrder", _preList.toArray(),
				traverse(_headNode, true, BinaryTree.TraverseType.POST_ORDER));*/
		
		assertArrayEquals("PreOrder", _preList.toArray(),
				traverse(_headNode, false, BinaryTree.TraverseType.PRE_ORDER));
		assertArrayEquals("InOrder", _inList.toArray(),
				traverse(_headNode, false, BinaryTree.TraverseType.IN_ORDER));


		// System.out.println("The tree depth: " +
		// BinaryTree.getDepth(_headNode));
		System.out.println("The node count: "
				+ BinaryTree.getNodeCount_recur(_headNode));
	}

	@Test
	public void testCreateTree() {
		String _preOrder = "-+a*bXcd/ef";
		String _inOrder = "a+b*cXd-e/f";
		// String _preOrder = "CABD";
		// String _inOrder = "ABCD";
		/*
		 * String _preOrder = "-+a"; String _inOrder = "a+-";
		 */

		testTraverse(_preOrder, _inOrder);

	}
}
