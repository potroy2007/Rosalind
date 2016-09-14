# An RNA string is a string formed from the alphabet containing 'A', 'C', 'G', and 'U'.
# Given a DNA string tt corresponding to a coding strand, its transcribed RNA string uu is formed by replacing all occurrences of 'T' in tt with 'U' in uu.

# Given: A DNA string tt having length at most 1000 nt.
# Return: The transcribed RNA string of tt.

# Sample Dataset
# GATGGAACTTGACTACGTAAATT

# Sample Output
# GAUGGAACUUGACUACGUAAAUU


from Bio.Seq import Seq
from Bio.Alphabet import IUPAC

with open("rosalind_rna.txt") as f:
        sequence = f.readline()
        
dna = Seq(sequence, IUPAC.unambiguous_dna)
m_rna = dna.transcribe()

with open("output.txt", "w+") as o:
    o.write(str(m_rna))
