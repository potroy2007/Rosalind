#In DNA strings, symbols 'A' and 'T' are complements of each other, as are 'C' and 'G'.
#The reverse complement of a DNA string ss is the string scsc formed by reversing the symbols of ss, then taking the complement of each symbol (e.g., the reverse complement of "GTCA" is "TGAC").

#Given: A DNA string ss of length at most 1000 bp.
#Return: The reverse complement scsc of ss.

#Sample Dataset
#AAAACCCGGT

#Sample Output
#ACCGGGTTTT

from Bio.Seq import Seq
from Bio.Alphabet import IUPAC

with open("rosalind_revc.txt", 'r') as f:
    sequence = f.readline()

sequence = Seq(sequence, IUPAC.unambiguous_dna)
rcomplemented_seq = sequence.reverse_complement()

with open("output.txt", 'w+') as o:
    o.write(str(rcomplemented_seq))
