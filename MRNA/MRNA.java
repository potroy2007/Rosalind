/******************************************************************************
 *  Compilation:  javac MRNA.java
 *  Execution:    java MRNA
 *  Dependencies: none
 * 
 * calculate possible number of mRNA sequences from a protein string
 ******************************************************************************/
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class MRNA{
    public static HashMap<Character, Integer> pTable(){
    //construct a dictionary: protein -> numbers of possible codons
        HashMap<Character, Integer> c = new HashMap<Character, Integer>();
        c.put('F', 2); c.put('L', 6); c.put('I', 3); c.put('M', 1); c.put('V', 4);
        c.put('S', 6); c.put('P', 4); c.put('T', 4); c.put('A', 4); c.put('Y', 2); 
        c.put('H', 2); c.put('Q', 2); c.put('N', 2); c.put('K', 2); c.put('D', 2);
        c.put('E', 2); c.put('C', 2); c.put('W', 1); c.put('R', 6); c.put('G', 4);
        return c;
    }
    
      public static void main (String[] args) throws IOException{
        //read in protein string from file
        BufferedReader in = new BufferedReader(new FileReader("rosalind_mrna.txt"));
        String protein = in.readLine();
        in.close();
        
        HashMap<Character, Integer> c = pTable();//construct protein table
        
        BigInteger big = BigInteger.ONE;      //initilize a long to avoid overflow
        for (int i = 0; i < protein.length(); i++){  //find values of pTable for each amino acid, multiply each values gotten
            Character aa = protein.charAt(i);
            int pos = c.get(aa); 
            big = big.multiply(BigInteger.valueOf(pos));
        }
        big = big.multiply(BigInteger.valueOf(3)); //three stop codons
        
        System.out.println(big.remainder(BigInteger.valueOf(1000000)));   //modulo by 1000000
    }
   
}