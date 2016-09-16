
from Bio import SeqIO

max_id = ""
max_percent = 0

for seq_record in SeqIO.parse("rosalind_gc.txt", "fasta"):

    sequence = str(seq_record.seq)
    percent = ((sequence.count("C") + sequence.count("G")) / len(sequence)) * 100

    if percent > max_percent:

        max_id = str(seq_record.id)
        max_percent = percent

with open("output.txt", 'w+') as o:
    o.write("{}\n".format(max_id))
    o.write(str(max_percent))
