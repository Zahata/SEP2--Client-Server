package utility.collection;

public class LinkedTest {
 public static void main(String [] args){
	 LinkedList<String> list = new LinkedList<String>();
	 
	list.add("A");
	list.add("B");
	list.add("C");
	list.add(1, "D");
	System.out.println(list.toString());

 }
}
