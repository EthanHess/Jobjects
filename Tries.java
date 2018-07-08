//Imports
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
 
//From La Vivien Amazon interview practice
//TODO redo in Objective-C

class TrieNode {

	//MARK properties
	char data; 
	LlinkedList<TrieNode> children; 
	TrieNode parent; 
	boolean isEnd; 

	//
	public TrieNode(char c) {
		data = c; 
		children = new LlinkedList<TrieNode>(); 
		isEnd = false; 
	}

	public TrieNode getChild(char c) { //Get child and retun null if it doesn't exist

		if (children != null) {
			for (TrieNode child : children) {
				if (child.data == c) {
					return child; 
				}
			}
		}

		return null; 
	}

	//Similary to private but subclasses can access it
	protected List<String> getWords() {

		List<String> list = new ArrayList<String>(); 
		if (isEnd) {
			list.add(toString()); 
		}

		if (children != null) {
			for (int i=0; i < children.size(); i++) {
				if (children.get(i) != null) {
					list.addAll(children.get(i).getWords()); 
				}
			}
		}

		return list; 
	}

	public String toString() {
		if (parent == null) {
			return ""; 
		} else {
			return parent.toString() + new String(new char[] {data}); 
		}
	}
}

class Trie {

	private TrieNode root; 

	public Trie() {
		root = new TrieNode(' '); 
	}

	public void insert(String word) {

		if (search(word) == true) {
			return; 
		}

		TrieNode current = root; 
		TrieNode pre; 

		for (char ch : word.toCharArray()) {
			pre = current; 
			TrieNode child = current.getChild(ch); 

			if (child != null) {
				current = child; 
				child.parent = pre; 
			} else {
				current.children.add(new TrieNode(ch)); 
				current = current.getChild(ch); 
				current.parent = pre; 
			}
		}

		current.isEnd = true; 
	}

	public boolean search(String word) {

		TrieNode current = root; 
		for (char ch : word.toCharArray()) {
			if (current.getChild(ch) == null) {
				return false; 
			} else {
				current = current.getChild(ch); 
			}
		}
		if (current.isEnd == true) {
			return true; 
		}

		return false; 
	}

	public List autoComplete(String prefix) {

		TrieNode lastNode = root; 

		for (int i = 0; i < prefix.length(); i++) {
			lastNode = lastNode.getChild(prefix.charAt(i)); 
			if (lastNode == null) {
				return new ArrayList(); 
			}
		}

		return lastNode.getWords(); 
	}
}

public class TrieAutocomplete {

	//Time O(n), n would be the longest string
	//Space O(nxm), m being the number of words in the trie

	public static void main(String[] args) {

		Trie theTrie = new Trie(); 

		theTrie.insert("ethan");
		theTrie.insert("ethanol"); 
		theTrie.insert("etcetera"); 
		theTrie.insert("ethical"); 
		theTrie.insert("ethically"); 
		theTrie.insert("etruscan"); 
		// theTrie.insert(""); 
		// theTrie.insert(""); 
		// theTrie.insert(""); 

		List forE = theTrie.autoComplete("et"); 

		for (int i = 0; i < forE.size(); i++) {
			System.out.println(forE.get(i));
		} 
	}
}