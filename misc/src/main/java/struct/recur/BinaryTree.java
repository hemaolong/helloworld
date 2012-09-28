package struct.recur;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import struct.AbsTree;

public class BinaryTree implements AbsTree {
	public static enum TraverseType {
		PRE_ORDER, IN_ORDER, POST_ORDER,
	}

	public static class BinaryTreeNode {
		private Object data;
		private BinaryTreeNode left;
		private BinaryTreeNode right;
		private BinaryTreeNode parent;
	}

	private List<BinaryTreeNode> nodeList = new LinkedList<BinaryTreeNode>();

	public static void traverse_recur(BinaryTreeNode node, TraverseType order) {
		switch (order) {
		case PRE_ORDER:
			System.out.print(node.data);
			if (node.left != null) {
				traverse_recur(node.left, order);
			}
			if (node.right != null) {
				traverse_recur(node.right, order);
			}
			break;
		case IN_ORDER:
			if (node.left != null) {
				traverse_recur(node.left, order);
			}
			System.out.print(node.data);
			if (node.right != null) {
				traverse_recur(node.right, order);
			}
			break;
		case POST_ORDER:
			if (node.left != null) {
				traverse_recur(node.left, order);
			}
			if (node.right != null) {
				traverse_recur(node.right, order);
			}
			System.out.print(node.data);
			break;
		}

	}

	private static int findIndex(List<Object> list, Object key) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == key) {
				return i;
			}
		}
		System.out.println("Failed to find the element " + key);
		return -1;
	}

	public static BinaryTreeNode createTree_recur(List<Object> preOrder,
			List<Object> inOrder) {
		BinaryTreeNode _root = null;
		// The head of the preOrder if the root node
		_root = new BinaryTreeNode();
		_root.data = preOrder.get(0);

		// The all elements in the inOrder before the root is the left tree
		int _rootIndex = findIndex(inOrder, _root.data);
		int _leftTreeLen = _rootIndex;
		int _rightTreeLen = inOrder.size() - _leftTreeLen - 1;

		if (_leftTreeLen > 0) {
			_root.left = createTree_recur(
					preOrder.subList(1, _leftTreeLen + 1),
					inOrder.subList(0, _leftTreeLen));
			_root.left.parent = _root;
		}

		if (_rightTreeLen > 0) {
			_root.right = createTree_recur(
					preOrder.subList(_leftTreeLen + 1, preOrder.size()),
					inOrder.subList(_leftTreeLen + 1, inOrder.size()));
			_root.right.parent = _root;
		}

		return _root;
	}

	public static int getDegree() {
		return 0;
	}

	private static void visit(BinaryTreeNode node) {
		System.out.println(node.data);
	}

	public static void traverseInOrder(BinaryTreeNode head) {
		if (head == null) {
			return;
		}

		// Push the root node
		Stack<BinaryTreeNode> _nodeStack = new Stack<BinaryTreeNode>();
		_nodeStack.push(head);
		while (!_nodeStack.isEmpty()) {
			// Push the left tree
			while (_nodeStack.lastElement() != null) {
				visit(_nodeStack.lastElement());
				_nodeStack.push(_nodeStack.lastElement().left);
			}

			_nodeStack.pop();
			if (!_nodeStack.isEmpty()) {
				// The left tree is empty, pop self
				BinaryTreeNode _tmp = _nodeStack.pop();
				
				// _nodeStack.pop();
				// Parse the right tree
				_nodeStack.push(_tmp.right);
			}
		}
	}

	public static int getDepth(BinaryTreeNode head) {
		int _leftDepth = 0;
		int _maxDepth = 0;
		Stack<BinaryTreeNode> _nodeStack = new Stack<BinaryTreeNode>();
		BinaryTreeNode _tmp = head;
		_nodeStack.push(_tmp);
		System.out.println(_tmp.data);
		_leftDepth++;
		while (!_nodeStack.isEmpty()) {
			_tmp = _nodeStack.lastElement();

			// Push the left tree
			while (_tmp.left != null) {
				_tmp = _tmp.left;
				visit(_tmp);
				_nodeStack.push(_tmp);
				_leftDepth++;
			}

			// Pop self
			_nodeStack.pop();

			// Push the right tree
			if (!_nodeStack.isEmpty()) {
				// Pop the parent
				_tmp = _nodeStack.pop();
				if (_tmp.right != null) {
					_tmp = _tmp.right;
					visit(_tmp);
					_nodeStack.push(_tmp);

					_leftDepth++;
				} else {
					if (!_nodeStack.isEmpty()) {
						_nodeStack.pop();

						if (_maxDepth < _leftDepth) {
							_maxDepth = _leftDepth;
						}
						_leftDepth--;
					}
				}
			}
		}

		return _maxDepth;
	}

	public static int getDepth_recur(BinaryTreeNode node) {
		int _maxDepth = 0;
		int _depth = 1;

		int _leftDepth = 0;
		int _rightDepth = 0;
		if (node.left != null) {
			_leftDepth = getDepth_recur(node.left);
		}
		if (node.right != null) {
			_rightDepth = getDepth_recur(node.right);
		}

		_depth += Math.max(_leftDepth, _rightDepth);
		if (_depth > _maxDepth) {
			_maxDepth = _depth;
		}
		return _maxDepth;
	}

	public static int getNodeCount_recur(BinaryTreeNode node) {
		int _result = 0;

		_result++;
		if (node.left != null) {
			_result += getNodeCount_recur(node.left);
		}
		if (node.right != null) {
			_result += getNodeCount_recur(node.right);
		}

		return _result;
	}

	public boolean isEmpty() {
		return nodeList.isEmpty();
	}
}
