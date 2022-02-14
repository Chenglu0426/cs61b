public class SLListUser{
	public static void main(String[] args){
		SLList L = new SLList(10);
		L.addFirst(10);
		L.first.next.next = L.first.next;
	}
}