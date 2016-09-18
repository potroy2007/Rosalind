from Bio.Seq import Seq
from Bio.Alphabet import IUPAC

with open("rosalind_prot.txt", "r") as f:
    sequence = f.readline()

messenger_rna = Seq(sequence, IUPAC.unambiguous_rna)
peptide = messenger_rna.translate(to_stop = True)

with open("output.txt", "w+") as o:
    o.write(str(peptide))
