/******************************************************************************
 *  Compilation:  javac countDNA.java
 *  Execution:    java countDNA
 *  Dependencies: none
 * 
 * Count each type of nucleotides
 ******************************************************************************/
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class countDNA{
    
    public static String count(String s){
        String[] n = s.split("");
        int a = 0, t = 0, c = 0, g = 0;
        for (int i = 0; i < n.length; i++){
            if (n[i].equals("A")) { a++; }
            if (n[i].equals("T")) { t++; }
            if (n[i].equals("C")) { c++; }
            if (n[i].equals("G")) { g++; }
        }
        return a + " " + c + " " + g + " " + t;
    }
    
        public static void main(String[] args){
            In in = new In(args[0]);
            String S = in.readString();
            StdOut.println(count(S));
        }
    }
        