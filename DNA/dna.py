# A string is simply an ordered collection of symbols selected from some alphabet and formed into a word; the length of a string is the number of symbols that it contains.
# An example of a length 21 DNA string (whose alphabet contains the symbols 'A', 'C', 'G', and 'T') is "ATGCTTCAGAAAGGTCTTACG."

# Given: A DNA string ss of length at most 1000 nt.

# Return: Four integers (separated by spaces) counting the respective number of times that the symbols 'A', 'C', 'G', and 'T' occur in ss.

# Sample Dataset
# AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC

# Sample Output
# 20 12 17 21

def count(s):
    return "{} {} {} {}".format(s.count("A"), s.count("C"), s.count("G"), s.count("T"))
    
if __name__ == "__main__":

    with open("rosalind_dna.txt") as f:
        sequence = f.readline()

    with open("output.txt", 'w+') as o:
        o.write(count(sequence))
    
