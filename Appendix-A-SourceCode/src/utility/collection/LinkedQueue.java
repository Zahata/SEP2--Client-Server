package utility.collection;

public class LinkedQueue<T> implements QueueADT<T>{

	private int count;
	private LinearNode<T> rear;
	
	
	public LinkedQueue() {
		count = 0;
		rear = null;
	}
	
	public String toString() {
		LinearNode<T> current = rear.getNext();
		String str = "";
		
		for (int i = 0; i < count; i++) {
			if(i == count-1){
				str += current.getElement().toString();
			}
			else{
				str += current.getElement().toString() + ", ";
				current = current.getNext();
			}
			
		}
		return str;
	}
	
	@Override
	public void enqueue(T element) {
		if(element == null){
			throw new IllegalArgumentException("Element can not be null.");
		}
		
		LinearNode<T> node = new LinearNode<>(element);
		
		if(count == 0)
		{
			rear = node;
			rear.setNext(rear);
		}
		else{
			node.setNext(rear.getNext());
			rear.setNext(node);
			rear = node;
		}
		count++;
	}

	@Override
	public T dequeue() {
		LinearNode<T> temp = rear.getNext();
		rear.setNext(rear.getNext().getNext());
		count--;
		return (T) temp;
	}

	@Override
	public T first() {
		return (T) rear.getNext();
	}

	@Override
	public int indexOf(T element) {
		LinearNode<T> current = rear.getNext();
		for (int i = 0; i < count; i++) {
			if(element.equals(current.getElement()))
			{
				return i;
			}
			else{
				current = current.getNext();
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}
}
