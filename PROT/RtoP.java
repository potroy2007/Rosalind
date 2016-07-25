/******************************************************************************
 *  Compilation:  javac RtoP.java
 *  Execution:    java RtoP
 *  Dependencies: none
 * 
 * translating to amino acids
 ******************************************************************************/
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class RtoP{
    public static String toProtein(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i = i + 3){
            String codon = s.substring(i, i+3);
            if (codon.equals("UUU")||codon.equals("UUC")) { sb.append("F");}
            else if (codon.equals("UUA")||codon.equals("UUG")||codon.equals("CUU")||codon.equals("CUC")||codon.equals("CUA")||codon.equals("CUG")) { sb.append("L");}
            else if (codon.equals("AUU")||codon.equals("AUC")||codon.equals("AUA")) { sb.append("I");}
            else if (codon.equals("AUG")) { sb.append("M");}
            else if (codon.equals("GUU")||codon.equals("GUC")||codon.equals("GUA")||codon.equals("GUG")) { sb.append("V");}
            else if (codon.equals("UCU")||codon.equals("UCC")||codon.equals("UCA")||codon.equals("UCG")||codon.equals("AGU")||codon.equals("AGC")) { sb.append("S");}
            else if (codon.equals("CCU")||codon.equals("CCC")||codon.equals("CCA")||codon.equals("CCG")) { sb.append("P");}
            else if (codon.equals("ACU")||codon.equals("ACC")||codon.equals("ACA")||codon.equals("ACG")) { sb.append("T");}
            else if (codon.equals("GCU")||codon.equals("GCC")||codon.equals("GCA")||codon.equals("GCG")) { sb.append("A");}
            else if (codon.equals("UAU")||codon.equals("UAC")) { sb.append("Y");}
            else if (codon.equals("CAU")||codon.equals("CAC")) { sb.append("H");}
            else if (codon.equals("CAA")||codon.equals("CAG")) { sb.append("Q");}
            else if (codon.equals("AAU")||codon.equals("AAC")) { sb.append("N");}
            else if (codon.equals("AAA")||codon.equals("AAG")) { sb.append("K");}
            else if (codon.equals("GAU")||codon.equals("GAC")) { sb.append("D");}
            else if (codon.equals("GAA")||codon.equals("GAG")) { sb.append("E");}
            else if (codon.equals("UGU")||codon.equals("UGC")) { sb.append("C");}
            else if (codon.equals("UGG")) { sb.append("W");}
            else if (codon.equals("CGU")||codon.equals("CGC")||codon.equals("CGA")||codon.equals("CGG")||codon.equals("AGA")||codon.equals("AGG")) { sb.append("R");}
            else if (codon.equals("GGU")||codon.equals("GGC")||codon.equals("GGA")||codon.equals("GGG")) { sb.append("G");}
            else if (codon.equals("UAA")||codon.equals("UAG")||codon.equals("UGA")) { break;}
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
            In in = new In(args[0]);
            String S = in.readString();
            StdOut.println(toProtein(S));
        }
}
