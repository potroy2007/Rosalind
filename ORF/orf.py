from Bio import SeqIO
from Bio.Seq import Seq
from Bio.Alphabet import IUPAC
import re

for record in SeqIO.parse("rosalind_orf.txt", "fasta"):
    seq = str(record.seq)
    rcomplement_seq = str(record.seq.reverse_complement())
# find all indexes of potential start sites
start_sites = [m.start() for m in re.finditer(r'ATG', seq)]
r_start_sites = [m.start() for m in re.finditer(r'ATG', rcomplement_seq)] # Reverse complement

# use start sites indexes to obtain dna strings
potential_orfs = []
for p in start_sites:
    potential_orfs.append(seq[p:])
for p in r_start_sites:
    potential_orfs.append(rcomplement_seq[p:])

# find all orf dna fragments
dna_orfs = []
for e in potential_orfs:
    match = re.search(r'ATG(...)*?(TAG|TGA|TAA)', e)
    if match:
        dna_orfs.append(match.group())

# translate dna and eliminate duplicates using set
peptide_orfs = set()
for e in dna_orfs:
    dna_seq = Seq(e, IUPAC.unambiguous_dna)
    peptide_orfs.add(str(dna_seq.translate(to_stop = True)))

with open("output.txt", "w+") as o:
    for e in peptide_orfs:
        o.write(e + "\n")
