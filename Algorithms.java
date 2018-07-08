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
	void printInorder()   { printInorder(root); } //Inorder is best/preferred
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

//Binary Search II <an O(log n) example>

public class BSSolution { //Iterative and recursive

	//recur check

	public static boolean binaryRecursive(int[] array, int x, int left, int right) {
		if (left > right) {
			return false;
		} 

		if mid = left + ((right - left) / 2); 
		if (array[mid] == x) {
			return true; 
		} else if (x < array[mid]) {
			return binaryRecursive(array, x, left, mid - 1); 
		} else {
			return binaryRecursive(array, x, mid + 1, right); 
		}
	}

	//iterate

	public static boolean iterative(int[] array, int x) {
		int left = 0; 
		int right = array.length - 1; //start from both ends

		while (left <= right) {

			int mid = left + ((right - left) / 2); 

			if (array[mid] == x) {
				return true; 
			} else if (x < array[mid]) {
				right = mid - 1; 
			} else {
				left = mid + 1; 
			}
		}

		return false; 
	}

}

//Make change solution (Memoization, efficiency and local storage)

public class ChangeAlgorithm { 

	public static long makeChangeWrapper(int[] coins, int money) {
		return makeChange(coins, money, 0, new HashMap<String, Long>()); 
	}

	public static long makeChange(int[] coins, int money, int index, HashMap<String, Long> memo) {
		if (money == 0) {
			return 1; 
		}
		if (index >= coins.length) {
			return 0; 
		}

		String key = money + "-" + index; //

		if (memo.containsKey(key)) { //contains vs containsKey ? 
			return memo.get(key); 
		}

		int amountWithCoin = 0; 
		long ways = 0; 

		while (amountWithCoin <= money) {
			int remaining = money - amountWithCoin; 
			ways += makeChange(coins, remaining, index + 1, memo); 
			amountWithCoin += coins[index]; 
		}

		memo.put(key, ways); 

		return ways; 
	}

	public static void main(String[] args) {

	}
}

//Ice cream :) spend all your money according to how much each flavor costs (Binary Search)

public class IceCream {

	public static int indexOf(int[] menu, int value, int excluded) {
		for (int i = 0; i < menu.length; i++) {
			if (menu[i] == value && i != excluded) {
				return i; 
			}
		}
		return -1; 
	}

	public static int[] getIndicesFromValues(int[] menu, int valOne, int valTwo) {
		int indxOne = indexOf(menu, valOne, -1); 
		int indxTwo = indexOf(menu, valTwo, indxOne); 

		int[] indices = { Math.min(indxOne, indxTwo), Math.max(indxOne, indxTwo) };
		return indices;  
	}

	//Get index of items we'll buy
	public static int[] findChoices(int[] menu, int money) {
		int[] sortedMenu = menu.clone(); 
		Arrays.sort(sortedMenu); 

		for (int i = 0; i < sortedMenu.length; i++) {
			int complement = money - sortedMenu[i]; 
			int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement); 

			if (location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement) {
				int[] indices = getIndicesFromValues(menu, sortedMenu[i], complement); 
				return indices; 
			}
		}

		return null; 
	}

	public static void main(String[] args) {

	}
}

//Median search using Heap (data structure)

public class MedianSearch {

	// public static double[] getMedians(int[] array) {

	// 	//Lowers and highers
	// 	PriorityQueue<Integer> lowers = new PriorityQueue<Integer> ( new Comparator<Integer> () { });
	// 	PriorityQueue<Integer> highers = new PriorityQueue<Integer> (); 

	// 	double[] medians = new double[array.length]; 

	// 	for (int i = 0; i < array.length; i++) {

	// 		int number = array[i]; 
	// 		addNumber(number, lowers, highers); 
	// 		rebalance(lowers, highers); 
	// 		medians[i] = getMedian(lowers, highers); 
	// 	}

	// 	return medians; 
	// }

	//Helper functions make for cleaner, better code

