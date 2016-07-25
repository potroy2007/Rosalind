/******************************************************************************
 *  Compilation:  javac dmotif.java
 *  Execution:    java dmotif
 *  Dependencies: none
 * 
 * substing search of dna motifs 
 ******************************************************************************/
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.*;

public class dMotif{
    /**private final int R;       // the radix
    private int[][] dfa;       // the KMP automoton
    private String pat;        // or the pattern string
    
    public dMotif(String pat){ // construct DFA
        this.pat = pat;
        this.R = 256;
        
        int M = pat.length();
        int[][] dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++)
        { 
            for (int c =0; c < R; c++)
                dfa[c][j] = dfa[c][X];     //copy mismatch cases
            dfa[pat.charAt(j)][j] = j+1;  //set match case
            X = dfa[pat.charAt(j)][X];  //update restart state
        }
    } 
    
    public int search(String txt){
        int i, j;
        int N = txt.length();
        int M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++)
            j = dfa[txt.charAt(i)][j];
        if (j == M) return i-M+1;
        else return N;
} **/
    
    public static int[] search (String txt, String pat){
        int m = txt.length();
        int n = pat.length();
        List<Integer>index = new ArrayList<Integer>();
        for (int i =0; i <= m-n; i++){
            int j;
            for ( j = 0; j < n; j++)
                if (txt.charAt(i+j) != pat.charAt(j)) {
                break; 
            }
            if ( j == n) 
                index.add(i+1);
        }
        int[] result = new int[index.size()];
            int i = 0;
            for (Integer e : index){
                result[i++] = e;
            }
            return result;
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        String txt = in.readString();
        String pat = in.readString();
        //String pat = "ATAT";
        //String txt = "GATATATGCATATACTT";
        int[] result = search(txt, pat);
        for (int i = 0; i < result.length; i++)
            StdOut.print(result[i] + " ");
}
}
    
            
            