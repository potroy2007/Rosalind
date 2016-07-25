/******************************************************************************
 *  Compilation:  javac dmotif.java
 *  Execution:    java dmotif
 *  Dependencies: none
 * 
 * substing search of dna motifs 
 ******************************************************************************/
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

public class consensus{
    
    public static char[][] parse(List<String> sequences){
        int depth = sequences.get(0).length(); //get length of each DNA strings
        char[][] matrix = new char[sequences.size()][depth];
            for (int row = 0; row < sequences.size(); row++) //iterate through rows of matrix
                for (int column = 0; column < depth; column++) //iterate through columns of matrix
            { matrix[row][column] = sequences.get(row).charAt(column); } //fill each matrix position with DNA characters
         return matrix;
    }
    
    public static int[][] profiling (char[][] matrix){
        int depth = matrix[0].length;
        int[][] profile = new int[4][depth];
        int aCount, cCount, gCount, tCount ;
        
        for (int j = 0; j < matrix[0].length; j++){
            aCount = 0; cCount = 0; gCount = 0; tCount = 0;
            for (int i = 0; i < matrix.length; i++){
                if ( matrix[i][j] == 'A') aCount++;
                else if ( matrix[i][j] == 'C') cCount++;
                else if ( matrix[i][j] == 'G') gCount++;
                else if ( matrix[i][j] == 'T') tCount++;
            }
            profile[0][j] = aCount;
            profile[1][j] = cCount;
            profile[2][j] = gCount;
            profile[3][j] = tCount;
        }
        return profile;
    }
    
    public static String consense(int[][] profile){
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < profile[0].length; j++){
                if (profile[0][j] >= profile[1][j] && profile[0][j] >= profile[2][j] &&  profile[0][j] >= profile[3][j]) sb.append("A");
                else if (profile[1][j] >= profile[0][j] && profile[1][j] >= profile[2][j] &&  profile[1][j] >= profile[3][j]) sb.append("C");
                else if (profile[2][j] >= profile[0][j] && profile[2][j] >= profile[1][j] &&  profile[2][j] >= profile[3][j]) sb.append("G");
                else if (profile[3][j] >= profile[0][j] && profile[3][j] >= profile[1][j] &&  profile[3][j] >= profile[2][j]) sb.append("T");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("rosalind_cons.txt"));
        String line;
        String sequence = "";
        List<String> sequences = new ArrayList<String>();
        while((line = in.readLine()) != null)
        {
            if (line.startsWith(">"))
            { sequences.add(sequence);
                sequence = ""; }
            else 
                sequence += line; 
        }
        in.close();
        sequences.remove(0);
        sequences.add(sequence);
       
        char[][] matrix = parse(sequences);
        int[][] profile = profiling(matrix);
        String consensus = consense(profile);
        
        String a = "A: "; String c = "C: "; String g = "G: "; String t = "T: "; 
        for (int j = 0; j < profile[0].length; j++){
            a += (profile[0][j] + " ");
            c += (profile[1][j] + " ");
            g += (profile[2][j] + " ");
            t += (profile[3][j] + " ");
        }
        
        PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
        writer.println(consensus);
        writer.println(a);
        writer.println(c);
        writer.println(g);
        writer.println(t);
        writer.close();
    }
}