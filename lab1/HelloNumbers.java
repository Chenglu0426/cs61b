public class HelloNumbers {
	public static void main(String[] args){
		int x, i;
		x = 0;
		i = 1;
		while (x < 46){
			System.out.println(x);
			x = x + i;
			i = i + 1;
		}
	}
}