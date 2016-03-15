package mueller;

public class test {
	
	public static void halloRekursiv(int n){
		if (n==0) return ;
		System.out.println(n);
		halloRekursiv(n-1);
	}
	
	public static double doubleFaktorial(int n){
		if (n < 0) {
			throw new ArithmeticException("n<0");
		}
		if (n == 0) {
			return 1;
		}
		
		double x = doubleFaktorial(n-1);
		if (Double.MAX_VALUE/n < x) {
			throw new ArithmeticException("zu groß");
		}
		
		return n*x;
	}
	
	public static double longFaktorial(int n){
		if (n < 0) {
			throw new ArithmeticException("n<0");
		}
		if (n == 0) {
			return 1;
		}
		
		double x = doubleFaktorial(n-1);
		if (Long.MAX_VALUE/n < x) {
			throw new ArithmeticException("zu groß");
		}
		
		return n*x;
	}
	
	public static long fibonacci(int n) {
		if (n < 0) {
			throw new ArithmeticException("n < 0");
		}
		if (n == 0 || n == 1) {
			return 1;
		}
		long v1  = fibonacci(n-1);
		long v2  = fibonacci(n-2);
		if (Long.MAX_VALUE-v1 < v2) {
			throw new ArithmeticException("int too big.");
		}
		return v1+v2;
	}
	
	public static void main(String[] args) {
		halloRekursiv(10);
		System.out.println(doubleFaktorial(20));
		System.out.println(longFaktorial(20));
		long startTime = System.currentTimeMillis();
		System.out.println(fibonacci(50));
		long finishTime = System.currentTimeMillis();
		System.out.println("Fibonacci brauchte: "+(finishTime-startTime)+ " ms");

	}

}
