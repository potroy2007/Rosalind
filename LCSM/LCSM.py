from Bio import SeqIO

def lcs(strings):
    for k in range(len(strings[0]),1,-1): #right decrement by 1 each cycle
        for start in range(len(strings[0])-k+1):
            curr = strings[0][start:start+k]
            found = True
            for s in strings[1:]:
                if curr not in s:
                    found = False
                    break
            if found:
                return curr

#parse FASTA file
sequences = []
for record in SeqIO.parse("rosalind_lcsm.txt", "fasta"):
    sequences.append(str(record.seq))
    
common_motif = lcs(sequences)
output = open('output.txt', 'w+')
output.write(common_motif)
output.close()
