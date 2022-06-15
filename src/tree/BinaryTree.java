package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * オーソドックスなバイナリツリー。
 *
 */
public class BinaryTree {
	Node root;
	
	public BinaryTree() {
		// TODO optionalにする
		this.root = null;
	}
	
	// このinterfaceが見えるかどうかが重要
	public void add(int value) {
		root = append(root, value);
	}
	
	Node append(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}
		
		if (value < current.value) {
			current.left = append(current.left, value);
		} else if (value > current.value) {
			current.right = append(current.right, value);
		} else {
			return current;
		}
		
		return current;
	}
	
	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}
	
	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		
		if (value == current.value) {
			return true;
		}
		
		return value < current.value ? containsNodeRecursive(current.left, value) : containsNodeRecursive(current.right, value);
	}
	
	
	public void traverseInOrder() {
		traverseInOrder(this.root);
	}

	private void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.println(node.value);
			traverseInOrder(node.right);
		}
	}
	
	// 幅優先探索
	public void traverseLevelOrder() {
		if (this.root == null) {
			return;
		}
		
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		
		while (!nodes.isEmpty()) {
			Node node = nodes.remove();
			// TODO 処理に変更する
			System.out.println( node.value);
			
			if (node.left != null) {
				nodes.add(node.left);
			}
			
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(4);
		bt.add(2);
		bt.add(7);
		bt.add(1);
		bt.add(3);
		bt.add(6);
		bt.add(9);
		System.out.println(bt.containsNode(1));
		System.out.println(bt.containsNode(-1));
		bt.traverseInOrder();
		
		System.out.println("****");
		
		bt.traverseLevelOrder();
	}
}
















