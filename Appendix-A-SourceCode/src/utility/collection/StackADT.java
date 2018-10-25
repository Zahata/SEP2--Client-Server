package utility.collection;

public interface StackADT<T> {

	public void push(T element);
	public T pop();
	public T peek();
	public int indexOf(T element);
	public boolean isEmpty();
	public boolean isFull();
	public int size();
	
}
