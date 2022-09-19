package model;

import tests.Node;

public class ListUtilities<E> { 
	public Node<String> shiftedToRightBy(Node<String> head, int n) {
		int size = 0;
		Node<String> current = head;
		Node<String> tail = null;
		while(current != null) {
			size ++;
			tail = current;
			current = current.getNext();
		}
		
		if(size == 0) {
			return null;
		}
		else {
			int nos = n % size; /* number of shifts */
	        int shiftStartsAt = size - nos - 1;
	        
	        if(n == 0 || nos == 0) {
				return head;
			}
			else { 
		        current = head;
		        for(int i = 0; i < shiftStartsAt; i ++) {
		            current = current.getNext();
		        } 
		        Node<String> newHead = current.getNext();
		        current.setNext(null);
		        tail.setNext(head);
		        
		        return newHead;
			}
		} 
    }
	
	public Node<String> removeAllOccurrencesOf(Node<String> head, E e) {
		Node<String> prev = head;
		Node<String> current = head.getNext();
		
		while(prev != null && current != null) {
			if(current.getElement().equals(e)) {
				prev.setNext(current.getNext());
				current.setNext(null);
				
				/* prev stays unchanged */
				current = prev.getNext();
			}
			else {
				prev = current;
				current = current.getNext();
			}
			
		}
		
		if(head.getElement().equals(e)) {
			Node<String> toRemove = head;
			head = toRemove.getNext();
			toRemove.setNext(null);
		}		
		
		return head;
	}
}