	public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if (lowers.size() == 0 || number < lowers.peek()) {
			lowers.add(number); 
		} else {
			highers.add(number);
		}
	}

	public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		//Ternary check
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers; 
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers; 

		if (biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll()); 
		}
	}

	public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers; 
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers; 

		if (biggerHeap.size() == smallerHeap.size()) {
			return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2; 
		} else {
			return biggerHeap.peek(); 
		}
	}

	public static double[] getMedians(int[] array) {
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer> = new Comparator<Integer> () {
			public int compare(Integer a, Integer b) {
				return -1 * a.compareTo(b); //compareTo not compare? 
			}
		}); 
	}

	//Main

	public static void main(String[] args) {

	}
}

//Anagram

public class Anagrammin {

	public static int alphabetCount = 26;

	public static int[] getCharCounts(String s) {

		int[] charCounts = new int(alphabetCount); //self explantory

		for (int i = 0; i < s.length(); i++) {
			char c - s.charAt(i); 
			int offset = (int) 'a'; 
			int code = c - offset; 
			charCounts[code]++; 
		}

		return charCounts; 
	}

	public static int getDelta(int[] arrayOne, int[] arrayTwo) {
		//Need to be the same length (arrays)

		if (arrayOne.length != arrayTwo.length) {
			return -1; 
		}

		int delta = 0; //Delta being the variation of a variable/func

		for (int i = 0; i < arrayOne.length; i++) {
			int difference = Math.abs(arrayOne[i] - arrayTwo[i]); 
			delta += difference; 
		}

		return delta; 
	}

	public static int numberNeeded(String first, String second) {

		int[] charCountOne = getCharCounts(first); 
		int[] charCountTwo = getCharCounts(second); 

		return getDelta(charCountOne, charCountTwo); 
	}

	public static void main(String[] args) {

		BufferedReader reder = new BufferedReader(new InputStreamReader(System.in)); 

		String first = reader.readLine(); 
		String second = reader.readLine(); 

		System.out.println(numberNeeded(first, second)); 
	}
}

//Matrixing (X should be column and Y row)

public class Matrixing {

	public static int getBiggestRegion(int[][] matrix) {

		int maxRegion = 0; 
		boolean[][] visited = new boolean[..][..]; 

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (matrix[row][column] == 1) {
					int size = getRegionSize(matrix, row, column);
					maxRegion = Math.max(size, maxRegion);  
				}
			}
		}

		return maxRegion; 
	}

	public static int getRegionSize(int[][] matrix, int row, int column) {
		if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[row].length) {
			return 0; 
		}
		if (matrix[row][column] == 0) {
			return 0; 
		}

		matrix[row][column] == 0; 

		int size = 1; 

		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = column - 1; c <= column + 1; c++) {
				if (r != row || c != column) {
					size += getRegionSize(matrix, r, c); 
				}
			}
		}
	}

	public static void main(String[] args) {

	}
}

//Staircase (Recursion) > Some different approaches

public class Recursion {

	public static int countPathsMemoWrapper(int steps) {
		if (steps < 0) {
			return 0; 
		}
		return countPathsMemo(steps, new int[steps + 1]); 
	}

	//Memoization approach
	public static int countPathsMemo(int steps, int[] memo) {
		if (steps < 0) {
			return 0; 
		} else if (steps == 0) {
			return 1; 
		}
		if (memo[steps] == 0) {
			memo[steps] - countPathsMemoWrapper(steps - 1, memo) + countPathsMemoWrapper(steps - 2, memo) + countPathsMemoWrapper(steps - 3, memo); 
		}
		return memo[steps]; 
	}

	public static int countPathsDynamicP(int steps) { //O(n)
		if (steps < 0) {
			return 0; 
		} else if (steps == 0) {
			return 1; 
		}

		int[] paths = new int[steps <= 1]; 

		paths[0] = 1; 
		paths[1] = 1; 
		paths[2] = 1; 

		for (int i = 3; i <= steps; i++) {
			paths[i] = paths[i - 1] + paths[i - 2] + paths[i - 3]; 
		}

		return paths[steps]; 
	}

