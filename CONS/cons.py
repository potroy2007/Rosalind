from Bio import SeqIO

sequences = list()

for record in SeqIO.parse("rosalind_cons.txt", "fasta"):
    sequences.append(record.seq)
    
# construct profile
aCount, tCount, cCount, gCount = 0, 0, 0, 0
a, t, c, g = [], [], [], []

for i in range(len(sequences[0])): # length of all sequences

    for s in sequences:
        if s[i] == 'A': aCount += 1
        elif s[i] == 'T': tCount += 1
        elif s[i] == 'C': cCount += 1
        elif s[i] == 'G': gCount += 1

    a.append(aCount)
    t.append(tCount)
    c.append(cCount)
    g.append(gCount)
    
    aCount, tCount, cCount, gCount = 0, 0, 0, 0 #reset counters
    
# find consensus sequence 
consensus = ""
aStr, tStr, cStr, gStr = "A: ", "T: ", "C: ", "G: "

for i in range(len(a)):

    foo = max(a[i], t[i], c[i], g[i])
    
    if a[i] == foo: consensus += "A"
    elif t[i] == foo: consensus += "T"
    elif c[i] == foo: consensus += "C"
    elif g[i] == foo: consensus += "G"

# format output for profile
    aStr += "{} ".format(a[i])
    tStr += "{} ".format(t[i])
    cStr += "{} ".format(c[i])
    gStr += "{} ".format(g[i])

# write ouput file
with open("output.txt", "w+") as o:
    
    o.write("{}\n{}\n{}\n{}\n{}".format(consensus, aStr, cStr, gStr, tStr))
    
    
    
