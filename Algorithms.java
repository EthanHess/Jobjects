//Studying for a Google interview, coutresy of HackerRank and Gayle Laakmann McDowell for original code

//IMPORTS

import java.io.*; 
import java.util.*; 
import java.text.*; 
import java.math.*; 
import java.util.regex.*; 

//Merge sort - Splitting an array in half, sorting, then re-merging them

public class MergeSortSolution {

	public static void mergesort(int[] array) {
		mergesort(array, new int[array.length], 0, array.length - 1); 
	}

	public static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {

		if (leftStart >= rightEnd) {
			return;
		}

		int middle = (leftStart + rightEnd) / 2; 
		mergesort(array, temp, leftStart, middle); 
		mergesort(array, temp, middle + 1, rightEnd); 
		mergeHalves(array, temp, leftStart, rightEnd); 
	}

	public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {

		int leftEnd = (rightEnd + leftStart) / 2; 
		int rightStart = leftEnd + 1; 
		int size = rightEnd - leftStart + 1; 

		int left = leftStart; 
		int right = rightStart; 
		int index = leftStart; 

		while (left <= leftEnd && right <= rightEnd) {
			if (array[left] <= array[right]) {
				temp[index] = array[left]; 
				left++; 
			} else {
				temp[index] = array[right]; 
				right++; 
			}
			index++; 
		}

		System.arraycopy(array, left, temp, index, leftEnd - left + 1); 
		System.arraycopy(array, right, temp, index, rightEnd - right + 1); 
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}
}

//Now to quicksort

public class QuickSortSolution {

	public static void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}

	public static void quicksort(int[] array, int left, int right) {

		if (left >= right) {
			return; 
		}

		int pivot = array[(left + right) / 2]; 
		int index = partition(array, left, right, pivot); 

		quicksort(array, left, index - 1); 
		quicksort(array, index, right); 
	}

	public static int partition(int[] array, int left, int right, int pivot) {
		while (left <= right) {
			while (array[left] < pivot) {
				left++; 
			}
			while (array[right] > pivot) {
				right--;
			}

			if (left <= right) {
				swap(array, left, right); 
				left++; 
				right--; 
			}
		}
	}
	return left; 
}

//Graph search (Depth first search <deep> and Breadth first search <broad>)

public class GraphSearchSolution {

	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>(); 

	public static class Node {
		private int id; 
		LinkedList<Node> adjecent = new LinkedList<Node>(); 
		private Node(int id) {
			this.id = id; 
		}
	}

	//Complete
}

//Tree search (A tree is a minimally connected/simplified graph with only one path connecting vertices, graphs can have more than one)
//Trees are hierarchical wheras graphs are just a network 

class Node {

	Node left, right; 
	int data; 

	public Node(int data) {
		this.data = data; 
	}

	public void insert(int value) {
		if (value <= data) {
			if (left == null) {
				left = new Node(value); 
			} else {
				left.insert(value); 
			}
		} else {
			if (right == null) {
				right = new Node(value); 
			} else {
				right.insert(value); 
			}
		}
	}

	public boolean contains(int value) {
		if (value == data) {
			return true; 
		} else if (value < data) {
			if (left == null) {
				return false; 
			} else {
				return left.contains(value); 
			}
		} else {
			if (right == null) {
				return false; 
			} else {
				return right.contains(value); 
			}
		}
	}

	public void printInOrder() {
		if (left != null) {
			left.printInOrder(); 
		}
		System.out.println(data); 
		if (right != null) {
			right.printInOrder(); 
		}
	}
}

//Code from Geeks for Geeks

//Inorder traversal is Left, Root, Right (nondecreasing)
//Preorder traversal is Root, Right, Left (creates copy of tree)
//Postorder traversal is Left, Right, Root (used to delete the tree)

class MyNode {

	int key;
    MyNode left, right;
 
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {

	MyNode root; 

	BinarySearchTree() {
		root = null; 
	}

	void printPostorder(MyNode node) {

		if (node == null)
			return; 

		//left subtree recursion
		printPostorder(node.left); 
		//right subtree recursion
		printPostorder(node.right); 

		System.out.print(node.key + " "); 
	}

	void printInorder(MyNode node) {

		if (node == null)
			return; 

		printInorder(node.left); 
		System.out.print(node.key + " "); 
		printInorder(node.right); 
	}

	void printPreorder(MyNode node) {

		if (node == null)
			return; 

		System.out.print(node.key + " ");
		printPreorder(node.left); 
		printPreorder(node.right); 
	}

	//wrapper functions

	void printPostorder() { printPostorder(root); }
	void printInorder()   { printInorder(root); }
    void printPreorder()  { printPreorder(root); }

    public static void main (String[] args) {

    	BinarySearchTree tree = new BinarySearchTree(); 

    	//set up tree
    	tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5); 

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();
 
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();
 
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }
}
