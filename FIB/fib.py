# Given: Positive integers n≤40 and k≤5.
# Return: The total number of rabbit pairs that will be present after n months if we begin with 1 pair and in each generation, every pair of reproduction-age rabbits produces a litter of k rabbit pairs (instead of only 1 pair).

# Sample Dataset
# 5 3

#Sample Output
# 19

def fib(n, k):
    if n <= 1: return n
    else: return fib(n-1, k) +  k*fib(n-2, k)

with open("rosalind_fib.txt", "r") as f:
    n, k = [int(x) for x in next(f).split(" ")] # read the next and only line

with open("output.txt", "w+") as o:
    o.write(str(fib(n,k)))
    
