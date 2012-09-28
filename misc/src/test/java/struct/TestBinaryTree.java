package struct;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import struct.recur.BinaryTree;
import struct.recur.BinaryTree.BinaryTreeNode;

public class TestBinaryTree {

	@Test
	public void testCreateTree() {
		String _preOrder = "-+a*bXcd/ef";
		String _inOrder = "a+b*cXd-e/f";
		// String _preOrder = "CABD";
		// String _inOrder = "ABCD";
		/*String _preOrder = "-+a";
		String _inOrder = "a+-";*/

		List<Object> _preList = new ArrayList<Object>();
		for (char _tmp : _preOrder.toCharArray()) {
			_preList.add(_tmp);
		}

		List<Object> _inList = new ArrayList<Object>();
		for (char _tmp : _inOrder.toCharArray()) {
			_inList.add(_tmp);
		}
		BinaryTreeNode _headNode = BinaryTree.createTree_recur(_preList, _inList);
		
		System.out.println("Recursive traverse the tree");
		BinaryTree.traverse_recur(_headNode, BinaryTree.TraverseType.POST_ORDER);
		System.out.println("Stack traverse the tree");
		BinaryTree.traverseInOrder(_headNode);
		
		//System.out.println("The tree depth: " + BinaryTree.getDepth(_headNode));
		System.out.println("The node count: " + BinaryTree.getNodeCount_recur(_headNode));
	}
}
