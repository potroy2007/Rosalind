/******************************************************************************
 *  Compilation:  javac rabbit.java
 *  Execution:    java rabbit
 *  Dependencies: none
 * 
 * model the population growth of rabbits using fib recursion 
 ******************************************************************************/
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class rabbit{
    
    /**public static BigInteger altFib(int n, int k) {
        BigInteger x = BigInteger.valueOf(k);
        if (n <= 1) { return BigInteger.valueOf(n); }
        else { return altFib(n-1, k).add(x.multiply(altFib(n-2, k))); }  
    }**/
    
     public static long altFib(int n, int k) {
    if (n <= 1) { return n; }
    else { return altFib(n-1, k) + k*altFib(n-2, k); }
     }
    
 
    public static void main(String[] args){
        In in = new In(args[0]);
         int n = in.readInt();
         int k = in.readInt();
        //int n =33;
        //int k = 4;
         StdOut.println(altFib(n, k));
    }
}