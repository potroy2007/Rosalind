/******************************************************************************
 *  Compilation:  javac proteinMass.java
 *  Execution:    java proteinMass
 *  Dependencies: none
 * 
 * calculate the atomic mass of a peptide chain from a given DNA sequence
 ******************************************************************************/
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;

public class proteinMass{
    
    public static double computeMass(String line){
    HashMap<Character, Double>pMass = new HashMap<Character, Double>();
        pMass.put ('A', 71.03711); pMass.put ('C', 103.00919); pMass.put ('D', 115.02694); pMass.put ('E', 129.04259);
        pMass.put ('F', 147.06841); pMass.put ('G', 57.02146); pMass.put ('H', 137.05891); pMass.put ('I', 113.08406);
        pMass.put ('K', 128.09496); pMass.put ('L', 113.08406); pMass.put ('M', 131.04049); pMass.put ('N', 114.04293);
        pMass.put ('P', 97.05276); pMass.put ('Q', 128.05858); pMass.put ('R', 156.10111); pMass.put ('S', 87.03203);
        pMass.put ('T', 101.04768); pMass.put ('V', 99.06841); pMass.put ('W', 186.07931); pMass.put ('Y', 163.06333);
        
        double mass = 0;
        for (int i = 0; i < line.length(); i++)
            mass += pMass.get(line.charAt(i));
        return mass;
    }
           
    public static void main(String args[]) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("rosalind_prtm.txt"));
        String line = in.readLine();
        in.close();
        System.out.printf("%.3f%n", computeMass(line));
    }
}
        
        
        
         