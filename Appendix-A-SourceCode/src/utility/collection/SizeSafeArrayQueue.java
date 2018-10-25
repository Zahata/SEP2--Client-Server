package utility.collection;

public class SizeSafeArrayQueue<T> implements QueueADT<T>{

	private BoundedArrayQueue<T> queue;
	
	public SizeSafeArrayQueue() {
		queue = new BoundedArrayQueue<T>();
	}
	
	public String toString() {
		return queue.toString();
	}
	
	@Override
	public void enqueue(T element) {
		try {
			queue.enqueue(element);
		}
		catch(IllegalStateException e) {
			BoundedArrayQueue<T> temp = queue;
			queue = new BoundedArrayQueue<T>(2*temp.size());
			
			int size = temp.size();
			for (int i = 0; i < size; i++) {
				queue.enqueue(temp.dequeue());
			}
			queue.enqueue(element);
		}
	}

	@Override
	public T dequeue() {
		return queue.dequeue();
	}

	@Override
	public T first() {
		return queue.first();
	}

	@Override
	public int indexOf(T element) {
		return queue.indexOf(element);
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public int size() {
		return queue.size();
	}

	
}
