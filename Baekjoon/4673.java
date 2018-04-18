public class Main {
	static boolean[] sn = new boolean[10036];
	
	public static void main(String[] argv) {
		
		for(int i=1; i<=10000; i++) 
			sn[i] = false;
		
		for(int i=1; i<=10000; i++) {
			sn[self_number(i)] = true;
			if(!sn[i]) System.out.println(i);
		}
	}
	
	private static int self_number(int index) {
		int next = index;
		
		if(index >= 10000) { 
			next += (int)index/10000; index %= 10000; 
		} 
		if(index >= 1000) {
			next += (int)index/1000; index %= 1000; 
		} 
		if(index >= 100) {
			next += (int)index/100; index %= 100; 
		} 
		if(index >= 10) {
			next += (int)index/10; index %= 10; 
		}
		int result = index + next;
		return result;
	}
}
