package utility.collection;

public class LinkedListTest {
	
	ListADT<String> list = new LinkedList<String>();
	
	public void testAdd() {
		list.add("A");
		list.add("B");
	}
	public void testSet(){
		list.set(3, "D");
	}
	public void testGet(){
		list.get(1);
	}
	public void testRemove(){
		list.remove(3);
		list.remove("C");
	}
	public void testIndexOf(){
		list.indexOf("A");
	}
	public void testContains(){
		list.contains("B");
	}
}
