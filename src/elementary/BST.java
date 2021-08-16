package elementary;

public class BST<Key extends Comparable<Key>,Value> {
	
	private class Node<Key, Value> {
		private Key key;
		private Value value;
		
		private Node leftLink;
		private Node rightLink;
		
		public Node(Key k, Value v) {
			this.key = k;
			this.value = v;
		}
		
	}
	
	
	private Node root;
	
	
	public void put(Key key, Value val) {
		root = put(root,key ,val);
	}
	
	private Node put(Node x, Key key, Value val) {
		
		if(x == null) {
			return new Node(key, val);
		}
		
		int compare = key.compareTo((Key)x.key);
			
		if(compare < 0) {
			x.leftLink = put(x.leftLink, key, val);
		}else if(compare > 0) {
			x.rightLink = put(x.rightLink, key, val);
		}else {
			x.value = val;
		}
		
		return x;
		
	}
	
	public Value get(Key k) {
		Node x = root;
		
		while(x != null) {
			
			int compare = k.compareTo((Key) x.key);
			
			if(compare < 0) {
				x = x.leftLink;
			}else if(compare > 0) {
				x = x.rightLink;
			}else {
				return (Value) x.value;
			}
			
		}
		
		return null;
	}
	
	public void delete(Key k) {
		
	}
	
	public Iterable<Key> iterator(){
		return null;
	}
}