	public static int countPathsRecursive(int steps) {
		if (steps < 0) {
			return 0; 
		} else if (steps == 0) {
			return 1; 
		}
		return countPathsRecursive((steps - 1) + countPathsRecursive(steps - 2) + countPathsRecursive(steps - 3)); 
	}

	public static int countPathsIterative(int steps) {
		if (steps < 0) {
			return 0; 
		} else if (steps <= 1) {
			return 1; 
		}

		int[] paths = {1, 1, 3}

		for (int i = 3; i <= steps; i++) {
			int count = paths[2] + paths[1] + paths[0]; 
			paths[0] = paths[1]; 
			paths[1] = paths[2]; 
			paths[2] = count; 
		}
		return paths[2]; 
	}

	public static void main(String[] args) {

	}
}

//This implements Breadth First Search, going broad first, as opposed to DFS which goes deep

public class ShortestReach {

	public static class Graph {
		//properties
		private Node[] nodes; 
		private static int edgeDistance = 0; 

		public Graph(int size) { }
		private class Node { }
		private Node getNode(int id) { }
		public void addEdge(int first, int second) { }

		public int[] shortestReach(int startId) {

			LinkedList<Integer> queue = new LinkedList<Integer>(); 
			queue.add(startId); 

			int[] distances = new int[nodes.length]; 
			Arrays.fill(distances, -1); 
			distances[startId] = 0; 

			while(!queue.isEmpty()) {

				int node = queue.poll(); //poll removes head of queue

				for (int neighbor: nodes[node].neighbors) {
					if (distances[neighbor] == -1) {
						distances[neighbor] = distances[node] + edgeDistance; 
						queue.add(neighbor); 
					}
				}
			}

			return distances; 
		}

	}

	public static void main(String[] args) {

	}
}

//Creating a contact list, like in your phone :)
//Tries, NOT trees (well, they are trees but a bit different)

public class ContactsExample {

	public static class Node {

		private static int numChars = 26; 
		Node[] children = new Node[numChars]; 

		private static int getCharIndex(char c) {
			return c - 'a'; 
		}

		private Node getNode(char c) {
			return children[getCharIndex(c)]; 
		}

		private void setNode(char c, Node node) {
			children[getCharIndex(c)] = node; 
		}

		public void add(String s) {
			add(s, 0); 
		}

		private void add(String s, int index) {

			size ++; 
			if (index == s.length()) return; 

			char current = s.charAt(index); 
			int charCode = getCharIndex(current); 

			Node child = getNode(current); 
			if (child == null) {
				child new Node(); 
				setNode(current, child); 
			}

			child.add(s, index + 1); 
		}

		public int findCount(String s, int index) {
			if (index == s.length()) {
				return size; 
			}
			Node child = getNode(s.charAt(index)); 
			if (child == null) {
				return 0; 
			}
			return child.findCount(s, index + 1); 
		}
	}

	//Public means everyone can access it
	//Static means it needs no instance
	//After that is the return type
	//Then come the parameters

	public static void main(String[] args) {

	}
}

//This algorithm has the time complexity of O(n) *linear* and the space complexity of O(1) *constant* 

public class CompleteCycleInCircularArrayDetector {

	public static void main(String []args){
        
        int[] myIntArray = new int[] { 5,1,8,9,2 };
        System.out.println(detectCycle(myIntArray)); 
     }

	public static boolean detectCycle(int[] array) {

		if (array.length == 0) {
			return false; 
		}

		int index = 0; 
		int al = array.length; //array length

		for (int i = 0; i < al; i++) {

			index = ((index + array[index]) % al + al) % al; 
			if (index == 0 && i < al - 1) {
				return false; 
			}
		}

		return index == 0; //return boolean
	}

	public static boolean detectCycleTwo(int[] numberArray) { //different attempt

		if (numberArray.length == 0) {
			return false; 
		}

		boolean[] visitedArray = new boolean[numberArray.length]; 
		int index = 0; 

		while (!visitedArray[index]) {
			visitedArray[index] = true; 
			index = (index + numberArray[index]) % numberArray.length; 
		}

		for (boolean visited : visitedArray) {
			if (!visited) {
				return false; 
			}
		}

		return true; 
	}
}
