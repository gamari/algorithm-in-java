package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 逆順のバイナリツリー。
 *
 */
public class InvertBinaryTree {
	Node root;
	
	public InvertBinaryTree() {
		// TODO optionalにする
		this.root = null;
	}
	
	public void add(int value) {
		root = append(root, value);
	}
	
	Node append(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}
		
		if (value < current.value) {
			current.right = append(current.right, value);
		} else if (value > current.value) {
			current.left= append(current.left, value);
		} else {
			return current;
		}
		
		return current;
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
		InvertBinaryTree bt = new InvertBinaryTree();
		bt.add(4);
		bt.add(2);
		bt.add(7);
		bt.add(1);
		bt.add(3);
		bt.add(6);
		bt.add(9);
		
		System.out.println("****");
		
		bt.traverseLevelOrder();
	}
}
