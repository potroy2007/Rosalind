
with open("rosalind_subs.txt", "r") as f:
    sequence, motif = f.read().split()

indexes = list() # to store matching locations

index = sequence.find(motif) # initial match
indexes.append(index+1)

while index != -1:
   index = sequence.find(motif, index+1)
   indexes.append(index+1)

indexes.pop()

with open("output.txt", "w+") as o:
    for e in indexes:
        o.write("{} ".format(str(e)))
