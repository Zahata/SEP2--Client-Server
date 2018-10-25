
package utility.collection;


public class BoundedArrayStack<T> implements StackADT<T> {
	private int top;
	private T[] stack;
	
	public BoundedArrayStack(int capacity){
		if(capacity>0){
			top=0;
			stack=(T[])new Object[capacity];
		}
			else    
			{
				System.out.println("Value needs to be greater than 0.");
			}
		}
	public void push(T element) throws IllegalStateException {
		if(top >= stack.length){
			throw new IllegalStateException("Could not push, exceeded capacity");
		}
		else if(element==null){
			throw new IllegalArgumentException("Can`t add null");
		}
		stack[top]=element;
		top++;	
		}
	public T pop()
	{
		if(isEmpty())
			throw new IllegalStateException("Empty");
		T hui=stack[top-1];
		stack[top-1]=null;
		top--;
		return hui;
	}
	public T peek() throws IllegalStateException{
		if(isEmpty()){
			throw new IllegalStateException("Stack is empty");
		}
		return stack[top-1];
	}
	public int indexOf(T element) {
		int index=0;
		for (int i = top - 1; i >= 0; i--) {
			if(stack[i].equals(element)){
				return index;
			}
				index++;
			}
		return -1;
	}
	
	public boolean isFull()
	{
		if(top<stack.length)
			return false;
		return true;
	}
	public boolean isEmpty()
	{
		if(top==0)
			return true;
		return false;
	}
	public int size()
	{
		return top;
	}
	
	public String toString()
	{
		String str="";
		for (int i = 0; i < top; i++) {
			str+=stack[i]+"\n";
		}
		return str;
	}
	
	}
	

