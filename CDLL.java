

public class CDLL
	{
	    private Node current = null;
	    private int size = 0;
	    Node head = null;
	    Node tail = null;
	    /* Insert creates a new node and puts in front of the current Node
	     * The new node inserted becomes the list’s “current” Node
	     */
	    
	    public void insert(int data)
	    {
	    	Node newNode = new Node();
	    	newNode.data = data;
	    	
	    	if (size == 0){	
	    		newNode.next = null;
	    		newNode.previous = null;
	    		head = newNode;
	    		tail = newNode; }
	    	else{
	    		newNode.next = current;
	    		newNode.previous = tail;
	    		current.previous = newNode;
	    		tail.next = newNode;
	    		head = newNode;	} 
	    	
	    	current = newNode;
	    	size ++; }

	    /* Search starts from the current location and looks
	     * for the given data value. If the Node is found, it
	     * returns the Node. Otherwise, it returns null
	     */
	    public Node search(int data)
	    {
	    	Node temp = head;
	    	int count = 0;
	    	
	    	while (temp != null & count < size){
	    		if (temp.data == data){
	    			current = temp;
	    			return temp; }
	    		temp = temp.next;
	    		count++; }
	    	return null; }

	    /* Update searches for the given oldData value.
	     * If the Node is found, it changes the node value to
	     * newValue and returns true. Otherwise, it returns false
	     * If the node is found, that node also becomes
	     * the current Node
	     */
	    public boolean update(int oldValue, int newValue)
	    {
	    	Node temp = search(oldValue);
	    	
	    	if (temp == null)
	    		return false;
	    	temp.data = newValue;
	    	current = temp;
	    	return true;
	    }

	    /* Delete searches for the given data value.
	     * If the Node is found, it removes the node
	     * from the list and returns true. Otherwise, it
	     * returns false. If a node is removed, the
	     * next node becomes the current Node
	     */
	    public boolean delete(int data)
	    {
	    	Node temp = search(data);
	    
	    	if (temp == null){
	    		return false;}
	    	
	    	if (temp != null && size == 1){
	    		head = null;
	    		tail = null;
	    		temp.next = null;
	    		temp.previous = null;
	    		size--;
	    		return true; }
	    	else {
	    		Node previous = temp.previous;
	    		Node next = temp.next;
	    		previous.next = temp.next;
	    		next.previous = temp.previous;
	    		next.previous = previous;
	    		current = temp.next;
	    		size --;
	    		return true; }
	    	}

	    /* getCurrent returns the current Node in the list
	     * If the list is empty, it returns null
	     */
	    
	    public Node getCurrent()
	    {
	    	if (size == 0){
	    		return null;}	
	    	else{
	    	return current;}		
	    }

	    /* print displays all Nodes in order from the current
	     * node in the list using the “next” node pointers
	     * of each node
	     */
	    
	    public void print()
	    {
	    	int count = 0;
	    	Node temp = current;
	    	while (temp != null && count < size){
	    		System.out.println(" " + temp.data);
	    		temp = temp.next;
	    		count++; }
	    }
	    	

	    /* print displays all Nodes in order from the current
	     * node in the list using the “previous” node pointers
	     * of each node
	     */
	    public void printReverse()
	    {
	    	int count = 0;
	    	Node temp = current;
	    	while (temp != null && count < size){
	    		System.out.println(" " + temp.data);
	    		temp = temp.previous;
	    		count++; }
	    }
	}



