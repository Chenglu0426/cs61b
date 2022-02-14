public class SLList {

	public class IntNode{
		public int item;
		public IntNode next;
		public StuffNode(int i, IntNode n){
			item = i;
			next = n;
		}
	}

	private IntNode sentinel;
	private int size;
	//private IntNode last;

	public SLList(int x){
		first = new IntNode(x, null);
		size = 1;
	}
	
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	public void addFirst(int x){
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
	}
	public int getFirst(){
		return sentinel.next.item;
	}

	public void addLast(int x){
		size += 1;
		
		StuffNode p = sentinel;
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
		//last.next = new IntNode(x, null);
		//last = last.next;
		

	}

	private static int size(IntNode p){
		if (p.next == null){
			return 1;
		}
		return 1 + size(p.next);
	}

	public int size(){
		return size(first);
	}

	public static void main(String[] args){
		SLList L = new SLList();
		L.addLast(10);
		//L.addFirst(10);
		//L.addFirst(5);
		//L.addLast(20);
		System.out.println(L.size());
		//System.out.println(L.size);

	}
}