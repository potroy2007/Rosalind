/******************************************************************************
 *  Compilation:  javac rComp.java
 *  Execution:    java rComp
 *  Dependencies: none
 * 
 * complementing a Strand of DNA
 ******************************************************************************/
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class rComp{
    public static String rComplement(String s){
        String r = new StringBuilder(s).reverse().toString(); //use stringbuilder to reverse strand
        String[] n = r.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length; i++){
            if ( n[i].equals("A")) {sb.append("T"); }
            else if ( n[i].equals("T")) { sb.append("A"); }
            else if ( n[i].equals("C")) { sb.append("G"); }
            else if ( n[i].equals("G")) { sb.append("C");}
        }
        return sb.toString();
    }
        public static void main(String[] args){
        //In in = new In(args[0]);
        //String S = in.readString();
           String S = "AGCCATGTAGCTAACTCAGGTTACATGGGGATGACCCCGCGACTTGGATTAGAGTCTCTTTTGGAATAAGCCTGAATGATCCGAGTAGCATCTCAG";
        StdOut.println(rComplement(S));
        }
}
        