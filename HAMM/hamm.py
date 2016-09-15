# Given: Two DNA strings s and t of equal length (not exceeding 1 kbp).
# Return: The Hamming distance dH(s,t).

# Sample Dataset
# GAGCCTACTAACGGGAT
# CATCGTAATGACGGCCT

# Sample Output
# 7

def hamm(s1, s2):
    
    h = 0

    for i in range(len(s1)):
        if s1[i] != s2[i]: h+=1
            
    return h

with open("rosalind_hamm.txt", "r") as f:
    s1 = f.readline()
    s2 = f.readline()
    
with open("output.txt", "w+") as o:
    o.write(str(hamm(s1, s2)))
