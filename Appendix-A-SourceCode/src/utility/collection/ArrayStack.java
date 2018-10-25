package utility.collection;

public class ArrayStack<T> {
	private int top;
	private T[] stack;
	private static final int DEFAULT_CAPACITY=100;
	
	public ArrayStack(){
		top=0;
		stack=(T[])new Object[100];
	}
	public ArrayStack(int initialCapacity){
		if(initialCapacity>0){
			top=0;
			stack=(T[])new Object[initialCapacity];
		}
			else
			{
				System.out.println("Value needs to be greater than 0.");
			}
		}
	public void expandCapacity(){
		T[] stack1=(T[]) new Object [(stack.length)*2];
		for (int i = 0; i < stack1.length; i++) {
			stack1[i]=stack[i];
		}
		stack=stack1;
	}
	public void push(T element)
	{
		if(top >= stack.length)
		{
			System.out.println("Stack full. Capacity doubled.");
			expandCapacity();
			stack[top]=element;
			top++;	
		}
		else if(element==null)
			throw new IllegalStateException("Cannot add null!");
		else
		{
			stack[top]=element;
			top++;	
		}
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

