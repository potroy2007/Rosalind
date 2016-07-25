/******************************************************************************
 *  Compilation:  javac RNA.java
 *  Execution:    java RNA
 *  Dependencies: none
 * 
 * convert DNA to RNA
 ******************************************************************************/
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class RNA{
    
    public static void main(String[] args){
           In in = new In(args[0]);
            String S = in.readString();
        StdOut.println(S.replace('T', 'U'));
        }
    }