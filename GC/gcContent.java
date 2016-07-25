/******************************************************************************
 *  Compilation:  javac gcContent.java
 *  Execution:    java gcContent
 *  Dependencies: none
 * 
 * find the DNA sequence with the highest GC %
 ******************************************************************************/
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;

public class gcContent{
    public static Double computeGC(String s){
        int gcCount = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'G' || s.charAt(i) == 'C') { gcCount++; }
        }
        return (double)gcCount/s.length()*100;
    }
public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("rosalind_gc.txt"));
    String line;
    String sequence = "";
    String key = "";
    HashMap<String, Double>gcMap = new HashMap<String, Double>();
    
    while((line = in.readLine()) != null)
    {
        if (line.startsWith(">")) { 
            key = line.replaceAll(">", "");
            sequence = "";
        }
        else { sequence += line; }
        Double value = computeGC(sequence);
        gcMap.put(key, value);
    }
    in.close();
    
    double maxVal = (Collections.max(gcMap.values()));
    String maxKey = null;
    for (Map.Entry<String, Double> entry: gcMap.entrySet()){
        if (entry.getValue() == maxVal) { maxKey = entry.getKey(); }
    }
    System.out.println(maxKey);
    System.out.println(maxVal);
}
}
    