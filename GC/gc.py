
from Bio import SeqIO
from Bio.SeqUtils import GC

max_id = ""
max_percent = 0

for record in SeqIO.parse("rosalind_gc.txt", "fasta"):

    if GC(record.seq) > max_percent:

        max_id = str(record.id)
        max_percent = GC(record.seq)

with open("output.txt", 'w+') as o:
    o.write("{}\n".format(max_id))
    o.write(str(max_percent))
