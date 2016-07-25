# ******************************************************************************
 #  Compilation:  javac orf.java
 #  Execution:    java orf
 #  Dependencies: none
 # 
 # find open reading frames in a sequence
# *****************************************************************************

#Step1: translate DNA to peptide strand
def translate(exon):
    protein_dict = {'ATG':'M', 'TTT':'F', 'TTC':'F', 'TTA':'L', 'TTG':'L', 'CTT':'L','CTC':'L',
                    'CTA':'L', 'CTG':'L', 'ATT':'I', 'ATC':'I', 'ATA':'I', 'GTT':'V',
                    'GTC':'V', 'GTA':'V', 'GTG':'V', 'TCT':'S', 'TCC':'S', 'TCA':'S',
                    'TCG':'S', 'AGT':'S', 'AGC':'S', 'CCT':'P', 'CCC':'P', 'CCA':'P',
                    'CCG':'P', 'ACT':'T', 'ACC':'T', 'ACA':'T', 'ACG':'T', 'GCT':'A',
                    'GCC':'A', 'GCA':'A', 'GCG':'A', 'TAT':'Y', 'TAC':'Y', 'CAT':'H',
                    'CAC':'H', 'CAA':'Q', 'CAG':'Q', 'AAT':'N', 'AAC':'N', 'AAA':'K',
                    'AAG':'K', 'GAT':'D', 'GAC':'D', 'GAA':'E', 'GAG':'E', 'TGT':'C',
                    'TGC':'C', 'TGG':'W', 'CGT':'R', 'CGC':'R', 'CGA':'R', 'CGG':'R',
                    'AGA':'R', 'AGG':'R', 'GGT':'G', 'GGC':'G', 'GGA':'G', 'GGG':'G',
                    'TAA':'', 'TAG':'', 'TGA':''} #construct a DNA to AA dictionary
    
    peptide_chain = list()
    for n in range(0, len(exon)-2, 3):
        codon = exon[n:n+3]
        peptide_chain.append(protein_dict[codon]) #get value from dict
    
    return ''.join(peptide_chain)    

#Step2: read in data, parse FASTA format and store DNA strings in list
def get_seqs(file):
    sequences = list()
    seq = list()
    index = 0
    for line in file:
        if line.startswith('>'):
            if index >= 1: #skip the first id of fasta file
                sequences.append(''.join(seq))
                seq = []
            index += 1
        else:
            seq.append(line[:-1]) #avoid redundant string object creation
    sequences.append(''.join(seq)) #append last sequence in file
    return sequences

#Step 3: splice out the introns using regex
def splice(sequences):
    DNA = sequences[0]
    introns = sequences[1:]
    for i in introns:
       DNA = DNA.replace(i, '')
    return DNA

if __name__ == "__main__":
    input = open('rosalind_splc.txt', 'r')
    sequences = get_seqs(input)
    input.close()
    exon = splice(sequences)
    protein = translate(exon)
    output = open('output.txt', 'w+')
    output.write(protein)
    output.close()
    
            



