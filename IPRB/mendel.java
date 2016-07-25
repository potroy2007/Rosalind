/******************************************************************************
 *  Compilation:  javac rabbit.java
 *  Execution:    java rabbit
 *  Dependencies: none
 * 
 * model the population growth of rabbits using fib recursion 
 ******************************************************************************/
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class mendel{
    public static double prob(int k, int m, int n){
        double total = k + m + n;
        double hethet = (m/total)*((m-1)/(total-1))*0.25;
        double hetrec = (m/total)*(n/(total-1));
        double recrec = (n/total)*((n-1)/(total-1));
        return 1 - (hethet + hetrec + recrec);
    }
        public static void main(String[] args){
         In in = new In(args[0]);
         int k = in.readInt();
         int m = in.readInt(); 
         int n = in.readInt(); 
         StdOut.println(prob(k,m,n));
    }
}