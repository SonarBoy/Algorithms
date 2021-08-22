package elementary;

import java.util.NoSuchElementException;

import basicDataStructures.Queue;

public class BST<Key extends Comparable<Key>,Value> {
	
	private class Node<Key, Value> {
		private Key key;
		private Value value;
		
		private Node left;
		private Node right;
		
		private int count;
		
		public Node(Key k, Value v) {
			this.key = k;
			this.value = v;
		}
		
	}
	
	
	private Node root;
	
    public boolean isEmpty() {
        return size() == 0;
    }
    
	public void put(Key key, Value val) {
		root = put(root,key ,val);
	}
	
	private Node put(Node x, Key key, Value val) {
		
		if(x == null) {
			return new Node(key, val);
		}
		
		int compare = key.compareTo((Key)x.key);
			
		if(compare < 0) {
			x.left = put(x.left, key, val);
		}else if(compare > 0) {
			x.right = put(x.right, key, val);
		}else {
			x.value = val;
		}
		
		x.count = 1 + size(x.left) + size(x.right);
		
		return x;
		
	}
	
	public Value get(Key k) {
		Node x = root;
		
		while(x != null) {
			
			int compare = k.compareTo((Key) x.key);
			
			if(compare < 0) {
				x = x.left;
			}else if(compare > 0) {
				x = x.right;
			}else {
				return (Value) x.value;
			}
			
		}
		
		return null;
	}
	
	public Key floor(Key key) {
		Node x = floor(root,key);
		
		if(x == null) {
			return null;
		}else {
			return (Key) x.key;
		}
	}
	
	private Node floor(Node x,Key key){
		
		if(x == null) {
			return null;
		}
		
		int compare = key.compareTo((Key) x.key);
		
		
		if(compare == 0) {
			return x;
		}
		
		if(compare < 0) {
			return floor(x.left, key);
		}
		
		Node tmp = floor(x.right, key);
		
		if(tmp != null) {
			return tmp;
		}else {
			return x;
		}
		
		
	}
	
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return (Key) min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

    /**
     * Returns the largest key in the symbol table.
     *
     * @return the largest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return (Key) max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
		
		if(x.left == null) {
			return x.right;
		}
		
		x.left = deleteMin(x.left);
		
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key){
		
		if(x == null) {
			return null;
		}
		
		int compare = key.compareTo((Key) x.key);
		
		
		if(compare < 0) {
			x.left = delete(x.left, key);
		}else if(compare > 0) {
			x.right = delete(x.right , key);
		}else {
			
			if(x.right == null) {
				return x.left;
			}
			
			if(x.left == null) {
				return x.right;
			}
			
			
			Node t = x;
			x  = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		
		x.count = size(x.left) + size(x.right) + 1;
		
		return x;
	}
	
	
	public int rank(Key key) {
		return rank(key, root);
	}
	
	private int rank(Key key, Node x) {
		
		if(x == null) {
			return 0;
		}
		
		int compare = key.compareTo((Key) x.key);
		
		if(compare < 0) {
			return rank(key,x.left);
		}
		
		if(compare > 0) {
			return 1 + size(x.left) + rank(key, x.right);
		}
		
		
		return size(x.left);
		
	}
	
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		
		if(x == null) {
			return 0;
		}else {
			return x.count;
		}
	}
	
	

	
	public Iterable<Key> iterator(){
		return null;
	}
	
	private void inOrder(Node x, Queue<Key> q) {
		
		if(x == null) {
			return;
		}
		
		inOrder(x.left, q);
		
		q.enqueue((Key) x.key);
		
		inOrder(x.right, q);
		
	}
}
