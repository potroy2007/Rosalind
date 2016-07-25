/******************************************************************************
 *  Compilation:  javac pMutations.java
 *  Execution:    java pMutations
 *  Dependencies: none
 * 
 * counting the number of point mutations between two aligned sequences of same length
 ******************************************************************************/
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class pMutations{
    public static int hamming(String s, String t){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (!(s.charAt(i)==(t.charAt(i)))) { count++; }
        }
        return count;
    }
    
    public static void main(String[] args){
         In in = new In(args[0]);
         String S = in.readLine();
        String T = in.readLine();
            StdOut.println(hamming(S, T));
        }
}