from Bio import SeqIO
import math

# binary search
# return first substring of given length that is found in all sequences
# add start parameter to avoid searching from zero everytime
def common_substr(seq_0, seqs, start, length):
    # Look at all possible substrings of a given 'length'
    for i in range(len(seq_0) - length + 1):
        substr = seq_0[i:i+length]

        # as soon as we find a sequence that doesn't contain this substring move on to next substring
        # otherwise return this substring
        for seq in seqs:
             if substr not in seq:
                 break
        else:
            return (i, substr)
    return (-1, "")

def longest_common_substr(seqs):
    #pop seq_0 to reduce number of sequences to search and eliminate need to re-extract each time
    seq_0 = seqs.pop()

    ## starting points for the bounds on the longest common substring used in the binary search ##
    low = 0
    # +1 added to allow entire sequence to be the longest common substring
    high = len(seq_0) + 1
    start = 0
    longest_substr = ''

    # repeat until left and right are adjacent
    #   use left + 1, because we've already elimated the right most and we get an endless loop otherwise
    while low + 1 < high:
        # pick midpoint in lengths
        mid = math.floor((low + high)/2)
        idx, substr = common_substr(seq_0, seqs, start, mid)

        # if any substring of length mid is common to all sequneces
        #    look for substrings of this length or longer
        # otherwise look for substrings of this length or less
        # update start
        if idx > -1:
            start = idx
            longest_substr = substr
            low = mid
        else:
            high = mid

    seqs.append(seq_0)
    
    return longest_substr

#parse FASTA file
sequences = []
for record in SeqIO.parse("rosalind_lcsm.txt", "fasta"):
    sequences.append(str(record.seq))
    
with open("output.txt", "w+") as o:
    o.write(longest_common_substr(sequences))
