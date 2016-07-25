/******************************************************************************
 *  Compilation:  javac orf.java
 *  Execution:    java orf
 *  Dependencies: none
 * 
 * find open reading frames in a sequence
 ******************************************************************************/
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;
import java.util.regex.*;

public class orf{
    
    public static HashMap<String, String> constructDict(){
        HashMap<String, String> c = new HashMap<String, String>();
        
        c.put("ATG", "M"); //Met&Start
        c.put("TTT", "F"); c.put("TTC", "F"); //Phe
        c.put("TTA", "L"); c.put("TTG", "L"); c.put("CTT", "L"); c.put("CTC", "L"); c.put("CTA", "L"); c.put("CTG", "L"); //Leu
        c.put("ATT", "I"); c.put("ATC", "I"); c.put("ATA", "I"); //Ile
        c.put("GTT", "V"); c.put("GTC", "V"); c.put("GTA", "V"); c.put("GTG", "V"); //Val
        c.put("TCT", "S"); c.put("TCC", "S"); c.put("TCA", "S"); c.put("TCG", "S"); c.put("AGT", "S"); c.put("AGC", "S"); //Ser
        c.put("CCT", "P"); c.put("CCC", "P"); c.put("CCA", "P"); c.put("CCG", "P"); //Pro
        c.put("ACT", "T"); c.put("ACC", "T"); c.put("ACA", "T"); c.put("ACG", "T"); //Thr
        c.put("GCT", "A"); c.put("GCC", "A"); c.put("GCA", "A"); c.put("GCG", "A"); //Ala
        c.put("TAT", "Y"); c.put("TAC", "Y"); //Tyr
        c.put("CAT", "H"); c.put("CAC", "H"); //His
        c.put("CAA", "Q"); c.put("CAG", "Q"); //Gln
        c.put("AAT", "N"); c.put("AAC", "N"); //Asn
        c.put("AAA", "K"); c.put("AAG", "K"); //Lys
        c.put("GAT", "D"); c.put("GAC", "D"); //Asp
        c.put("GAA", "E"); c.put("GAG", "E"); //Glu
        c.put("TGT", "C"); c.put("TGC", "C"); //Cys
        c.put("TGG", "W"); //Trp
        c.put("CGT", "R"); c.put("CGC", "R"); c.put("CGA", "R"); c.put("CGG", "R"); c.put("AGA", "R"); c.put("AGG", "R"); //Arg
        c.put("GGT", "G"); c.put("GGC", "G"); c.put("GGA", "G"); c.put("GGG", "G"); //Gly
        c.put("TAA", ""); c.put("TAG", ""); c.put("TGA", ""); //Stop
        
        return c;
    }
    
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
    
    public static ArrayList<String> findStart(String input){
        
        ArrayList<String>start = new ArrayList<String>(); //find all possible start sites ATG
        for (int i = 0; i < input.length()-2; i++){
            if (input.substring(i, i+3).equals("ATG"))
                start.add(input.substring(i));
        }
            return start;
    }
    
    
    public static void main(String[] args) throws IOException{
        HashMap<String, String> c = constructDict();
        BufferedReader in = new BufferedReader(new FileReader("rosalind_orf.txt"));
        String input = "";
        in.readLine(); //skip first line
        String line;
        while((line = in.readLine()) != null)
                input += line; 
        in.close();
        String reverse = rComplement(input);
        
        ArrayList<String> list1 = findStart(input); 
        ArrayList<String> list2 = findStart(reverse); //find possible start sites for reverse complement of the strand
        List<String> start = new ArrayList<String>(list1); //combine the two lists
        start.addAll(list2);
        
       Set<String>d_orf = new HashSet<String>();
        Pattern p = Pattern.compile("ATG(...)*?(TAA|TAG|TGA)"); //regex match all open reading frames
        Matcher m;
        for (int i = 0; i <start.size(); i++){
            m =  p.matcher(start.get(i));
            while (m.find())
                    d_orf.add(m.group());
        }
                
       Set<String>orf = new HashSet<String>();
       StringBuilder sb;
        String codon, sequence;
        
       Iterator<String> i1 = d_orf.iterator(); //translate dna strand into protein through looking up dictionary
       while (i1.hasNext()){
           sb = new StringBuilder();
            sequence = i1.next();
            for (int i = 0; i < sequence.length(); i+=3){
                codon = sequence.substring(i, i+3);
                sb.append(c.get(codon));
            }
            orf.add(sb.toString());
        } 
       
       Iterator<String> i2 = orf.iterator();
       while (i2.hasNext()){
           System.out.println(i2.next()); //print out results
       }
    }
}