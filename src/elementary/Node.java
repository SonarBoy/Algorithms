package elementary;

public class Node<Key, Value> {
	private Key key;
	private Value value;
	
	private Node leftLink;
	private Node rightLink;
	
	public Node(Key k, Value v) {
		this.key = k;
		this.value = v;
	}
	
}
