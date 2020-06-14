package basicDataStructures;

public class ListNode<AnyType> {
	
	AnyType data;
	
	ListNode<AnyType> next;
	
	ListNode<AnyType> prev;
	
    /**
     * Constructor.
     * Note that the next and prev variables are set to null, 
     * thus this is the "root-node"
     *
     * @param data node data
     */
	ListNode(ListNode<AnyType> prev, AnyType Data, ListNode<AnyType> next){
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	
    /**
     * Constructor.
     *
     * @param data node data
     * @param next reference to next node
     * @param prev reference to the previous node
     */
	ListNode(AnyType data){
		this(null, data, null);
	}
}
