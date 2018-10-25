package utility.collection;

public class BoundedArrayQueue<T> implements QueueADT<T>{
	
	private T[] q;
	private int front,count;
	private int cap;
	
	public BoundedArrayQueue(){
		
	}
	
	public BoundedArrayQueue(int cap){
		q = (T[])(new Object[cap]);
		this.cap=cap;
	}
	@Override
	public void enqueue(T element) {
		if(front >= q.length){
			throw new IllegalStateException("Could not enqueue, exceeded capacity");
		}
		else if(element==null){
			throw new IllegalArgumentException("Can`t add null");
		}
		q[(count+front)%q.length]=element;
		count++;
	}
	@Override
	public T dequeue() {
		if(isEmpty()){
			throw new IllegalStateException("Empty");
		}
		T removeEl=q[front];
		q[front]=null;
		front++;
		if(front>=cap) front=0;
		count--;
		return removeEl;
	}
	@Override
	public T first() {
		if(isEmpty()){
			throw new IllegalStateException("Stack is empty");
		}
		return q[front-1];
	}
	@Override
	public int indexOf(T element) {
		int index=0;
		for (int i = front; i <= q.length; i++) {
			if(q[i].equals(element)){
				return index;
			}
				index++;
			}
		for (int i = 0; i < front; i++) {
			if(q[i].equals(element)){
				return index;
			}
			index++; 
		}
		return -1;
	}
	@Override
	public boolean isEmpty() {
		{
			if(front==0){
				return true;
			}
			return false;
		}
	}
	@Override
	public int size() {
		return count;
	}
	public String toString()
	{  
			   String str = "{";
			   for (int i = front; i < q.length ; i++) {
			      if(q[i] != null && i != count-1) {
			         str += q[i] + ", ";
			      }
			      else if(q[i] != null && i == count-1)
			      {
			         str += q[i];
			      }
			      else if(q[i] == null) {
			         break;
			      }
			   }
			   int rear = (front + count)%q.length;
			   
			   if(rear < front) {
			      for (int i = 0; i < rear; i++) {
			         str += q[i];
			      }
			   }
			   str+="}";
			   return str;
			}
	}


