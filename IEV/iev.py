
domRate = [2.0, 2.0, 2.0, 1.5, 1.0, 0.0]

with open("rosalind_iev.txt", "r") as f:

    nums = [int(x) for x in next(f).split(" ")]
    
with open("output.txt", "w+") as o:

    o.write(str(sum(x[0]*x[1] for x in zip(nums, domRate))))
        
