package utility.collection;

public class LinkedList<T> implements ListADT<T>{
 private int count;
 private LinearNode<T> front;
 
 public LinkedList() {
		front = new LinearNode<T>(null);
		this.count = 0;
	}

	@Override
	public String toString() {
		LinearNode<T> current = front;
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
	public void add(int index, T element) {
		
		if(index > count || index < 0){
			throw new IllegalStateException("Index out of bounds.");
		}
		if(element == null){
			throw new IllegalArgumentException("Element can not be null.");
		}
		
		LinearNode<T> node = new LinearNode<>(element);
		LinearNode<T> current = front;
		
		for (int i = 0; i <= count; i++) {
			if(i == 0 && i == index){
				node.setNext(current);
				front = node;
				count++;
			}
			else if(i+1 == index){
				node.setNext(current.getNext());
				current.setNext(node);
				count++;
			}
			else{
				current = current.getNext();
			}
		}
	}

	@Override
	public void add(T element) {
		
		if(element == null){
			throw new IllegalArgumentException("Element can not be null.");
		}
		
		LinearNode<T> node = new LinearNode<>(element);
		LinearNode<T> current = front;
		if(count == 0)
		{
			front = node;
		}
		else{
			for (int i = 0; i < count; i++) {
				if(current.getNext() == null){
					current.setNext(node);
					break;
				}
			current = current.getNext();
			}
			
		}
		count++;
	}
	
	private LinearNode<T> getNode(int index){
		LinearNode<T> current = front;
		for (int i = 0; i < count; i++) {
			if(i == index){
				return current;
			}
			else{
				current = current.getNext();
			}
		}
		return null;
	}


	@Override
	public void set(int index, T element) {
		
		if(index >= count || index < 0){
			throw new IllegalStateException("Index out of bounds.");
		}
		if(element == null){
			throw new IllegalArgumentException("Element can not be null.");
		}
		
		LinearNode<T> current = front;
		for (int i = 0; i < count; i++) {
			if(i == index)
			{
				current.setElement(element);
			}
			else{
				current = current.getNext();
			}
		}
		
	}

	@Override
	public T get(int index) {
		if(index >= count || index < 0){
			throw new IllegalStateException("Index out of bounds.");
		}
		return getNode(index).getElement();
	}

	@Override
	public T remove(int index) {
		if(index >= count || index < 0){
			throw new IllegalStateException("Index out of bounds.");
		}
		return remove(getNode(index).getElement());
	}

	@Override
	public T remove(T element) {
		
		LinearNode<T> current = front;
		for (int i = 0; i < count; i++) {
			if(i == 0 && element.equals(current.getElement())){
				if(current.getNext() != null){
					T temp = current.getElement();
					front = (current.getNext());
					count--;
					return temp;
				}
				else{
					T temp = current.getElement();
					front = null;
					count--;
					return temp;
				}
			}
			else if(current.getNext() != null && element.equals(current.getNext().getElement()))
			{
				if(current.getNext().getNext() != null){
					T temp = current.getNext().getElement();
					current.setNext(current.getNext().getNext());
					count--;
					return temp;
				}
				else{
					T temp = current.getNext().getElement();
					current.setNext(null);
					count--;
					return temp;
				}
				
			}
			else if(i != count-1){
				current = current.getNext();
			}
			else{
				throw new IllegalStateException("Element is not in the list.");
			}
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		LinearNode<T> current = front;
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
	public boolean contains(T element) {
		LinearNode<T> current = front;
		for (int i = 0; i < count; i++) {
			if(element.equals(current.getElement()))
			{
				return true;
			}
			else{
				current = current.getNext();
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(count==0){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return count;
	}
	
	
}