package utility.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedSet<T> implements SetADT<T>{

	private int size;
	private LinearNode<T> front;
	
	public LinkedSet() {
		size = 0;
		front = null;
	}
	
	public String toString() {
		LinearNode<T> current = front;
		String str = "";
		
		for (int i = 0; i < size; i++) {
			if(i == size-1){
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
	public Iterator<T> iterator() {
		return new LinkedSetIterator();
	}

	@Override
	public void add(T element) {
		
		if(element == null){
			throw new IllegalArgumentException("Element can not be null.");
		}
		
		LinearNode<T> node = new LinearNode<>(element);
		LinearNode<T> current = front;
		if(size == 0)
		{
			front = node;
		}
		else{
			node.setNext(current);
			front = node;
		}
		size++;
	}

	@Override
	public T remove(T element) {
		LinearNode<T> current = front;
		for (int i = 0; i < size; i++) {
			if(i == 0 && element.equals(current.getElement())){
				if(current.getNext() != null){
					T temp = current.getElement();
					front = (current.getNext());
					size--;
					return temp;
				}
				else{
					T temp = current.getElement();
					front = null;
					size--;
					return temp;
				}
			}
			else if(current.getNext() != null && element.equals(current.getNext().getElement()))
			{
				if(current.getNext().getNext() != null){
					T temp = current.getNext().getElement();
					current.setNext(current.getNext().getNext());
					size--;
					return temp;
				}
				else{
					T temp = current.getNext().getElement();
					current.setNext(null);
					size--;
					return temp;
				}
				
			}
			else if(i != size-1){
				current = current.getNext();
			}
			else{
				throw new IllegalStateException("Elemnt is not in the list.");
			}
		}
		return null;
	}

	@Override
	public boolean contains(T element) {
		LinearNode<T> current = front;
		for (int i = 0; i < size; i++) {
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
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isSubset(SetADT<T> set) {
		LinearNode<T> current = front;
		for (int i = 0; i < size; i++) {
			if(set.contains(current.getElement()))
			{
				current = current.getNext();
			}
			else{
				return false;
			}
		}
		return true;
	}

	@Override
	public SetADT<T> intersection(SetADT<T> set) {
		SetADT<T> intersectionSet = new LinkedSet();
		
		LinearNode<T> current = front;
		for (int i = 0; i < size; i++) {
			if(set.contains(current.getElement()))
			{
				intersectionSet.add(current.getElement());
			}
			current = current.getNext();
		}
		return intersectionSet;
	}

	@Override
	public SetADT<T> union(SetADT<T> set)
	{
		if(set == null)
			throw new IllegalArgumentException("Null pointer argument");
		else{
			LinkedSet<T> resultSet = new LinkedSet<T>();
			
			if(isEmpty())
				resultSet = (LinkedSet<T>)set;
			else if(set.isEmpty())
				resultSet = this;
			else{
				LinkedSet<T> setset = (LinkedSet<T>)set;
				Iterator<T> iterator = setset.iterator();
				LinearNode<T> current = front;
				
				while (iterator.hasNext())
				{
					T temp = iterator.next();
					
					if(!resultSet.contains(temp))
						resultSet.add(temp);
				}
				
				T temp = iterator.next();
				if(!resultSet.contains(temp))
					resultSet.add(temp);
				
				while(current != null)
				{
					if(!resultSet.contains(current.getElement()))
						resultSet.add(current.getElement());	
					current = current.getNext();
				}
			}
				return resultSet;
		}
	}
	
	private class LinkedSetIterator implements Iterator<T>{

		//private int current;
		private LinearNode<T> currentNode;
		
		public LinkedSetIterator() {
			//current = 0;
			currentNode = front;
		}

		@Override
		public boolean hasNext() {

			if(currentNode.getNext() == null) {
				return false;
			}
			return true;
		}

		@Override
		public T next() {
			
			if(hasNext()){
				T temp = currentNode.getElement();
				currentNode = currentNode.getNext();
				return temp;
			}
			else {
				return currentNode.getElement();
			}
		}
	}
}
