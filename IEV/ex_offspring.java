/******************************************************************************
 *  Compilation:  javac ex_offspring.java
 *  Execution:    java ex_offspring
 *  Dependencies: none
 * 
 * calculate expected number of offsprings with dominant phenotype
 ******************************************************************************/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ex_offspring{

public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("rosalind_iev.txt"));
    
    int must_dom = 0;
    for (int i = 0; i < 3; i++)
        must_dom += in.nextInt()*2;
    double Aa_Aa = in.nextInt()*0.75*2;
    int Aa_aa = in.nextInt();
    in.close();
    
    double offspring = must_dom + Aa_Aa + Aa_aa;
    
    System.out.println(offspring);
  }
}